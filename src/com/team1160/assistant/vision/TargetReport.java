package com.team1160.assistant.vision;

import com.team1160.assistant.RobotMap;

import edu.wpi.first.wpilibj.image.*;

public class TargetReport implements RobotMap {
	protected final int verticalIndex, horizontalIndex;
	protected final double totalScore, leftScore, rightScore, tapeWidthScore,
			verticalScore;
	public TargetReport(Image filteredImage, int verticalIndex,
			int horizontalIndex, ParticleAnalysisReport verticalReport,
			ParticleAnalysisReport horizontalReport)
			throws NIVisionException {
		// Measure equivalent rectangle sides for use
		// in score calculation
		this.horizontalIndex = horizontalIndex;
		this.verticalIndex = verticalIndex;
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
		this.leftScore = Vision
				.ratioToScore(1.2
						* (verticalReport.boundingRectLeft - horizontalReport.center_mass_x)
						/ horizWidth);
		// Determine if the horizontal target is in
		// the expected location to the right of the
		// vertical target
		this.rightScore = Vision
				.ratioToScore(1.2
						* (horizontalReport.center_mass_x
								- verticalReport.boundingRectLeft - verticalReport.boundingRectWidth)
						/ horizWidth);
		// Determine if the width of the tape on the
		// two targets appears to be the same
		this.tapeWidthScore = Vision.ratioToScore(vertWidth / horizHeight);
		// Determine if the vertical location of the
		// horizontal target appears to be correct
		this.verticalScore = Vision
				.ratioToScore(1
						- (verticalReport.boundingRectTop - horizontalReport.center_mass_y)
						/ (4 * horizHeight));
		this.totalScore = Math.max(this.leftScore, this.rightScore)
				+ this.tapeWidthScore + this.verticalScore;
	}
	public TargetReport(int verticalIndex) {
		this.verticalIndex = verticalIndex;
		this.horizontalIndex = 0;
		totalScore = leftScore = rightScore = tapeWidthScore = verticalScore = 0;
	}
	/** Takes in a report on a target and compares the scores to the
	 * defined
	 * score limits to evaluate if the target is a hot target or not.
	 * Returns True if the target is hot. False if it is not. */
	boolean isHot() {
		if (this.tapeWidthScore < TAPE_WIDTH_LIMIT) { return false; }
		if (this.verticalScore < VERTICAL_SCORE_LIMIT) { return false; }
		return (this.leftScore > LR_SCORE_LIMIT)
				|| (this.rightScore > LR_SCORE_LIMIT);
	}
};
