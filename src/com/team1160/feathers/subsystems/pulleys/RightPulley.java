package com.team1160.feathers.subsystems.pulleys;

import com.team1160.feathers.OI;
import com.team1160.feathers.SI;
import com.team1160.feathers.api.Constants;
import com.team1160.feathers.api.DigitalServo;
import com.team1160.feathers.commands.pulleys.right.RightPulleyAngle;
import edu.wpi.first.wpilibj.Jaguar;

public class RightPulley extends Pulley {

    protected static RightPulley instance;

    public static RightPulley getInstance() {
        if (instance == null) {
            instance = new RightPulley();
        }
        return instance;
    }

    protected RightPulley() {
        am = new Jaguar(Constants.P_RIGHT_JAG_CAR, Constants.P_RIGHT_JAG_CHAN);
        angle = new DigitalServo(Constants.P_RIGHT_SERVO_CAR, Constants.P_RIGHT_SERVO_CHAN);
        l = RightLock.getInstance();
        lengthSensor = SI.getInstance().getRight();
        direction = 1;
        tapeLenMax = 42;
        tapeLenMin = .5;
        angleMax = 1;
        angleMin = 0;
        pulleyErrorMax = 1;
        pulleyErrorMin = .1;
    }

    void getJoystick() {
        stick = OI.getInstance().getRightStick();
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new RightPulleyAngle());
    }
}