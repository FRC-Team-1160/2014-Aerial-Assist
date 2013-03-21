package com.team1160.feathers.commands;

import com.team1160.feathers.commands.groups.climbrungs.ClimbFirst;
import com.team1160.feathers.commands.groups.climbrungs.ClimbSecond;
import com.team1160.feathers.commands.groups.prepare.PrepareClimb;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Climb extends CommandGroup{
	public Climb(){
		addSequential(new PrepareClimb());
		addSequential(new waitForNext());
		addSequential(new ClimbFirst());
		addSequential(new waitForNext());
		addSequential(new ClimbSecond());
		addSequential(new waitForNext());
		addSequential(new ClimbSecond());
	}
}
