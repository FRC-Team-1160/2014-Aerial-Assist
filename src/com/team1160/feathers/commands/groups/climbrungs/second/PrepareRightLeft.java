package com.team1160.feathers.commands.groups.climbrungs.second;

import com.team1160.feathers.SI;
import com.team1160.feathers.commands.CommandGroupBase;
import com.team1160.feathers.commands.RelativeExtendDrop;
import com.team1160.feathers.commands.Stall;

public class PrepareRightLeft extends CommandGroupBase {
	public PrepareRightLeft(){
		addParallel(new Stall());
		addParallel(new RelativeExtendDrop(leftPulley,34, 90, 63, leftLock));
		addParallel(new RelativeExtendDrop(rightPulley,34, 90, 63, rightLock)); 	
		
	}
	
	public void initialize(){
		SI.nextCommand = false;
	}

}
