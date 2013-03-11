package com.team1160.feathers.commands.pulleys.left;

import com.team1160.feathers.commands.CommandBase;

public class LeftPulleyLock extends CommandBase{
    
    public LeftPulleyLock(){
        requires(ll);
    }
    
    protected void execute(){
        ll.lock(true);
    }
    
    protected boolean isFinished(){
        return false;
    }
    

}
