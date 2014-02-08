package com.team1160.feathers.commands.arm;

import com.team1160.feathers.commands.CommandBase;

public class ManualMove extends CommandBase {
    
    public ManualMove(){
        requires(arm);
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        arm.manualArmControl();
    }

    protected boolean isFinished() {
        return false;
        
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
}
