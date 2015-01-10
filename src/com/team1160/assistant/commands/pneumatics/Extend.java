package com.team1160.assistant.commands.pneumatics;

import com.team1160.assistant.commands.CommandBase;

public class Extend extends CommandBase{

    public Extend(){
        requires(air);
    }
    
    protected void initialize() {
        air.forward();
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }

}
