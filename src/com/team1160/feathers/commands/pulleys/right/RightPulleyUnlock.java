package com.team1160.feathers.commands.pulleys.right;

import com.team1160.feathers.commands.CommandBase;

public class RightPulleyUnlock extends CommandBase{
    
    public RightPulleyUnlock(){
        requires(rl);
    }
    
    protected void execute(){
        rl.lock(false);
    }
    
    protected boolean isFinished(){
        return false;
    }
    
}
