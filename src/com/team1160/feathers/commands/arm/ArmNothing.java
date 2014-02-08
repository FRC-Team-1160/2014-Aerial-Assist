package com.team1160.feathers.commands.arm;

import com.team1160.feathers.commands.CommandBase;

public class ArmNothing extends CommandBase{
    
    public ArmNothing(){
        requires(arm);
    }

    protected void initialize() {
        arm.armMove(0);
    }
    

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {

    }

    protected void interrupted() {

    }

}
