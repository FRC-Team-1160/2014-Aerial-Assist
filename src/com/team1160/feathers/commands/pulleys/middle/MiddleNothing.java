package com.team1160.feathers.commands.pulleys.middle;

import com.team1160.feathers.commands.CommandBase;

public class MiddleNothing extends CommandBase {
	
	public MiddleNothing(){
		requires(mp);
	}
	
	public void execute(){
		mp.setVelocity(0);
	}
	
	public boolean isFinished(){
		return false;
	}
}
