package com.team1160.feathers.commands.pulleys.middle;

import com.team1160.feathers.commands.CommandBase;

public class MiddlePulleyExtend extends CommandBase{
    
    
    public MiddlePulleyExtend(){
        requires(middlePulley);
    }
    
    protected void execute(){
        middlePulley.joyVelocity();
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
