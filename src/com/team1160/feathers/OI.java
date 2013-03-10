package com.team1160.feathers;

import com.team1160.feathers.api.Constants;
import com.team1160.feathers.commands.AssistClimb;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

	protected Joystick driveStick;
	
	protected Button test;
	
	protected static OI instance;
	
	public static OI getInstance(){
		if(instance == null){
			instance = new OI();
		}
		return instance;
	}
	
	private OI() {
		driveStick = new Joystick(Constants.DRIVESTICK);
		test = new JoystickButton(driveStick, 1);
		test.whenPressed(new AssistClimb());
	}
	
	public Joystick getDriveStick(){
		return driveStick;
	}

}
