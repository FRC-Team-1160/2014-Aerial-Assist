package com.team1160.feathers.commands.pulleys.left;

import com.team1160.feathers.commands.CommandBase;

public class LeftPulleyAdjust extends CommandBase {


	public LeftPulleyAdjust(){
		requires(leftPulley);
	}
	
	protected void initialize() {
		// TODO Auto-generated method stub
		
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
