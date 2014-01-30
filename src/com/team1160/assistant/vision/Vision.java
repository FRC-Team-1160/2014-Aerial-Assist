package com.team1160.assistant.vision;

import com.team1160.assistant.RobotMap;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.*;

/* -insert long warning here regarding this class-
 * 
 * 
 * ..you have been warned. */
public class Vision extends Subsystem implements RobotMap {

    AxisCamera camera;
    CriteriaCollection cc;
    public boolean autonomous;
    protected static Vision instance = null;

    protected void initDefaultCommand() {
        this.setDefaultCommand(null);
    }

    public static class Scores {

        final double rectangularity, aspectRatioVertical,
                aspectRatioHorizontal;

        public Scores(double rectangularity, double aspectRatioVertical,
                double aspectRatioHorizontal) {
            this.rectangularity = rectangularity;
            this.aspectRatioVertical = aspectRatioVertical;
            this.aspectRatioHorizontal = aspectRatioHorizontal;
        }

        public Scores(BinaryImage filteredImage,
                ParticleAnalysisReport report, int index)
                throws NIVisionException {
            this(scoreRectangularity(report), scoreAspectRatio(
                    filteredImage, report, index, true), scoreAspectRatio(
                    filteredImage, report, index, false));
        }

        /**
         * Compares these scores to defined limits and returns true if the
         * particle appears to be a target
         *
         * @param scores The structure containing the scores to compare
         * @param outer True if the particle should be treated as an outer
         * target, false to treat it as a center target
         * @return True if the particle meets all limits, false otherwise
         */
        public boolean isTarget(boolean vertical) {
            if (rectangularity <= RECTANGULARITY_LIMIT) {
                return false;
            }
            return (vertical ? aspectRatioVertical : aspectRatioHorizontal) > ASPECT_RATIO_LIMIT;
        }

        /**
         * Computes a score (0-100) comparing the aspect ratio to the ideal
         * aspect ratio for the target. This method uses the equivalent
         * rectangle sides to determine aspect ratio as it performs better as
         * the target gets skewed by moving to the left or right. The equivalent
         * rectangle is the rectangle with sides x and y where particle area=
         * x*y and particle perimeter = 2x+2y
         *
         * @param image The image containing the particle to score, needed to
         * perform additional measurements
         * @param report The Particle Analysis Report for the particle, used for
         * the width, height, and particle number
         * @param outer Indicates whether the particle aspect ratio should be
         * compared to the ratio for the inner target or the outer
         * @return The aspect ratio score (0-100)
         */
        public static double scoreAspectRatio(BinaryImage image,
                ParticleAnalysisReport report, int particleNumber,
                boolean vertical) throws NIVisionException {
            double rectLong, rectShort, aspectRatio, idealAspectRatio;
            rectLong = NIVision
                    .MeasureParticle(
                    image.image,
                    particleNumber,
                    false,
                    NIVision.MeasurementType.IMAQ_MT_EQUIVALENT_RECT_LONG_SIDE);
            rectShort = NIVision
                    .MeasureParticle(
                    image.image,
                    particleNumber,
                    false,
                    NIVision.MeasurementType.IMAQ_MT_EQUIVALENT_RECT_SHORT_SIDE);
            idealAspectRatio = vertical ? (4.0 / 32) : (23.5 / 4);
            // Vertical reflector 4" wide x 32" tall, horizontal
            // 23.5" wide x 4"
            // tall... Divide width by height to measure aspect ratio
            if (report.boundingRectWidth > report.boundingRectHeight) {
                // particle is wider than it is tall, divide long by short
                aspectRatio = ratioToScore((rectLong / rectShort)
                        / idealAspectRatio);
            } else {
                // particle is taller than it is wide, divide short by long
                aspectRatio = ratioToScore((rectShort / rectLong)
                        / idealAspectRatio);
            }
            return aspectRatio;
        }
    }

    public static class TargetReport {

        int verticalIndex = 0, horizontalIndex = 0;
        double totalScore = 0, leftScore = 0, rightScore = 0,
                tapeWidthScore = 0, verticalScore = 0;

        /**
         * Takes in a report on a target and compares the scores to the defined
         * score limits to evaluate if the target is a hot target or not.
         * Returns True if the target is hot. False if it is not.
         */
        boolean isHot() {
            if (this.tapeWidthScore < TAPE_WIDTH_LIMIT) {
                return false;
            }
            if (this.verticalScore < VERTICAL_SCORE_LIMIT) {
                return false;
            }
            return (this.leftScore > LR_SCORE_LIMIT)
                    || (this.rightScore > LR_SCORE_LIMIT);
        }
    };

