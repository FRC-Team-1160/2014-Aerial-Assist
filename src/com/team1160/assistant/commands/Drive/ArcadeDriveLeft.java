package com.team1160.assistant.commands.Drive;

import com.team1160.assistant.commands.CommandBase;

public class ArcadeDriveLeft extends CommandBase {

    public ArcadeDriveLeft() {
        requires(left);
    }

    protected void initialize() {
    }

    protected void execute() {
        left.arcadeLeft();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}