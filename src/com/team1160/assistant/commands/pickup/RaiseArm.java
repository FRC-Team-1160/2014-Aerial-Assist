package com.team1160.assistant.commands.pickup;

import com.team1160.assistant.commands.CommandBase;

public class RaiseArm extends CommandBase{
    
    public RaiseArm(){
        requires(pickup);
    } 
    
    protected void initialize() {
        
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
