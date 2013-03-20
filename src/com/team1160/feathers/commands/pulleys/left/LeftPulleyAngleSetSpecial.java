package com.team1160.feathers.commands.pulleys.left;

import com.team1160.feathers.SI;
import com.team1160.feathers.commands.CommandBase;

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
        leftPulley.setTapeLength(6, .1);
    }

    protected boolean isFinished() {
    	return leftPulley.isAt(6, .1);
    }

    protected void end() {
    
    }

    protected void interrupted() {
    }
}
