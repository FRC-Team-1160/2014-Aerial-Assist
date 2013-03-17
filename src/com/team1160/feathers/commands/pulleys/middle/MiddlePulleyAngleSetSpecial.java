package com.team1160.feathers.commands.pulleys.middle;

import com.team1160.feathers.SI;
import com.team1160.feathers.commands.CommandBase;
import edu.wpi.first.wpilibj.Gyro;

public class MiddlePulleyAngleSetSpecial extends CommandBase {

    protected boolean b;
    SI si;

    public MiddlePulleyAngleSetSpecial(boolean b) {
        if (si == null) {
            si = SI.getInstance();
        }
        requires(middlePulley);
        this.b = b;
    }

    protected void initialize() {
    }

    protected void execute() {
        middlePulley.adjustAngleClimbing(b);
        middlePulley.joyVelocity();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
