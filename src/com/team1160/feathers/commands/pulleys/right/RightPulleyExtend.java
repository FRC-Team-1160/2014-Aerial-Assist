package com.team1160.feathers.commands.pulleys.right;

import com.team1160.feathers.commands.CommandBase;


public class RightPulleyExtend extends CommandBase {
    
    
    public RightPulleyExtend(){
        requires(rp);
    }
    
    
    protected void execute(){
        rp.joyVelocity();
    }
    
    protected boolean isFinished(){
        return false;
    }
    
}
