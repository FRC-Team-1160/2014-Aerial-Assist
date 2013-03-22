package com.team1160.feathers.commands.groups.climbrungs.second;

import com.team1160.feathers.SI;
import com.team1160.feathers.commands.CommandGroupBase;
import com.team1160.feathers.commands.DefensiveClimb;

public class CliimbTheShit extends CommandGroupBase{
	public CliimbTheShit(){
		addParallel(new DefensiveClimb(leftPulley, leftLock, 6.25, false, .75));
		addParallel(new DefensiveClimb(rightPulley, rightLock, 7, false, .9));
		
	}

	public void initialize(){
		SI.nextCommand = false;
	}

}

