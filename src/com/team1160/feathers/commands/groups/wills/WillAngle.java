package com.team1160.feathers.commands.groups.wills;

import com.team1160.feathers.commands.drivetrain.Halt;
import com.team1160.feathers.commands.pulleys.middle.MiddlePulleyAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class WillAngle extends CommandGroup {
	public WillAngle(){
		addParallel(new Halt());
		addParallel(new MiddlePulleyAngle());
	}
}
