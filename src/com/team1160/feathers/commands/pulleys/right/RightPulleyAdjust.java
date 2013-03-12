package com.team1160.feathers.commands.pulleys.right;

import com.team1160.feathers.commands.CommandBase;

public class RightPulleyAdjust extends CommandBase {

	protected void initialize() {
		requires(leftPulley);
	}

	protected void execute() {
		leftPulley.joyAdjust();
	}

	protected void interrupted() {
		// TODO Auto-generated method stub

	}

	protected void end() {
		// TODO Auto-generated method stub

	}

	protected boolean isFinished() {
		return false;
	}

}
