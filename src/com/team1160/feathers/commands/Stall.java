package com.team1160.feathers.commands;

import com.team1160.feathers.SI;

public class Stall extends CommandBase {

	public Stall(){
		requires(middlePulley);
	}
	
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	protected void execute() {
		middlePulley.setVelocity(-.2);
	}

	protected boolean isFinished() {
		return SI.getInstance().middleFinish;
	}

	
	protected void end() {
		middlePulley.setServoVelocity(0);
	}

	protected void interrupted() {
		this.end();
	}
 
}
