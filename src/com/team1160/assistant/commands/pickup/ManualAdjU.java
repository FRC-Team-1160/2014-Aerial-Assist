package com.team1160.assistant.commands.pickup;

import com.team1160.assistant.commands.CommandBase;

public class ManualAdjU extends CommandBase{
    
    public ManualAdjU(){
        requires(pickup);
    }
    
    protected void initialize() {
    }

    protected void execute() {
        pickup.manualAdjUP();
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
