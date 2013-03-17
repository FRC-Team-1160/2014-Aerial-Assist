package com.team1160.feathers.commands.pulleys.left;

import com.team1160.feathers.SI;
import com.team1160.feathers.commands.CommandBase;
import edu.wpi.first.wpilibj.Gyro;

public class LeftPulleyAngleSetSpecial extends CommandBase {

    Gyro gyro;
    SI si;
    protected boolean b;

    public LeftPulleyAngleSetSpecial(boolean b) {
        if (si == null) {
            si = SI.getInstance();
        }
        requires(leftPulley);
        this.b = b;
    }

    protected void initialize() {
    }

    protected void execute() {
        leftPulley.adjustAngleClimbing(b);
        leftPulley.joyVelocity();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
