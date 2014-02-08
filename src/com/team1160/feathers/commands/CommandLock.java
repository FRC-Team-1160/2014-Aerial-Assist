package com.team1160.feathers.commands;

import com.team1160.feathers.subsystems.pulleys.Lock;

import edu.wpi.first.wpilibj.command.Command;

public class CommandLock extends Command {

	protected Lock lock;
	protected boolean locked;
	
	public CommandLock(Lock lock, boolean isLocked){
		this.lock = lock;
		this.locked = isLocked;
		requires(lock);
	}
	
	protected void initialize() {
		// TODO Auto-generated method stub	
	}

	protected void execute() {
		// TODO Auto-generated method stub		
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
		lock.lock(locked);
	}

	protected void interrupted() {
		// TODO Auto-generated method stub		
	}

}
