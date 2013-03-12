package com.team1160.feathers.commands.pulleys.right;

import com.team1160.feathers.commands.CommandBase;


public class RightPulleyExtend extends CommandBase {
    
    
    public RightPulleyExtend(){
        requires(rightPulley);
    }
    
    
    protected void execute(){
        rightPulley.joyVelocity();
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
