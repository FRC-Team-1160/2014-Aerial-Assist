package com.team1160.feathers.commands.pulleys.middle;

import com.team1160.feathers.commands.CommandBase;

public class MiddlePulleyExtend extends CommandBase{
    
    
    public MiddlePulleyExtend(){
        requires(mp);
    }
    
    protected void execute(){
        mp.joyVelocity();
    }
    
    protected boolean isFinished(){
        return false;
    }
    
}
