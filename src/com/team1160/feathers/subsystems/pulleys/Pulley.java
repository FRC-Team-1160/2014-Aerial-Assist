package com.team1160.feathers.subsystems.pulleys;

import com.team1160.feathers.SI;
import com.team1160.feathers.api.DigitalServo;
import com.team1160.feathers.api.FrameMath;
import com.team1160.feathers.sensors.LengthSensor;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public abstract class Pulley extends Subsystem{

	/*
	 * -----------------------------------------------------------------------*
	 *                    TO ALL YE WHO ENTER, BE WARNED!                     *
	 *                                                                        *
	 * This class is large... no I mean it this class is pretty damn big.     *
	 *------------------------------------------------------------------------*	 
	 */
	
	
	protected DigitalServo angle;
	protected Jaguar am;
	
	protected Joystick stick;
	protected LengthSensor lengthSensor;
	protected lock l;
	
	public FrameMath meth;
	
	protected int direction;
	protected double angleMin;
	protected double angleMax;
	protected double tapeLenMax;
	protected double tapeLenMin;
	protected double pulleyErrorMax;
	protected double pulleyErrorMin;
	
	protected double servoMaxVelocity;
	protected double servoMaxError;
	
	protected double lastSet;
	protected String name;
	protected long lastSetTime;
	
	public void setAngle(double set){
		set = Math.min(Math.max(set, angleMin), angleMax);  //Fun little line to figure out if set is in bounds and to fix it if not
		this.angle.set(set);
		SmartDashboard.putNumber(name+": Servo value:", angle.get());
		this.lastSet = set;
	}
	
	public void setVelocity(double set){
		if((lengthSensor.getLength() >= tapeLenMax || l.getLockState()  ) && set > 0){
			this.am.set(0);
		}else if(lengthSensor.getLength() <= tapeLenMin && set < 0){
			this.am.set(0);
		}else{
			this.am.set(set*direction);
		}
	}
	
	public void setTapeLength(double goalLength, double error){
		error = Math.max(Math.min(error, pulleyErrorMax), pulleyErrorMin);
		if((goalLength - lengthSensor.getLength()) > error){
			setVelocity(.5);
		}else if((lengthSensor.getLength() - goalLength) > error){
			setVelocity(-.5);
		}else{
			setVelocity(0);
		}
	}
	
	public void setDeltaAngle(double delta){
		setAngle(lastSet+delta);
	}
	
	public void joyAngle(){
		if(stick == null){
			getJoystick();
		}
		setAngle((direction*stick.getY()+1)/2);
	}
	
	// Used for fine tuning the rod angle
	public void joyAdjust(){
		if(stick == null){
			getJoystick();
		}
		setDeltaAngle(stick.getZ()/4);
		lastSet = lastSet -(stick.getZ()/4); //This stops the servo from moving for ever by reseting last to its previous value
	}
	
	public void joyVelocity(){
		if(stick == null){
			getJoystick();
		}
		setVelocity(-stick.getY());
	}
	
	/*
	 * Sets velocityof the servo, the input is a number -1 -> 1 as a
	 * percentage of max velocity we want to set
	 */
    public void setServoVelocity(double velocity) {
    	velocity = Math.max(Math.min(1, velocity), 0);  // If velocity is greater then one make one if less then 0 make 0
    	velocity = velocity*servoMaxVelocity;
    	setDeltaAngle(velocity);
    }	
    
    public void setServoPos(double servoPosition){
    	if(Math.abs(servoPosition - angle.get()) < servoMaxError){
    		setAngle(servoPosition);
    	}else if((servoPosition - angle.get()) > servoMaxError){
    		setServoVelocity(.25);
    	}else{
    		setServoVelocity(-.25);
    	}
    }

	abstract void getJoystick();
	
	public void report(){
		SmartDashboard.putNumber(name+": Tape Length", lengthSensor.getLength());
		SmartDashboard.putNumber(name+": Raw tape", lengthSensor.getRaw());
		SmartDashboard.putNumber(name+": Jag", am.get());
	}
	
    public void setRodAngleFree(double serVeloc, double dTaAn) {
        //need current frameangle and tapelength for next calculations
        double dFrameAngle = Math.toDegrees(SI.getInstance().getAngle());
        // calculates servo value to achieve target angle at current tape length
        double dServVal = meth.calcServoFromAngle(true, dTaAn, lengthSensor.getLength(), dFrameAngle);
        setServoPos(dServVal);
    }

    public void adjustAngleClimbing(boolean flr) {
        double dTpAn = meth.getClimbTapeAngle(flr, lengthSensor.getLength(), SI.getInstance().getAngle());
        double dServVal = meth.calcServoFromAngle(false, Math.toRadians(dTpAn), lengthSensor.getLength(), SI.getInstance().getAngle());
        // Sets the servo by position given the current tape length
        this.setAngle(dServVal);
    }

    
}