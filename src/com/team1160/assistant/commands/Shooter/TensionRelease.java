package com.team1160.assistant.commands.Shooter;

import com.team1160.assistant.commands.CommandBase;

public class TensionRelease extends CommandBase {

    public TensionRelease() {
        requires(shoot);
    }

    protected void initialize() {
        
    }

    protected void execute() {
        shoot.releaseTension();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
}
