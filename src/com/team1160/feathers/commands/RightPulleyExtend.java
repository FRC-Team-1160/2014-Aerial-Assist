package com.team1160.feathers.commands;


public class RightPulleyExtend extends CommandBase {
    
    private double setTo;
    
    public RightPulleyExtend(double setTo){
        requires(rp);
        this.setTo = setTo;
    }
    
    
    protected void execute(){
        rp.setVelocity(setTo);
    }
    
    protected boolean isFinished(){
        return false;
    }
    
}
