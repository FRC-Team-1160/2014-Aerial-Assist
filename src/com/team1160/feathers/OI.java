package com.team1160.feathers;

import com.team1160.feathers.api.Constants;
import com.team1160.feathers.commands.groups.wills.DriveMode;
import com.team1160.feathers.commands.groups.wills.WillAngle;
import com.team1160.feathers.commands.groups.wills.WillLength;
import com.team1160.feathers.commands.pulleys.left.LeftPulleyAdjust;
import com.team1160.feathers.commands.pulleys.left.LeftPulleyAngle;
import com.team1160.feathers.commands.pulleys.left.LeftPulleyExtend;
import com.team1160.feathers.commands.pulleys.left.LeftPulleyLock;
import com.team1160.feathers.commands.pulleys.right.RightPulleyAdjust;
import com.team1160.feathers.commands.pulleys.right.RightPulleyAngle;
import com.team1160.feathers.commands.pulleys.right.RightPulleyExtend;
import com.team1160.feathers.commands.pulleys.right.RightPulleyLock;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	
	//Joystick
	protected Joystick driveStick;
	protected Joystick leftStick;
	protected Joystick rightStick;

	// Wills buttons
	protected Button driveMode;
	protected Button wAngle;
	protected Button wLength;
	
	// Left Buttons
	protected Button lAngle;
	protected Button lLength;
	protected Button lLock;
	protected Button lULock;
	protected Button lAdjust;
	
	//Right Buttons
	protected Button rAngle;
	protected Button rLength;
	protected Button rLock;
    protected Button rULock;
	protected Button rAdjust;
	
	
	protected static OI instance;
	
	public static OI getInstance(){
		if(instance == null){
			instance = new OI();
		}
		return instance;
	}
	
	private OI() {
		driveStick = new Joystick(Constants.DRIVESTICK);
		leftStick = new Joystick(Constants.LeftStick);
		rightStick = new Joystick(Constants.RightStick);
		initButtons();
	}
	
	private void initButtons() {
		// Wills buttons
		driveMode = new JoystickButton(driveStick, 1);
		wAngle = new JoystickButton(driveStick, 4);
		wLength = new JoystickButton(driveStick, 5);
		
		//Right Buttons
		rAngle = new JoystickButton(rightStick, 1);
		rLength = new JoystickButton(rightStick, 2);
		rLock = new JoystickButton(rightStick, 4);
		rULock = new JoystickButton(rightStick, 5);
		rAdjust = new JoystickButton(rightStick, 8);
		
		//Left Buttons
		lAngle = new JoystickButton(leftStick, 1);
		lLength = new JoystickButton(leftStick,2);
		lLock = new JoystickButton(leftStick, 4);
		lULock = new JoystickButton(leftStick, 5);
		lAdjust = new JoystickButton(leftStick, 8);
		
		//Assign the buttons to their commands
		tieButtons();
	}

	private void tieButtons() {
		//Wills buttons
		driveMode.whenPressed(new DriveMode());
		wAngle.whenPressed(new WillAngle());
		wLength.whenPressed(new WillLength());
		
		//Right buttons
		rAngle.whenPressed(new RightPulleyAngle());
		rLength.whenPressed(new RightPulleyExtend());
		rLock.whenPressed(new RightPulleyLock(true));
		rULock.whenPressed(new RightPulleyLock(false));
		rAdjust.whenPressed(new RightPulleyAdjust());
		
		//Left buttons
		lAngle.whenPressed(new LeftPulleyAngle());
		lLength.whenPressed(new LeftPulleyExtend());
		lLock.whenPressed(new LeftPulleyLock(true));
		lULock.whenPressed(new LeftPulleyLock(false));
		lAdjust.whenPressed(new LeftPulleyAdjust());
	}

	public Joystick getDriveStick(){
		return driveStick;
	}
	
	public Joystick getLeftStick(){
		return leftStick;
	}
	
	public Joystick getRightStick(){
		return rightStick;
	}	
}