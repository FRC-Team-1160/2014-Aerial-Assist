package com.team1160.assistant.commands.pickup;

import com.team1160.assistant.commands.CommandBase;

public class ManualAdjD extends CommandBase{
    
    public ManualAdjD(){
        requires(pickup);
    }

    protected void initialize() {
    }

    protected void execute() {
        pickup.manualAdjDOWN();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        pickup.stall();
    }

    protected void interrupted() {
    }

}
