package com.team1160.feathers.commands.pulleys.middle;

import com.team1160.feathers.commands.CommandBase;

public class MiddlePulleyAngle extends CommandBase{
    
    
    public MiddlePulleyAngle(){
        requires(middlePulley);
    }
    
    protected void execute(){
        middlePulley.joyAngle();
    }
    
    protected boolean isFinished(){
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
