package com.team1160.feathers.subsystems.pulleys;

import com.team1160.feathers.OI;
import com.team1160.feathers.api.DigitalServo;
import com.team1160.feathers.sensors.LengthSensor;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class Pulley extends Subsystem{
	
	protected DigitalServo angle;
	protected Jaguar am;
	
	protected Joystick stick;
	protected LengthSensor lengthSensor;
	protected lock l;
	
	protected int direction;
	protected double angleMin;
	protected double angleMax;
	protected double tapeLenMax;
	protected double tapeLenMin;
	protected double pulleyErrorMax;
	protected double pulleyErrorMin;
	
	protected double lastSet;
	
	public void setAngle(double set){
		set = Math.min(Math.max(set, angleMin), angleMax);  //Fun little line to figure out if set is in bounds and to fix it if not
		this.angle.set(set);
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
			stick = OI.getInstance().getLeftStick();
		}
		setAngle((stick.getY()+1)/2);
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
	
	abstract void getJoystick();
}