    public static Vision getInstance() {
        if (instance == null) {
            instance = new Vision();
        }
        return instance;
    }

    public Vision() {
        camera = AxisCamera.getInstance(); // get an instance of the camera
        cc = new CriteriaCollection(); // create the criteria for the particle
        // filter
        cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_AREA, AREA_MINIMUM,
                65535, false);
    }

    double computeDistance(BinaryImage image, ParticleAnalysisReport report,
            int particleNumber) throws NIVisionException {
        double rectLong = NIVision.MeasureParticle(image.image,
                particleNumber, false,
                NIVision.MeasurementType.IMAQ_MT_EQUIVALENT_RECT_LONG_SIDE);
        // using the smaller of the estimated rectangle long side and the
        // bounding rectangle height results in better performance
        // on skewed rectangles
        double height = Math.min(report.boundingRectHeight, rectLong);
        int targetHeight = 32;
        return Y_IMAGE_RES
                * targetHeight
                / (height * 12 * 2 * Math.tan(VIEW_ANGLE * Math.PI
                / (180 * 2)));
    }

    /**
     * Computes a score (0-100) estimating how rectangular the particle is by
     * comparing the area of the particle to the area of the bounding box
     * surrounding it. A perfect rectangle would cover the entire bounding box.
     *
     * @param report The Particle Analysis Report for the particle to score
     * @return The rectangularity score (0-100)
     */
    static double scoreRectangularity(ParticleAnalysisReport report) {
        if (report.boundingRectWidth * report.boundingRectHeight != 0) {
            return 100
                    * report.particleArea
                    / (report.boundingRectWidth * report.boundingRectHeight);
        } else {
            return 0;
        }
    }

    /**
     * Converts a ratio with ideal value of 1 to a score. The resulting function
     * is piecewise linear going from (0,0) to (1,100) to (2,0) and is 0 for all
     * inputs outside the range 0-2
     */
    private static double ratioToScore(double ratio) {
        return 100 * Math.max(0, 1 - Math.abs(1 - ratio));
    }

    public void vision() {
        System.out.println("Vision code STARTED! Good Luck!");
        int verticalTargets[] = new int[MAX_PARTICLES];
        int horizontalTargets[] = new int[MAX_PARTICLES];
        int verticalTargetCount, horizontalTargetCount;
        while (autonomous) {
            try {
                ColorImage image = camera.getImage();
                BinaryImage thresholdImage = image.thresholdHSV(136, 182,
                        45, 255, 116, 255);
                thresholdImage.write("/threshold.bmp");
                BinaryImage filteredImage = thresholdImage
                        .particleFilter(cc);
                filteredImage.write("/filteredImage.bmp");
                // iterate through each particle and score to see if it is a
                // target
                if (filteredImage.getNumberParticles() <= 0) {
                    filteredImage.free();
                    thresholdImage.free();
                    image.free();
                    continue;
                }
                Scores scores[] = new Scores[Math
                        .min(filteredImage.getNumberParticles(),
                        MAX_PARTICLES)];
                horizontalTargetCount = verticalTargetCount = 0;
                for (int i = 0; i < scores.length; i++) {
                    ParticleAnalysisReport report = filteredImage
                            .getParticleAnalysisReport(i);
                    scores[i] = new Scores(filteredImage, report, i);
                    // Score each particle on rectangularity and
                    // aspect ratio
                    // Check if the particle is a horizontal target,
                    // if not, check if it's a vertical target
                    if (scores[i].isTarget(false)) {
                        System.out.println("particle: " + i
                                + "is a Horizontal Target centerX: "
                                + report.center_mass_x + "centerY: "
                                + report.center_mass_y);
                        horizontalTargets[horizontalTargetCount++] = i;
                        // Add particle to target array and increment
                        // count
                    } else if (scores[i].isTarget(true)) {
                        System.out.println("particle: " + i
                                + "is a Vertical Target centerX: "
                                + report.center_mass_x + "centerY: "
                                + report.center_mass_y);
                        verticalTargets[verticalTargetCount++] = i;
                        // Add particle to target array and increment
                        // count
                    } else {
                        System.out.println("particle: " + i
                                + "is not a Target centerX: "
                                + report.center_mass_x + "centerY: "
                                + report.center_mass_y);
                    }
                    System.out.println("rect: " + scores[i].rectangularity
                            + "ARHoriz: "
                            + scores[i].aspectRatioHorizontal);
                    System.out.println("ARVert: "
                            + scores[i].aspectRatioVertical);
                }
                // Set verticalIndex to first target in case there are no
                // horizontal targets
                TargetReport target = new TargetReport();
                target.verticalIndex = verticalTargets[0];
                for (int i = 0; i < verticalTargetCount; i++) {
                    ParticleAnalysisReport verticalReport = filteredImage
                            .getParticleAnalysisReport(verticalTargets[i]);
                    for (int j = 0; j < horizontalTargetCount; j++) {
                        ParticleAnalysisReport horizontalReport = filteredImage
                                .getParticleAnalysisReport(horizontalTargets[j]);
                        TargetReport targetCur = getTargetReport(
                                filteredImage, verticalTargets[i],
                                horizontalTargets[j], verticalReport,
                                horizontalReport);
                        // If the target is the best detected so far
                        // store the information about it
                        if (targetCur.totalScore > target.totalScore) {
                            target = targetCur;
                        }
                    }
                }
                if (verticalTargetCount > 0) {
                    // Information about the target is contained in the
                    // "target" structure
                    // To get measurement information such as sizes or
                    // locations use the
                    // horizontal or vertical index to get the
                    // particle report as shown below
                    ParticleAnalysisReport distanceReport = filteredImage
                            .getParticleAnalysisReport(target.verticalIndex);
                    double distance = computeDistance(filteredImage,
                            distanceReport, target.verticalIndex);
                    if (target.isHot()) {
                        System.out.println("Hot target located");
                        System.out.println("Distance: " + distance + "in");
                    } else {
                        System.out.println("No hot target present");
                        System.out.println("Distance: " + distance + "in");
                    }
                }
                /**
                 * all images in Java must be freed after they are used since
                 * they are allocated out of C data structures. Not calling
                 * free() will cause the memory to accumulate over each pass of
                 * this loop.
                 */
                filteredImage.free();
                thresholdImage.free();
                image.free();
            } catch (AxisCameraException ex) {
                // this is needed if the camera.getImage() is called
                ex.printStackTrace();
            } catch (NIVisionException ex) {
                ex.printStackTrace();
            }
        }
    }

    private TargetReport getTargetReport(Image filteredImage,
            int verticalIndex, int horizontalIndex,
            ParticleAnalysisReport verticalReport,
            ParticleAnalysisReport horizontalReport)
            throws NIVisionException {
        TargetReport t = new TargetReport();
        // Measure equivalent rectangle sides for use
        // in score calculation
        t.horizontalIndex = horizontalIndex;
        t.verticalIndex = verticalIndex;
        double horizWidth = NIVision.MeasureParticle(filteredImage.image,
                horizontalIndex, false,
                NIVision.MeasurementType.IMAQ_MT_EQUIVALENT_RECT_LONG_SIDE);
        double vertWidth = NIVision
                .MeasureParticle(
                filteredImage.image,
                verticalIndex,
                false,
                NIVision.MeasurementType.IMAQ_MT_EQUIVALENT_RECT_SHORT_SIDE);
        double horizHeight = NIVision
                .MeasureParticle(
                filteredImage.image,
                horizontalIndex,
                false,
                NIVision.MeasurementType.IMAQ_MT_EQUIVALENT_RECT_SHORT_SIDE);
        // Determine if the horizontal target is in
        // the expected location to the left of the
        // vertical target
        t.leftScore = ratioToScore(1.2
                * (verticalReport.boundingRectLeft - horizontalReport.center_mass_x)
                / horizWidth);
        // Determine if the horizontal target is in
        // the expected location to the right of the
        // vertical target
        t.rightScore = ratioToScore(1.2
                * (horizontalReport.center_mass_x
                - verticalReport.boundingRectLeft - verticalReport.boundingRectWidth)
                / horizWidth);
        // Determine if the width of the tape on the
        // two targets appears to be the same
        t.tapeWidthScore = ratioToScore(vertWidth / horizHeight);
        // Determine if the vertical location of the
        // horizontal target appears to be correct
        t.verticalScore = ratioToScore(1
                - (verticalReport.boundingRectTop - horizontalReport.center_mass_y)
                / (4 * horizHeight));
        t.totalScore = Math.max(t.leftScore, t.rightScore) + t.tapeWidthScore
                + t.verticalScore;
        return t;
    }

    public void stahp() {
        System.out.println("Camera proccessing complete.");
    }
}