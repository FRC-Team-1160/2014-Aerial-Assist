package com.team1160.assistant;

import com.team1160.assistant.commands.Shooter.TensionAdd;
import com.team1160.assistant.commands.Shooter.TensionLetGo;
import com.team1160.assistant.commands.Shooter.TensionRelease;
import com.team1160.assistant.commands.pickup.LowerArm;
import com.team1160.assistant.commands.pickup.RaiseArm;
//import com.team1160.assistant.commands.vision.VisionCommand;
//import com.team1160.assistant.commands.vision.VisionDoNothing;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/** This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot. */
public class OI {
	// JOYSTICK
	private Joystick stick;
	// BUTTONS
	private Button addTension;
	private Button releaseTension;
	private Button letGo;
        private Button pickupRaise;
        private Button pickupLower;
	//private Button track;
	//private Button stopTrack;
	private static OI instance;
	// ALLOWS CLASSES TO RETRIEVE INSTANCE OF OI
	public static OI getInstance() {
		if (instance == null) {
			instance = new OI();
		}
		return instance;
	}
	private OI() {
		stick = new Joystick(RobotMap.JOY_PORT);
		initButtons();
	}
	private void initButtons() {
		addTension = new JoystickButton(stick, RobotMap.ADD_TENSION_BUT);
		releaseTension = new JoystickButton(stick,
				RobotMap.RELEASE_TENSION_BUT);
		letGo = new JoystickButton(stick, RobotMap.LET_GO_BUT);
		//track = new JoystickButton(stick, RobotMap.VISION_TRACK_BUT);
		//stopTrack = new JoystickButton(stick, RobotMap.STOP_VISION_TRACK_BUT);
                pickupRaise = new JoystickButton(stick, RobotMap.PICKUP_RAISE_BUT);
                pickupLower = new JoystickButton(stick, RobotMap.PICKUP_LOWER_BUT);
		tieButtons();
	}
	private void tieButtons() {
		addTension.whenPressed(new TensionAdd());
		releaseTension.whenPressed(new TensionRelease());
		letGo.whenPressed(new TensionLetGo());
		//track.whenPressed(new VisionCommand());
		//stopTrack.whenPressed(new VisionDoNothing());
                pickupRaise.whileHeld(new RaiseArm());
                pickupLower.whileHeld(new LowerArm());
	}
	// JOYSTICK GETTER FUNCTION
	public Joystick getJoystick() {
		return stick;
	}
}