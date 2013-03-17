package com.team1160.feathers.commands.pulleys.left;

import com.team1160.feathers.SI;
import com.team1160.feathers.commands.CommandBase;
import edu.wpi.first.wpilibj.Gyro;

public class LeftPulleyAngleSetSpecial extends CommandBase{
    
	Gyro gyro;
    SI si;
    
    public LeftPulleyAngleSetSpecial(){
    	if(si == null){
    		si = SI.getInstance();
    	}
        requires(rightPulley);
    }

    protected void initialize() {
        
    }


    protected void execute() {
        leftPulley.setAngle(leftPulley.meth.calcServoFromAngle(true, Math.toRadians(45), si.getLeftl(), si.getAngleDegrees()));
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
