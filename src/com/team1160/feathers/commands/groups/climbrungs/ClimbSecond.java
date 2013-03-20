package com.team1160.feathers.commands.groups.climbrungs;

import com.team1160.feathers.commands.CommandGroupBase;
import com.team1160.feathers.commands.DefensiveClimb;
import com.team1160.feathers.commands.StallAt30;
import com.team1160.feathers.commands.pulleyAngleLength;

import edu.wpi.first.wpilibj.command.WaitForChildren;

public class ClimbSecond extends CommandGroupBase{
	public ClimbSecond(){
		addSequential(new pulleyAngleLength(middlePulley, -50, 47));
//		addSequential(new DefensiveClimb(middlePulley, null, 30, false, .5));
//		addSequential(new WaitForChildren());
//		addParallel(new StallAt30());
	}
}
