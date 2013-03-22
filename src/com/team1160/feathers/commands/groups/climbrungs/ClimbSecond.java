package com.team1160.feathers.commands.groups.climbrungs;

import com.team1160.feathers.commands.CommandGroupBase;
import com.team1160.feathers.commands.DefensiveClimb;
import com.team1160.feathers.commands.MiddleFinish;
import com.team1160.feathers.commands.RelativeExtendDrop;
import com.team1160.feathers.commands.RelativeGroundAngle;
import com.team1160.feathers.commands.Stall;
import com.team1160.feathers.commands.UnlockExtend;
import com.team1160.feathers.commands.pulleyAngleLength;
import com.team1160.feathers.commands.waitForNext;
import com.team1160.feathers.commands.groups.climbrungs.second.CliimbTheShit;
import com.team1160.feathers.commands.groups.climbrungs.second.PrepareMiddle;
import com.team1160.feathers.commands.groups.climbrungs.second.PrepareRightLeft;

import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class ClimbSecond extends CommandGroupBase{
	public ClimbSecond(){
		addSequential(new PrepareMiddle());
		addSequential(new waitForNext());
		addSequential(new PrepareRightLeft());
		addSequential(new waitForNext());
		addSequential(new CliimbTheShit());
	}
}
