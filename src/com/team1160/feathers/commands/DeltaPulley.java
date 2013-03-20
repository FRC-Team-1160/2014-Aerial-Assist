package com.team1160.feathers.commands;

import com.team1160.feathers.subsystems.pulleys.Pulley;

import edu.wpi.first.wpilibj.command.Command;

public class DeltaPulley extends Command {

	protected Pulley pulley;
	protected double set, delta;
	
	public DeltaPulley(Pulley pulley, double delta){
		this.pulley = pulley;
		this.delta = delta;
		requires(pulley);
	}
	
	protected void initialize() {
		this.set = pulley.getLength() + delta;
	}

	protected void execute() {
		pulley.setTapeLength(set, .2);
	}

	protected boolean isFinished() {
		return pulley.isAt(set, .2);
	}

	protected void end() {
		pulley.setVelocity(0);
	}

	protected void interrupted() {
		pulley.setVelocity(0);
	}

}
