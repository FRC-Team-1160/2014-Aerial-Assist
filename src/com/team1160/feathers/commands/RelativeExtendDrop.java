package com.team1160.feathers.commands;

import com.team1160.feathers.subsystems.pulleys.Pulley;

public class RelativeExtendDrop extends CommandGroupBase {
	public RelativeExtendDrop(Pulley pulley, double length, double firstAngle, double secondAngle){
		addSequential(new RelativeGroundAngle(pulley, firstAngle, length));
		addSequential(new RelativeGroundAngle(pulley, secondAngle, 0));
	}
}
