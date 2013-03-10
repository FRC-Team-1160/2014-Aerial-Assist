package com.team1160.feathers.subsystems;

import com.team1160.feathers.api.Constants;
import com.team1160.feathers.api.DigitalServo;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RightPulley extends Subsystem{

	protected Servo lock;
	protected DigitalServo angle;
	protected Jaguar am;
	
	protected static RightPulley instance;
	
	public static RightPulley getInstance(){
		if(instance == null){
			instance = new RightPulley();
		}
		return instance;
	}
	
	protected RightPulley(){
		lock = new Servo(Constants.P_RIGHT_LOCK_CAR, Constants.P_RIGHT_LOCK_CHAN);
		angle = new DigitalServo(Constants.P_RIGHT_SERVO_CAR, Constants.P_RIGHT_SERVO_CHAN);
		am = new Jaguar(Constants.P_RIGHT_JAG_CAR, Constants.P_RIGHT_JAG_CHAN);
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

	public void lock(boolean lock){
		if(lock){
			this.lock.set(Constants.P_RIGHT_LOCK_LOCKED);
		}else{
			this.lock.set(Constants.P_RIGHT_LOCK_OPEN);
		}
	}

}
