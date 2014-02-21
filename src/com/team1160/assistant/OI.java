package com.team1160.assistant;

import com.team1160.assistant.commands.DriveForward;
import com.team1160.assistant.commands.Shooter.Reset;
import com.team1160.assistant.commands.Shooter.Shoot;
import com.team1160.assistant.commands.pickup.LowerArm;
import com.team1160.assistant.commands.pickup.ManualAdjD;
import com.team1160.assistant.commands.pickup.ManualAdjU;
import com.team1160.assistant.commands.pickup.RaiseArm;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI implements RobotMap{

    private Joystick stick, shootStick;
    private Button pickupRaise, pickupLower, auto, fire, reload, manPicku, manPickd;
    private static OI instance;

    public static OI getInstance() {
        if (instance == null) {
            instance = new OI();
        }
        return instance;
    }

    private OI() {
        stick = new Joystick(JOY_PORT);
        shootStick = new Joystick(SHOOT_STICK);
        initButtons();
    }

    private void initButtons() {
        pickupRaise = new JoystickButton(stick, PICKUP_RAISE_BUT);
        pickupLower = new JoystickButton(stick, PICKUP_LOWER_BUT);
        auto = new JoystickButton(stick, AUTO_BUT);
        fire = new JoystickButton(stick, FIRE_BUT);
        reload = new JoystickButton(stick, RELOAD_BUT);
        manPicku = new JoystickButton(shootStick, MAN_PICKUP_U);
        manPickd = new JoystickButton(shootStick, MAN_PICKUP_D);
        tieButtons();
    }

    private void tieButtons() {
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
    
    public Joystick getShootJoystick(){
        return shootStick;
    }

}