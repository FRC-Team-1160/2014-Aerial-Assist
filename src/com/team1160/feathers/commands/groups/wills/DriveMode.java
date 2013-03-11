package com.team1160.feathers.commands.groups.wills;

import com.team1160.feathers.commands.drivetrain.ManualDrive;
import com.team1160.feathers.commands.pulleys.middle.MiddleNothing;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveMode extends CommandGroup {
	public DriveMode(){
		addParallel(new ManualDrive());
		addParallel(new MiddleNothing());
	}
}
