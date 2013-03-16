package com.team1160.feathers.commands.pulleys.left;

import com.team1160.feathers.commands.CommandBase;

public class LeftPulleyLength extends CommandBase {
    
    protected double goal;
    protected double error;
    
    public LeftPulleyLength(double g, double e) {
        this.goal = g;
        this.error = e;
        requires(leftPulley);
    }

    protected void initialize() {
        leftPulley.setTapeLength(goal, error);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        // TODO Auto-generated method stub
    }

    protected void interrupted() {
        // TODO Auto-generated method stub
    }
}
