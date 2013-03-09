package com.team1160.feathers;

import com.team1160.feathers.api.Constants;

import edu.wpi.first.wpilibj.Joystick;

public class OI {

	protected Joystick driveStick;
	
	protected static OI instance;
	
	public static OI getInstance(){
		if(instance == null){
			instance = new OI();
		}
		return instance;
	}
	
	private OI() {
		driveStick = new Joystick(Constants.DRIVESTICK);
	}
	
	public Joystick getDriveStick(){
		return driveStick;
	}

}
