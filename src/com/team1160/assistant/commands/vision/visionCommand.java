package com.team1160.assistant.commands.vision;

import com.team1160.assistant.commands.CommandBase;

public class visionCommand extends CommandBase {

    public visionCommand() {
        requires(vision);
    }

    protected void initialize() {
    }

    protected void execute() {
        vision.autonomous = true;
        vision.vision();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        System.out.println("Vision execution terminated.");
    }

    protected void interrupted() {
        this.end();
    }
}
