package com.team1160.assistant.commands.pneumatics;

import com.team1160.assistant.commands.CommandBase;

public class Retract extends CommandBase{

    public Retract(){
        requires(air);
    }
    
    protected void initialize() {
        air.back();
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
