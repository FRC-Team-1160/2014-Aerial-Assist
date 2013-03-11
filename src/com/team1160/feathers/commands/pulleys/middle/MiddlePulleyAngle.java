package com.team1160.feathers.commands.pulleys.middle;

import com.team1160.feathers.commands.CommandBase;

public class MiddlePulleyAngle extends CommandBase{
    
    
    public MiddlePulleyAngle(){
        requires(mp);
    }
    
    protected void execute(){
        mp.joyAngle();
    }
    
    protected boolean isFinished(){
        return false;
    }
    
}
