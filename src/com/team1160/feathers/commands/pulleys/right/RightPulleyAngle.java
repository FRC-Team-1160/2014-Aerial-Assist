package com.team1160.feathers.commands.pulleys.right;

import com.team1160.feathers.commands.CommandBase;

public class RightPulleyAngle extends CommandBase{
    
    
    public RightPulleyAngle(){
        requires(rightPulley);
    }
    
    protected void execute(){
        rightPulley.joyAngle();
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
