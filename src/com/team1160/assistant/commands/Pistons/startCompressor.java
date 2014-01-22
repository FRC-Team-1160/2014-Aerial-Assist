package com.team1160.assistant.commands.Pistons;

import com.team1160.assistant.commands.CommandBase;

public class startCompressor extends CommandBase{
    
    public startCompressor(){
        requires(airsystem);
    }
    
    protected void initialize() {
        airsystem.start();
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
