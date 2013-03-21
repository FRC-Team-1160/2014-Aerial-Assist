package com.team1160.feathers;

import com.team1160.feathers.api.Constants;
import com.team1160.feathers.commands.MiddleFinish;
import com.team1160.feathers.commands.UnlockPulley;
import com.team1160.feathers.commands.groups.climbrungs.ClimbFirst;
import com.team1160.feathers.commands.groups.climbrungs.ClimbSecond;
import com.team1160.feathers.commands.groups.prepare.PrepareClimb;
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
import com.team1160.feathers.subsystems.pulleys.LeftLock;
import com.team1160.feathers.subsystems.pulleys.LeftPulley;
import com.team1160.feathers.subsystems.pulleys.RightLock;
import com.team1160.feathers.subsystems.pulleys.RightPulley;

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
	protected Button wFourtyFive;
	protected Button wEleven;
	protected Button wEight;
        protected Button wMFinish;
	
	// Left Buttons
	protected Button lAngle;
	protected Button lLength;
	protected Button lLock;
	protected Button lULock;
	protected Button lAdjust;
	protected Button test;
	protected Button lFourtyFive;
	
	//Right Buttons
	protected Button rAngle;
	protected Button rLength;
	protected Button rLock;
        protected Button rULock;
	protected Button rAdjust;
	protected Button rFourtyFive;
	
	
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
		wFourtyFive = new JoystickButton(driveStick, 3);
		wAngle = new JoystickButton(driveStick, 4);
		wLength = new JoystickButton(driveStick, 5);
                wMFinish = new JoystickButton(driveStick, 6);
		wEleven = new JoystickButton(driveStick, 11);
		wEight = new JoystickButton(driveStick, 8);
		
		//Right Buttons
		rAngle = new JoystickButton(rightStick, 1);
		rLength = new JoystickButton(rightStick, 2);
		rFourtyFive = new JoystickButton(rightStick, 3);
		rLock = new JoystickButton(rightStick, 4);
		rULock = new JoystickButton(rightStick, 5);
		rAdjust = new JoystickButton(rightStick, 6);
		
		//Left Buttons
		lAngle = new JoystickButton(leftStick, 1);
		lLength = new JoystickButton(leftStick,2);
		lFourtyFive = new JoystickButton(leftStick, 3);
		lLock = new JoystickButton(leftStick, 4);
		lULock = new JoystickButton(leftStick, 5);
		lAdjust = new JoystickButton(leftStick, 6);
			
		//Assign the buttons to their commands
		tieButtons();
	}

	private void tieButtons() {
		//Wills buttons
		driveMode.whenPressed(new DriveMode());
		wAngle.whenPressed(new WillAngle());
		wLength.whenPressed(new WillLength());
		wFourtyFive.whenPressed(new PrepareClimb());
		wEleven.whenPressed(new ClimbFirst());
		wEight.whenPressed(new ClimbSecond());
		wMFinish.whenPressed(new MiddleFinish(true));
		
		//Right buttons
		rAngle.whenPressed(new RightPulleyAngle());
		rLength.whenPressed(new RightPulleyExtend());
		rLock.whenPressed(new RightPulleyLock(true));
		rULock.whenPressed(new UnlockPulley(RightLock.getInstance(), RightPulley.getInstance()));
		rAdjust.whenPressed(new RightPulleyAdjust());
		
		//Left buttons
		lAngle.whenPressed(new LeftPulleyAngle());
		lLength.whenPressed(new LeftPulleyExtend());
		lLock.whenPressed(new LeftPulleyLock(true));
		lULock.whenPressed(new UnlockPulley(LeftLock.getInstance(), LeftPulley.getInstance()));
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