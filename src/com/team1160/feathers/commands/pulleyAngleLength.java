package com.team1160.feathers.commands;

import com.team1160.feathers.subsystems.pulleys.Pulley;

public class pulleyAngleLength extends CommandBase{

	Pulley pulley;
	double length, angle;
	boolean raw;
	
	public pulleyAngleLength(Pulley pulley, double dAngle, double length, boolean raw){
		requires(pulley);
		this.pulley = pulley;
		this.length = length;
		this.angle = dAngle;
		this.raw = raw;
	}
	
	protected void initialize() {
	
	}

	protected void execute() {
		if(!raw){
			this.pulley.setRodAngleFree(angle);
		}else{
			this.pulley.setAngle(this.angle);
		}
		this.pulley.setTapeLength(length, .1, .5);
	}

	protected boolean isFinished() {
		return pulley.isAt(length, .1);
	}

	protected void end() {
		pulley.setVelocity(0);
		if(!raw){
			this.pulley.setRodAngleFree(angle);
		}else{
			this.pulley.setAngle(angle);
		}
	}

	protected void interrupted() {
		this.end();
	}

}