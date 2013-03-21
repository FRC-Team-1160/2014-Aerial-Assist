package com.team1160.feathers.commands;

import com.team1160.feathers.SI;

public class Stall extends CommandBase {

	public Stall(){
		requires(middlePulley);
	}
	
	protected void initialize() {
		
	}

	protected void execute() {
		middlePulley.setVelocity(-.1);
	}

	protected boolean isFinished() {
		return SI.middleFinish;
	}

	
	protected void end() {
		middlePulley.setServoVelocity(0);
	}

	protected void interrupted() {
		this.end();
	}
 
}
