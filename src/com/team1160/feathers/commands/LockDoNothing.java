package com.team1160.feathers.commands;

import com.team1160.feathers.subsystems.pulleys.Lock;

import edu.wpi.first.wpilibj.command.Command;

public class LockDoNothing extends Command{

	public LockDoNothing(Lock lock){
		requires(lock);
	}
	
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		// TODO Auto-generated method stub
		
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
