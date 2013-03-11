package com.team1160.feathers.commands.pulleys.left;

import com.team1160.feathers.commands.CommandBase;

public class LeftPulleyAngle extends CommandBase {
    
    
    public LeftPulleyAngle(double setTo){
        requires(lp);
    }
    
    protected void execute(){
        lp.joyAngle();
    }
    
    protected boolean isFinished(){
        return false;
    }
    
}
