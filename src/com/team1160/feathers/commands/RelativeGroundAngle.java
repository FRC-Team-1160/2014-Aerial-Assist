package com.team1160.feathers.commands;

import com.team1160.feathers.subsystems.pulleys.Pulley;

public class RelativeGroundAngle extends CommandBase {

    protected Pulley pulley;
    protected double dAngle, length;

    public RelativeGroundAngle(Pulley pulley, double dAngle, double length) {
        this.pulley = pulley;
        this.dAngle = dAngle;
        this.length = length;
        requires(pulley);
    }

    protected void initialize() {
    }

    protected void execute() {
    	pulley.setRelativeGround(dAngle);
    	if(length != 0){
    		pulley.setTapeLength(length, .1, .5);
    	}
    }

    protected boolean isFinished() {
        if(this.length == 0){
        	return true;
        }else{
        	return pulley.isAt(length, .1);
        }
    }

    protected void end() {
    	pulley.setRelativeGround(dAngle);
    }

    protected void interrupted() {
    }
}
