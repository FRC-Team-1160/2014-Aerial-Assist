package com.team1160.feathers.commands.pulleys.right;

import com.team1160.feathers.SI;
import com.team1160.feathers.commands.CommandBase;

public class RightPulleyAngleSetSpecial extends CommandBase {

    SI si;
    protected boolean b;

    public RightPulleyAngleSetSpecial(boolean b) {
        if (si == null) {
            si = SI.getInstance();
        }
        requires(rightPulley);
        this.b = b;
    }

    protected void initialize() {
    }

    protected void execute() {
        rightPulley.adjustAngleClimbing(b);
        rightPulley.joyVelocity();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
