package com.team1160.feathers.commands.pulleys.left;

import com.team1160.feathers.commands.CommandBase;



public class LeftPulleyUnlock extends CommandBase{
    
    public LeftPulleyUnlock(){
        requires(ll);
    }
    protected void execute(){
        ll.lock(false);
    }
    
    protected boolean isFinished(){
        return false;
    }
    
}
