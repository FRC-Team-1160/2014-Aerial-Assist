package com.team1160.feathers.commands.pulleys.right;

import com.team1160.feathers.SI;
import com.team1160.feathers.commands.CommandBase;

public class RightPulleyLength extends CommandBase {

    protected double goal;
    protected double error;
    protected SI si;

    public RightPulleyLength(double g, double e) {
        this.error = e;
        this.goal = g;
        requires(middlePulley);
        if(si == null){
            si = SI.getInstance();
        }
    }

    protected void initialize() {
        middlePulley.setTapeLength(goal, error);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return Math.abs(si.getLeftl() - goal) <= error;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
