package com.team1160.feathers.commands.pulley;

import com.team1160.feathers.commands.CommandBase;
import com.team1160.feathers.subsystems.pulleys.Pulley;

/*
 * This command is another simple command that simply
 * gives the operator direct control over the system.
 */

public class ManualVelocity extends CommandBase {

	private Pulley pulley;

	public ManualVelocity(Pulley pulley){
		this.pulley = pulley;
	}
	
	
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	protected void execute() {
	 this.pulley.joyVelocity();	
	}

	
	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		this.pulley.setVelocity(0); // Stops the pulley from moving
	}

	protected void interrupted() {
		this.end();
	}
	
}
