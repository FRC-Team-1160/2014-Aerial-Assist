package com.team1160.feathers.commands.pulleys.right; 

import com.team1160.feathers.commands.CommandBase;

public class RightDoNothing extends CommandBase {

	public RightDoNothing(){
		requires(rightPulley);
	}
	
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	
	protected void execute() {
		rightPulley.setVelocity(0);	
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		// TODO Auto-generated method stub	
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
	}
	
}
