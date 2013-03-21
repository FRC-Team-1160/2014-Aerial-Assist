package com.team1160.feathers.commands;

import com.team1160.feathers.subsystems.pulleys.Pulley;

public class RelativeGroundAngle extends CommandBase {

    protected Pulley pulley;
    protected double dAngle;

    public RelativeGroundAngle(Pulley pulley, double dAngle) {
        this.pulley = pulley;
        this.dAngle = dAngle;
        requires(pulley);

    }

    protected void initialize() {
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
        pulley.setRelativeGround(dAngle);
    }

    protected void interrupted() {
    }
}
