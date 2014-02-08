package com.team1160.feathers.commands;

import com.team1160.feathers.subsystems.pulleys.Lock;
import com.team1160.feathers.subsystems.pulleys.Pulley;
import com.team1160.feathers.commands.CommandGroupBase;

public class UnlockExtend extends CommandGroupBase{
	public UnlockExtend(Pulley pulley, Lock lock, double Length, double Angle){
		addSequential(new UnlockPulley(lock, pulley));
		addSequential(new pulleyAngleLength(pulley, Angle, Length, false));
	}
}
