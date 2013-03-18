package com.team1160.feathers.commands.pulleys.right;

import com.team1160.feathers.SI;
import com.team1160.feathers.commands.CommandBase;

public class RightPulleyAngleSetSpecial extends CommandBase {

    SI si;
    protected boolean b;
    protected double tapeGoal;

    public RightPulleyAngleSetSpecial(boolean b, double tapeGoal) {
        if (si == null) {
            si = SI.getInstance();
        }
        requires(rightPulley);
        this.b = b;
        this.tapeGoal = tapeGoal;
    }

    protected void initialize() {
    }

    protected void execute() {
        rightPulley.adjustAngleClimbing(b);
    }

    protected boolean isFinished() {
        double t1 = si.getRightl();
        return Math.abs(t1 - tapeGoal) < 0.5;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
