package com.team1160.feathers.commands.pulleys.middle;

import com.team1160.feathers.commands.CommandBase;

public class MiddlePulleyAdjust extends CommandBase {

    protected void initialize() {
        requires(middlePulley);
    }

    protected void execute() {
        middlePulley.joyAdjust();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
