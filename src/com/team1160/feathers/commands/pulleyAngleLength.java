package com.team1160.feathers.commands;

import com.team1160.feathers.subsystems.pulleys.Pulley;

public class pulleyAngleLength extends CommandBase{

	Pulley pulley;
	double length, angle;
	
	public pulleyAngleLength(Pulley pulley, double dAngle, double length){
		requires(pulley);
		this.pulley = pulley;
		this.length = length;
		this.angle = dAngle;
	}
	
	protected void initialize() {
	
	}

	protected void execute() {
		this.pulley.setRodAngleFree(angle);
		this.pulley.setTapeLength(length, .5);
	}

	protected boolean isFinished() {
		return pulley.isAt(length, .5);
	}

	protected void end() {
		pulley.setVelocity(0);
	}

	protected void interrupted() {
		pulley.setVelocity(0);
	}

}