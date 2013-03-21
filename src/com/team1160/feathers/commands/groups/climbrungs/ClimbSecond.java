package com.team1160.feathers.commands.groups.climbrungs;

import com.team1160.feathers.commands.CommandGroupBase;
import com.team1160.feathers.commands.DefensiveClimb;
import com.team1160.feathers.commands.MiddleFinish;
import com.team1160.feathers.commands.Stall;
import com.team1160.feathers.commands.UnlockExtend;
import com.team1160.feathers.commands.pulleyAngleLength;

import edu.wpi.first.wpilibj.command.WaitForChildren;

public class ClimbSecond extends CommandGroupBase{
	public ClimbSecond(){
		addSequential(new MiddleFinish(false));
		addSequential(new pulleyAngleLength(middlePulley, -45, 47));
		addSequential(new pulleyAngleLength(middlePulley, -60, 47));
		addSequential(new DefensiveClimb(middlePulley, null, 30, false, .5));
		addSequential(new WaitForChildren());
		addParallel(new Stall());
		addParallel(new UnlockExtend(leftPulley, leftLock, 26, 55));
		addParallel(new UnlockExtend(rightPulley, rightLock, 26, 55)); 	
		addSequential(new WaitForChildren());
	}
}
