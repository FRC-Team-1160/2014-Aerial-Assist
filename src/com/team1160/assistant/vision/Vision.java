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
	public Executor exec;
	protected static Vision instance = null;
	private BinaryImage thresholdImage;
	private BinaryImage filteredImage;
	private ColorImage image;
	public static Vision getInstance() {
		if (instance == null) {
			instance = new Vision();
		}
		return instance;
	}
	public Vision() {
		camera = AxisCamera.getInstance();
		cc = new CriteriaCollection();
		// create the criteria for the particle filter
		cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_AREA, AREA_MINIMUM,
				65535, false);
		exec = new Executor();
	}
	protected void initDefaultCommand() {
		this.setDefaultCommand(null);
	}
	public void vision() {
		exec.startVision();
		int verticalTargets[] = new int[MAX_PARTICLES];
		int horizontalTargets[] = new int[MAX_PARTICLES];
		while (autonomous) {
			try {
				image = camera.getImage();
				thresholdImage = image.thresholdHSV(136, 182, 45, 255, 116,
						255);
				thresholdImage.write("/threshold.bmp");
				filteredImage = thresholdImage.particleFilter(cc);
				filteredImage.write("/filteredImage.bmp");
				// iterate through each particle and score to see if it is a
				// target
				if (filteredImage.getNumberParticles() <= 0) {
					freeImages();
					continue;
				}
				// iterate through each particle and score to see if it is a
				// target
				Scores scores[] = new Scores[Math
						.min(filteredImage.getNumberParticles(),
								MAX_PARTICLES)];
				ParticleAnalysisReport[] reports = new ParticleAnalysisReport[scores.length];
				int horizontalTargetCount = 0, verticalTargetCount = 0;
				for (int i = 0; i < scores.length; i++) {
					reports[i] = filteredImage
							.getParticleAnalysisReport(i);
					scores[i] = new Scores(filteredImage, reports[i], i);
					// Check if the particle is a horizontal target,
					// if not, check if it's a vertical target
					if (scores[i].isTarget(false)) {
						exec.horizontalTargetFound(i,
								reports[i].center_mass_x,
								reports[i].center_mass_y);
						horizontalTargets[horizontalTargetCount++] = i;
						// Add particle to target array and increment
						// count
					} else if (scores[i].isTarget(true)) {
						exec.verticalTargetFound(i,
								reports[i].center_mass_x,
								reports[i].center_mass_y);
						verticalTargets[verticalTargetCount++] = i;
						// Add particle to target array and increment
						// count
					} else {
						exec.noTargetFound(i, reports[i].center_mass_x,
								reports[i].center_mass_y);
					}
					exec.scoreCalculated(scores[i]);
				}
				// Set verticalIndex to first target in case there are no
				// horizontal targets
				TargetReport target = new TargetReport(verticalTargets[0]);
				for (int i = 0; i < verticalTargetCount; i++) {
					for (int j = 0; j < horizontalTargetCount; j++) {
						TargetReport targetCur = new TargetReport(
								filteredImage, verticalTargets[i],
								horizontalTargets[j],
								reports[verticalTargets[i]],
								reports[horizontalTargets[j]]);
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
					double distance = computeDistance(filteredImage,
							reports[target.verticalIndex],
							target.verticalIndex);
					exec.bestTargetFound(target.isHot(), distance);
				}
				freeImages();
			} catch (AxisCameraException ex) {
				// this is needed if the camera.getImage() is called
				ex.printStackTrace();
			} catch (NIVisionException ex) {
				ex.printStackTrace();
			}
		}
	}
	/** All images in Java must be freed after they are used
	 * since they are allocated out of C data structures. Not
	 * calling free() will cause the memory to accumulate over
	 * each pass of this loop. */
	private void freeImages() throws NIVisionException {
		filteredImage.free();
		thresholdImage.free();
		image.free();
	}
	public void stahp() {
		exec.cameraComplete();
	}
	private static double computeDistance(BinaryImage image,
			ParticleAnalysisReport report, int particleNumber)
			throws NIVisionException {
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
	/** Converts a ratio with ideal value of 1 to a score. The resulting
	 * function
	 * is piecewise linear going from (0,0) to (1,100) to (2,0) and is 0 for
	 * all
	 * inputs outside the range 0-2 */
	public static double ratioToScore(double ratio) {
		return 100 * Math.max(0, 1 - Math.abs(1 - ratio));
	}
	/** Class that executes commands carried out by the main Vision class. This
	 * is really an attempt to get all of the execution code in one place so we
	 * won't have to hunt for it when this class does something more than print
	 * stuff. */
	public static class Executor {// TODO Class only outputs information. Does
							// not actually *do* anything.
		/** Tell the executor that vision code has started */
		public void startVision() {
			output("Vision code STARTED! Good Luck!");
		}
		/** Tell the executor that the camera proscessing is complete */
		public void cameraComplete() {
			output("Camera proccessing complete.");
		}
		/** Tell the executor that the best target has been found */
		public void bestTargetFound(boolean hot, double distance) {
			output(hot ? "Hot target located" : "No hot target present");
			output("Distance: " + distance + "in");
		}
		/** Tell the executor that a score has been calculated */
		public void scoreCalculated(Scores score) {
			output(score.toString());
		}
		/** Tell the executor that no target has been found */
		public void noTargetFound(int index, int centerX, int centerY) {
			output("particle: " + index + "is not a Target centerX: "
					+ centerX + "centerY: " + centerY);
		}
		/** Tell the executor that a vertical target has been found */
		public void verticalTargetFound(int index, int centerX, int centerY) {
			output("particle: " + index + "is a Vertical Target centerX: "
					+ centerX + "centerY: " + centerY);
		}
		/** Tell the executor that a horizontal target has been found */
		public void horizontalTargetFound(int index, int centerX, int centerY) {
			output("particle: " + index + "is a Horizontal Target centerX: "
					+ centerX + "centerY: " + centerY);
		}
		/** Outputs a message (currently to {@link java.lang.System#out
		 * System.out}) */
		private void output(String message) {
			System.out.println(message);
		}
	}
}