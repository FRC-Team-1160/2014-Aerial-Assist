package com.team1160.feathers.commands;

import com.team1160.feathers.SI;

public class StallAt30 extends CommandBase {

	public StallAt30(){
		requires(middlePulley);
	}
	
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	protected void execute() {
		middlePulley.setTapeLength(30, .1, .7);
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
