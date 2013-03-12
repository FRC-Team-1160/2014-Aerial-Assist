package com.team1160.feathers.commands.pulleys.middle;

import com.team1160.feathers.commands.CommandBase;

public class MiddleNothing extends CommandBase {
	
	public MiddleNothing(){
		requires(middlePulley);
	}
	
	public void execute(){
		middlePulley.setVelocity(0);
	}
	
	public boolean isFinished(){
		return false;
	}
	
    protected void end() {
		// TODO Auto-generated method stub
		
	}

	
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
    
}
