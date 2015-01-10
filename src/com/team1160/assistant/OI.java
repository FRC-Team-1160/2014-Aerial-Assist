package com.team1160.assistant;

import com.team1160.assistant.commands.DriveForward;
import com.team1160.assistant.commands.Shooter.*;
import com.team1160.assistant.commands.pickup.*;
import com.team1160.assistant.commands.pneumatics.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI implements RobotMap{

    private Joystick stick, shootStick;
    private Button extend, retract, pickupRaise, pickupLower, auto, fire, reload, manPicku, manPickd;
    private static OI instance;

    public static OI getInstance() {
        if (instance == null) {
            instance = new OI();
        }
        return instance;
    }

    private OI() {
        stick = new Joystick(JOY_PORT);
        initButtons();
    }

    private void initButtons() {
        extend = new JoystickButton(stick, JOY_EXTEND);
        retract = new JoystickButton(stick, JOY_RETRACT);
        pickupRaise = new JoystickButton(stick, PICKUP_RAISE_BUT);
        pickupLower = new JoystickButton(stick, PICKUP_LOWER_BUT);
        auto = new JoystickButton(stick, AUTO_BUT);
        fire = new JoystickButton(stick, FIRE_BUT);
        reload = new JoystickButton(stick, RELOAD_BUT);
        manPicku = new JoystickButton(stick, 11);
        manPickd = new JoystickButton(stick, 10);
        tieButtons();
    }

    private void tieButtons() {
        extend.whenPressed(new Extend());
        retract.whenPressed(new Retract());
        pickupRaise.whenPressed(new RaiseArm());
        pickupLower.whenPressed(new LowerArm());
        auto.whenPressed(new DriveForward());
        fire.whenPressed(new Shoot());
        reload.whenPressed(new Reset());
        manPicku.whileHeld(new ManualAdjU());
        manPickd.whileHeld(new ManualAdjD());
    }

    public Joystick getJoystick() {
        return stick;
    }

}