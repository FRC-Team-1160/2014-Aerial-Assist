package com.team1160.feathers.commands.groups.climbrungs.second;

import com.team1160.feathers.SI;
import com.team1160.feathers.commands.CommandGroupBase;
import com.team1160.feathers.commands.DefensiveClimb;
import com.team1160.feathers.commands.MiddleFinish;
import com.team1160.feathers.commands.Stall;
import com.team1160.feathers.commands.pulleyAngleLength;

import edu.wpi.first.wpilibj.command.WaitCommand;

public class PrepareMiddle extends CommandGroupBase {
	public PrepareMiddle(){
		addSequential(new MiddleFinish(false));
		addSequential(new pulleyAngleLength(middlePulley, .7, 44.5, true));
		addSequential(new pulleyAngleLength(middlePulley, .95, 44.5, true));
		addSequential(new WaitCommand(3));
		addSequential(new pulleyAngleLength(middlePulley, .75, 43, true));
		addSequential(new DefensiveClimb(middlePulley, null, 26, false, .5));
		addSequential(new Stall());
	}
	
	public void initialize(){
		SI.nextCommand = false;
	}
	
}
