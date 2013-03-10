package com.team1160.feathers.commands;

public class MiddlePulleyExtend extends CommandBase{
    
    private double setTo;
    
    public MiddlePulleyExtend(double setTo){
        requires(mp);
        this.setTo = setTo;
    }
    
    protected void execute(){
        mp.setVelocity(setTo);
    }
    
    protected boolean isFinished(){
        return false;
    }
    
}
