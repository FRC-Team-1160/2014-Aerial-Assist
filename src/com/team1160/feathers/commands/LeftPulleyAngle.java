package com.team1160.feathers.commands;

public class LeftPulleyAngle extends CommandBase {
    
    private double setTo;
    
    public LeftPulleyAngle(double setTo){
        requires(lp);
        this.setTo = setTo;
    }
    
    protected void execute(){
        lp.setAngle(setTo);
    }
    
    protected boolean isFinished(){
        return false;
    }
    
}
