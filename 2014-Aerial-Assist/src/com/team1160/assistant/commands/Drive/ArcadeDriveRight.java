package com.team1160.assistant.commands.Drive;

import com.team1160.assistant.commands.CommandBase;

public class ArcadeDriveRight extends CommandBase{
    
    public ArcadeDriveRight(){
        requires(right);
    }
    
    protected void initialize() {
    }

    protected void execute() {
        right.arcadeRight();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
    
    
}
