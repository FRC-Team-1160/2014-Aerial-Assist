package com.team1160.feathers.commands.pulleys.right;

import com.team1160.feathers.SI;
import com.team1160.feathers.commands.CommandBase;

public class RightPulleyAngleSetSpecial extends CommandBase{
    
    SI si;
    
    public RightPulleyAngleSetSpecial(){
    	if(si == null){
    		si = SI.getInstance();
    	}
        requires(rightPulley);
    }

    protected void initialize() {
        
    }


    protected void execute() {
        rightPulley.setAngle(rightPulley.meth.calcServoFromAngle(true, Math.toRadians(45), si.getRightl(), si.getAngleDegrees()));
        System.out.println("degrees: " + si.getAngleDegrees());
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
