package com.team1160.feathers.commands.pulleys.left;

import com.team1160.feathers.commands.CommandBase;

public class LeftPulleyExtend extends CommandBase{
    
    
    public LeftPulleyExtend(){
        requires(lp);
    }
    
    protected void execute(){
        lp.joyVelocity();        
    }
    
    protected boolean isFinished(){
        return false;
    }
    
    
}
