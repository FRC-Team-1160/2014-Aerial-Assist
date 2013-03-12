package com.team1160.feathers.commands.pulleys.left;

import com.team1160.feathers.commands.CommandBase;

public class LeftPulleyLock extends CommandBase{
    
	boolean b;
	
    public LeftPulleyLock(boolean b){
        requires(ll);
        this.b = b;
    }
    
    protected void execute(){
        ll.lock(b);
    }
    
    protected boolean isFinished(){
        return false;
    }
    

}
