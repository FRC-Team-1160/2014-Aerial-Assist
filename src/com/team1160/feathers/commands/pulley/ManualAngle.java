package com.team1160.feathers.commands.pulley;

import com.team1160.feathers.commands.CommandBase;
import com.team1160.feathers.subsystems.pulleys.Pulley;

/*
 * Gives the operator manual control over a pulleys
 * angle. Should make sense.
 */

public class ManualAngle extends CommandBase{

	private Pulley pulley;

	public ManualAngle(Pulley pulley){
		this.pulley = pulley;
	}
	
	
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	protected void execute() {
		this.pulley.joyAngle();
	}

	
	protected boolean isFinished() {
		return false;   //Never ends, until a new command is sent
	}

	
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	protected void interrupted() {
		// TODO Auto-generated method stub	
	}

}
