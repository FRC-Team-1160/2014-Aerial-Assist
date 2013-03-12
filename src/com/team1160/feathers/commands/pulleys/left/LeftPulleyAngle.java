package com.team1160.feathers.commands.pulleys.left;

import com.team1160.feathers.commands.CommandBase;

public class LeftPulleyAngle extends CommandBase {
    
    
    public LeftPulleyAngle(){
        requires(leftPulley);
    }
    
    protected void execute(){
        leftPulley.joyAngle();
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
