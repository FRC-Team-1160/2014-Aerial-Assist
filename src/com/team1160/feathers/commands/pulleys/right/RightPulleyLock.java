package com.team1160.feathers.commands.pulleys.right;

import com.team1160.feathers.commands.CommandBase;

public class RightPulleyLock extends CommandBase{
    
    public RightPulleyLock(){
        requires(rl);
    }
    
    protected void execute(){
        rl.lock(true);
    }
    
    protected boolean isFinished(){
        return false;
    }
    
}
