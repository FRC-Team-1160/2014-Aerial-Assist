package com.team1160.feathers.commands;


import com.team1160.feathers.subsystems.pulleys.Lock;
import com.team1160.feathers.subsystems.pulleys.Pulley;

public class DefensiveClimb extends CommandBase {
	
	Lock lock;
	Pulley pulley;
	double length;
	boolean flr;
	
	public DefensiveClimb(Pulley pulley, Lock lock, double length, boolean flr){
		this.pulley = pulley;
		this.lock = lock;
		requires(pulley);
		requires(lock);
		this.length = length;		
		this.flr = flr;
	}

	
	protected void initialize() {
		lock.lock(true);
	}

	protected void execute() {
		pulley.setTapeLength(length, .2);
		pulley.adjustAngleClimbing(flr);
	}


	protected boolean isFinished() {
		return this.pulley.isAt(this.length, .2);
	}

	protected void end() {
		pulley.adjustAngleClimbing(flr);
		pulley.setVelocity(0);
	}

	protected void interrupted() {
		this.end();
	}
	
}
