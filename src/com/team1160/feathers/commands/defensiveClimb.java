package com.team1160.feathers.commands;


import com.team1160.feathers.subsystems.pulleys.Lock;
import com.team1160.feathers.subsystems.pulleys.Pulley;

public class defensiveClimb extends CommandBase {
	
	Lock lock;
	Pulley pulley;
	double length;
	
	public defensiveClimb(Pulley pulley, Lock lock, double length){
		this.pulley = pulley;
		this.lock = lock;
		requires(pulley);
		requires(lock);
		this.length = length;		
		
	}

	
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	protected void execute() {
		// TODO Auto-generated method stub		
	}


	protected boolean isFinished() {
		return this.pulley.isAt(this.length, .5);
	}

	protected void end() {
		// TODO Auto-generated method stub		
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
}
