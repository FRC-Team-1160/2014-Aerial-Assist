package com.team1160.feathers.commands;

import com.team1160.feathers.subsystems.pulleys.Lock;
import com.team1160.feathers.subsystems.pulleys.Pulley;

import edu.wpi.first.wpilibj.command.WaitCommand;
/*
 * Originally inteded to take two angles and a length extend
 * to that length at angle one and then drop to angle two
 * ended up being a subroutine for the left and right pulley
 * for climbing the second rung, I do not know what to call
 * it though so it keeps the name RelativeExtendDrop
 */

public class RelativeExtendDrop extends CommandGroupBase {
	public RelativeExtendDrop(Pulley pulley, double length, double firstAngle, double secondAngle, Lock lock){
		addSequential(new UnlockPulley(lock,pulley));
		addSequential(new RelativeGroundAngle(pulley, firstAngle, length));
		addSequential(new RelativeGroundAngle(pulley, secondAngle, 0));
		addSequential(new WaitCommand(2));
	}
}
