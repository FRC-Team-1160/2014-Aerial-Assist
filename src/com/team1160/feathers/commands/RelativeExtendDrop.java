package com.team1160.feathers.commands;

import com.team1160.feathers.subsystems.pulleys.Lock;
import com.team1160.feathers.subsystems.pulleys.Pulley;

public class RelativeExtendDrop extends CommandGroupBase {
	public RelativeExtendDrop(Pulley pulley, double length, double firstAngle, double secondAngle, Lock lock){
		addSequential(new UnlockPulley(lock,pulley));
		addSequential(new RelativeGroundAngle(pulley, firstAngle, length));
		addSequential(new RelativeGroundAngle(pulley, secondAngle, 0));
		addSequential(new DefensiveClimb(pulley, lock, length - 2, false, .5));
	}
}
