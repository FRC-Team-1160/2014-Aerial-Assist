package com.team1160.assistant.commands.vision;

import com.team1160.assistant.commands.CommandBase;

public class VisionDoNothing extends CommandBase {
    
    
    
    public VisionDoNothing() {
        requires(vision);
    }

    protected void initialize() {
        vision.stahp();
        VisionCommand.done = true;
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        this.end();
    }
}
