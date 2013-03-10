package com.team1160.feathers.commands;

import com.team1160.feathers.subsystems.*;

public class LeftPulleyExtend extends CommandBase{
    
    private double setTo;
    
    
    public LeftPulleyExtend(double setTo){
        requires(lp);
        this.setTo = setTo;
    }
    
    protected void execute(){
        lp.setVelocity(setTo);        
    }
    
    protected boolean isFinished(){
        return false;
    }
    
    
}
