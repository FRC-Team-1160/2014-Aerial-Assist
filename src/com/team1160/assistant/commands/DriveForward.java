package com.team1160.assistant.commands;

import com.team1160.assistant.RobotMap;

public class DriveForward extends CommandBase{
    
    public DriveForward(){
        requires(dt);
    }

    protected void initialize() {
        dt.autoTimeDrive(RobotMap.AUTO_TIME, true);
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
