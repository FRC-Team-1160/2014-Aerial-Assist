package com.team1160.feathers.commands.groups.climbrungs;

import com.team1160.feathers.commands.CommandGroupBase;
import com.team1160.feathers.commands.DefensiveClimb;
import com.team1160.feathers.commands.MiddleFinish;
import com.team1160.feathers.commands.RelativeExtendDrop;
import com.team1160.feathers.commands.RelativeGroundAngle;
import com.team1160.feathers.commands.Stall;
import com.team1160.feathers.commands.UnlockExtend;
import com.team1160.feathers.commands.pulleyAngleLength;

import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class ClimbSecond extends CommandGroupBase{
	public ClimbSecond(){
		addSequential(new MiddleFinish(false));
		addSequential(new pulleyAngleLength(middlePulley, .7, 46, true));
		addSequential(new pulleyAngleLength(middlePulley, .88, 46, true));
		addSequential(new WaitCommand(3));
		addSequential(new pulleyAngleLength(middlePulley, .88, 43, true));
		addSequential(new DefensiveClimb(middlePulley, null, 26, false, .5));
		addSequential(new WaitForChildren());
		addParallel(new Stall());
//		addParallel(new RelativeExtendDrop(leftPulley,31, 80, 65, leftLock));
//		addParallel(new RelativeExtendDrop(rightPulley,31, 80, 65, rightLock)); 	
//		addSequential(new WaitForChildren());
//		addParallel(new DefensiveClimb(leftPulley, leftLock, 7, false, .5));
//		addParallel(new DefensiveClimb(rightPulley, rightLock, 7, false, .6));
//		
	}
}
