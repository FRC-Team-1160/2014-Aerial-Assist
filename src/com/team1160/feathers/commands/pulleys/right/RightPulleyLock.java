package com.team1160.feathers.commands.pulleys.right;

import com.team1160.feathers.commands.CommandBase;

public class RightPulleyLock extends CommandBase{
    
	boolean b;
	
    public RightPulleyLock(boolean b){
        requires(rightLock);
        this.b = b;
	}
    
    protected void execute(){
        rightLock.lock(b);
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
