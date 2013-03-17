package com.team1160.feathers.commands.pulleys.right;

import com.team1160.feathers.SI;
import com.team1160.feathers.commands.CommandBase;
import edu.wpi.first.wpilibj.Gyro;

public class RightPulleyAngleSetSpecial extends CommandBase{
    
    Gyro gyro;
    SI si;
    
    public RightPulleyAngleSetSpecial(){
        requires(rightPulley);
    }

    protected void initialize() {
        
    }


    protected void execute() {
        rightPulley.setAngle(rightPulley.meth.calcServoFromAngle(true, 45, si.getRightl(), gyro.getAngle()));
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
