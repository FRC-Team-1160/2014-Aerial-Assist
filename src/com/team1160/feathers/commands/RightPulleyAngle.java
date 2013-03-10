package com.team1160.feathers.commands;

public class RightPulleyAngle extends CommandBase{
    
    private double setTo;
    
    public RightPulleyAngle(double setTo){
        requires(rp);
        this.setTo = setTo;
    }
    
    protected void execute(){
        rp.setAngle(setTo);
    }
    
    protected boolean isFinished(){
        return false;
    }
    
}
