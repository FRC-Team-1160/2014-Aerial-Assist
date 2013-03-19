package com.team1160.feathers.commands.pulleys.left;

import com.team1160.feathers.commands.CommandBase;

public class LeftDoNothing extends CommandBase {


	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	public LeftDoNothing(){
		requires(leftPulley);
	}
	
	protected void execute() {
		leftPulley.setVelocity(0);
	}

	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void end() {
		// TODO Auto-generated method stub
		
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
