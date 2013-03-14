package com.team1160.feathers.subsystems.pulleys;

import com.team1160.feathers.OI;
import com.team1160.feathers.SI;
import com.team1160.feathers.api.Constants;
import com.team1160.feathers.api.DigitalServo;
import com.team1160.feathers.commands.pulleys.left.LeftPulleyAngle;

import edu.wpi.first.wpilibj.Jaguar;


public class LeftPulley extends Pulley{

	
	protected static LeftPulley instance;
	
	public static LeftPulley getInstance(){
		if(instance == null){
			instance = new LeftPulley();
		}
		return instance;
	}
	
	protected LeftPulley(){
		am = new Jaguar(Constants.P_LEFT_JAG_CAR, Constants.P_LEFT_JAG_CHAN);
		angle = new DigitalServo(Constants.P_LEFT_SERVO_CAR, Constants.P_LEFT_SERVO_CHAN);
		l = LeftLock.getInstance();
		lengthSensor = SI.getInstance().getLeft();
		direction = 1;
		tapeLenMax = 42;
		tapeLenMin = .5;
		angleMax = 1;
		angleMin = 0;
		pulleyErrorMax = 1;
		pulleyErrorMin = .1;		
	}
	
	void getJoystick() {
		stick =  OI.getInstance().getLeftStick();
	}

	
	protected void initDefaultCommand() {
		setDefaultCommand(new LeftPulleyAngle());
	}

}