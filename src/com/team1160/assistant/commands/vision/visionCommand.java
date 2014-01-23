package com.team1160.assistant.commands.vision;

import com.team1160.assistant.commands.CommandBase;

public class visionCommand extends CommandBase{
        
    public visionCommand(){
        requires(vision);
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        vision.vision(true);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
