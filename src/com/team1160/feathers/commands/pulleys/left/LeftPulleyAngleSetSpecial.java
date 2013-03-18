package com.team1160.feathers.commands.pulleys.left;

import com.team1160.feathers.SI;
import com.team1160.feathers.commands.CommandBase;
import edu.wpi.first.wpilibj.Gyro;

public class LeftPulleyAngleSetSpecial extends CommandBase {

    SI si;
    protected boolean b;
    protected double goal;
    

    public LeftPulleyAngleSetSpecial(boolean b, double tapeGoal) {
        if (si == null) {
            si = SI.getInstance();
        }
        requires(leftPulley);
        this.b = b;
        this.goal = tapeGoal;
    }

    protected void initialize() {
    }

    protected void execute() {
        leftPulley.adjustAngleClimbing(b);
    }

    protected boolean isFinished() {
        double t1 = si.getLeftl();
        return Math.abs(t1 - goal) < 0.5;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
