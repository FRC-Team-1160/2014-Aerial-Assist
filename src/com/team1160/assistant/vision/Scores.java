package com.team1160.assistant.vision;

import com.team1160.assistant.RobotMap;

import edu.wpi.first.wpilibj.image.*;

public class Scores implements RobotMap {
	final double rectangularity, aspectRatioVertical, aspectRatioHorizontal;
	public Scores(double rectangularity, double aspectRatioVertical,
			double aspectRatioHorizontal) {
		this.rectangularity = rectangularity;
		this.aspectRatioVertical = aspectRatioVertical;
		this.aspectRatioHorizontal = aspectRatioHorizontal;
	}
	public Scores(BinaryImage filteredImage, ParticleAnalysisReport report,
			int index) throws NIVisionException {
		this(scoreRectangularity(report), scoreAspectRatio(filteredImage,
				report, index, true), scoreAspectRatio(filteredImage,
				report, index, false));
	}
	/** Compares these scores to defined limits and returns true if the
	 * particle appears to be a target
	 * @param scores The structure containing the scores to compare
	 * @param outer True if the particle should be treated as an outer
	 *        target, false to treat it as a center target
	 * @return True if the particle meets all limits, false otherwise */
	public boolean isTarget(boolean vertical) {
		if (rectangularity <= RECTANGULARITY_LIMIT) { return false; }
		return (vertical ? aspectRatioVertical : aspectRatioHorizontal) > ASPECT_RATIO_LIMIT;
	}
	/** Computes a score (0-100) comparing the aspect ratio to the ideal
	 * aspect ratio for the target. This method uses the equivalent
	 * rectangle sides to determine aspect ratio as it performs better as
	 * the target gets skewed by moving to the left or right. The
	 * equivalent
	 * rectangle is the rectangle with sides x and y where particle area=
	 * x*y and particle perimeter = 2x+2y
	 * @param image The image containing the particle to score, needed to
	 *        perform additional measurements
	 * @param report The Particle Analysis Report for the particle, used
	 *        for
	 *        the width, height, and particle number
	 * @param outer Indicates whether the particle aspect ratio should be
	 *        compared to the ratio for the inner target or the outer
	 * @return The aspect ratio score (0-100) */
	public static double scoreAspectRatio(BinaryImage image,
			ParticleAnalysisReport report, int particleNumber,
			boolean vertical) throws NIVisionException {
		double rectLong, rectShort, aspectRatio, idealAspectRatio;
		rectLong = NIVision.MeasureParticle(image.image, particleNumber,
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
			aspectRatio = Vision.ratioToScore((rectLong / rectShort)
					/ idealAspectRatio);
		} else {
			// particle is taller than it is wide, divide short by long
			aspectRatio = Vision.ratioToScore((rectShort / rectLong)
					/ idealAspectRatio);
		}
		return aspectRatio;
	}
	public String toString() {
		return "rect: " + rectangularity + ", ARHoriz: "
				+ aspectRatioHorizontal + ", ARVert: "
				+ aspectRatioVertical;
	}
	/** Computes a score (0-100) estimating how rectangular the particle is by
	 * comparing the area of the particle to the area of the bounding box
	 * surrounding it. A perfect rectangle would cover the entire bounding box.
	 * @param report The Particle Analysis Report for the particle to score
	 * @return The rectangularity score (0-100) */
	private static double scoreRectangularity(ParticleAnalysisReport report) {
		if (report.boundingRectWidth * report.boundingRectHeight != 0) {
			return 100
					* report.particleArea
					/ (report.boundingRectWidth * report.boundingRectHeight);
		} else {
			return 0;
		}
	}
}
