package com.team1160.feathers.commands.arm;

import com.team1160.feathers.commands.CommandBase;

public class ArmMove extends CommandBase{
    
    protected double setTo;
    
    public ArmMove(double set){
        this.setTo = set;
        requires(arm);
    }

    protected void initialize() {
        
    }

    protected void execute() {
        arm.armMove(setTo);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {

    }

    protected void interrupted() {

    }

}
