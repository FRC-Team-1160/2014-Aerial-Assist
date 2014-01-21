package com.team1160.assistant.commands.Shooter;

import com.team1160.assistant.commands.CommandBase;

public class neutral extends CommandBase{
    
    public neutral(){
        requires(shoot);
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        shoot.neutrals();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }

}
