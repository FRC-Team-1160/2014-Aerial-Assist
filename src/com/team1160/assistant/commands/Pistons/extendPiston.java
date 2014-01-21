package com.team1160.assistant.commands.Pistons;

import com.team1160.assistant.commands.CommandBase;

public class extendPiston extends CommandBase{
    
    public extendPiston(){
        requires(airsystem);
    }
    
    protected void initialize() {
        airsystem.extendPiston();
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
