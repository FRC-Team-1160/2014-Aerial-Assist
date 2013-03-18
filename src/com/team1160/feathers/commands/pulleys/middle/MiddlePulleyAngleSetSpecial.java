package com.team1160.feathers.commands.pulleys.middle;

import com.team1160.feathers.SI;
import com.team1160.feathers.commands.CommandBase;

public class MiddlePulleyAngleSetSpecial extends CommandBase {

    protected boolean b;
    SI si;
    protected double length;

    public MiddlePulleyAngleSetSpecial(double length) {
        if (si == null) {
            si = SI.getInstance();
        }
        requires(middlePulley);
        this.length = length;
    }

    protected void initialize() {
    }

    protected void execute() {
        middlePulley.adjustAngleClimbing(false);
    }

    protected boolean isFinished() {
        double t1 = si.getMidl();
        return Math.abs(t1 - length) < 0.5;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
