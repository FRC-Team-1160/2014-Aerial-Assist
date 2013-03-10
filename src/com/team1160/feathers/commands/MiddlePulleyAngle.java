package com.team1160.feathers.commands;

public class MiddlePulleyAngle extends CommandBase{
    
    private double setTo;
    
    public MiddlePulleyAngle(double setTo){
        requires(mp);
        this.setTo = setTo;
    }
    
    protected void execute(){
        mp.setAngle(setTo);
    }
    
    protected boolean isFinished(){
        return false;
    }
    
}
