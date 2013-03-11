package com.team1160.feathers.commands.pulleys.right;

import com.team1160.feathers.commands.CommandBase;

public class RightPulleyAngle extends CommandBase{
    
    
    public RightPulleyAngle(){
        requires(rp);
    }
    
    protected void execute(){
        rp.joyAngle();
    }
    
    protected boolean isFinished(){
        return false;
    }
    
}
