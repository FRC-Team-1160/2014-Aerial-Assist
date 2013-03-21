package com.team1160.feathers.commands;

import com.team1160.feathers.subsystems.pulleys.Lock;
import com.team1160.feathers.subsystems.pulleys.Pulley;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class UnlockPulley extends CommandGroup{
	
	protected Lock lock;
	protected Pulley pulley;
	
	public UnlockPulley(Lock lock, Pulley pulley){
		this.lock = lock;
		this.pulley = pulley;
		addSequential(new CommandLock(lock, false));
		addSequential(new DeltaPulley(pulley, -.75));
	}
	
	
}
