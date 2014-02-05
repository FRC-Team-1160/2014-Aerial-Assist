package com.team1160.assistant.commands.pickup;

import com.team1160.assistant.commands.CommandBase;

public class Stall extends CommandBase{

    public Stall(){
        requires(pickup);
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        pickup.stall();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        System.out.println("Stall released.");
    }

    protected void interrupted() {
        this.end();
    }
    
    

}
