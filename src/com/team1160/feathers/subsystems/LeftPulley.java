package com.team1160.feathers.subsystems;

import com.team1160.feathers.OI;
import com.team1160.feathers.api.Constants;
import com.team1160.feathers.api.DigitalServo;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LeftPulley extends Subsystem{

	protected Joystick stick;
	
	protected Servo lock;
	protected DigitalServo angle;
	protected Jaguar am;
	
	protected static LeftPulley instance;
	
	public static LeftPulley getInstance(){
		if(instance == null){
			instance = new LeftPulley();
		}
		return instance;
	}
	
	protected LeftPulley(){
		lock = new Servo(Constants.P_LEFT_LOCK_CAR, Constants.P_LEFT_LOCK_CHAN);
		angle = new DigitalServo(Constants.P_LEFT_SERVO_CAR, Constants.P_LEFT_SERVO_CHAN);
		am = new Jaguar(Constants.P_LEFT_JAG_CAR, Constants.P_LEFT_JAG_CHAN);
	}
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub		
	}
	
	public void setAngle(double set){
		this.angle.set(set);
	}
	
	public void setVelocity(double set){
		this.am.set(set);
	}
	
	public void joyAngle(){
		if(stick == null){
			stick = OI.getInstance().getLeftStick();
		}
		angle.set((stick.getY()+1)/2);
	}
	
	public void joyVelocity(){
		if(stick == null){
			stick = OI.getInstance().getLeftStick();
		}
		am.set(stick.getY());
	}

	public void lock(boolean lock){
		if(lock){
			this.lock.set(Constants.P_LEFT_LOCK_LOCKED);
		}else{
			this.lock.set(Constants.P_LEFT_LOCK_OPEN);
		}
	}
}
