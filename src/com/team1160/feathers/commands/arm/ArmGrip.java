package com.team1160.feathers.commands.arm;

import com.team1160.feathers.commands.CommandBase;

public class ArmGrip extends CommandBase{
    
    protected boolean l;
    
    public ArmGrip(boolean lock){
        requires(arm);
        this.l = lock;
        
    }

    protected void initialize() {

    }

    protected void execute() {
        arm.setGrip(l);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {

    }

    protected void interrupted() {

    }

}
