package com.team1160.feathers.commands.pulleys.right;

import com.team1160.feathers.commands.CommandBase;

public class RightPulleyLock extends CommandBase{
    
	boolean b;
	
    public RightPulleyLock(boolean b){
        requires(rl);
        this.b = b;
	}
    
    protected void execute(){
        rl.lock(b);
    }
    
    protected boolean isFinished(){
        return false;
    }
    
}
