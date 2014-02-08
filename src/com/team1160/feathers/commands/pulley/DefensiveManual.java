package com.team1160.feathers.commands.pulley;

import com.team1160.feathers.commands.CommandBase;
import com.team1160.feathers.subsystems.pulleys.Pulley;

import edu.wpi.first.wpilibj.Joystick;

/*
 * This command makes it so we can control the length
 * of our tape while having the servos adjust, this
 * allows manual take over with less of a risk.
 */

public class DefensiveManual extends CommandBase {

	private Pulley pulley;
	private Boolean floor;

	public DefensiveManual(Pulley pulley, Joystick joystick, int button){
		this.pulley = pulley;
		floor = joystick.getRawButton(button); //Gives the operator a choice at run with one button... maybe not
	}
	
	public DefensiveManual(Pulley pulley, boolean floor){
		this.pulley = pulley;
		this.floor = floor;
	}
	
	
	protected void initialize() {
		this.pulley.adjustAngleClimbing(floor); 
	}

	protected void execute() {
		this.pulley.adjustAngleClimbing(floor); 
		this.pulley.joyVelocity();
	}
	
	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		this.pulley.setVelocity(0);
	}

	protected void interrupted() {
		this.end();
	}

}
