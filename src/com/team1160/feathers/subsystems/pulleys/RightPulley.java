package com.team1160.feathers.subsystems.pulleys;

import com.team1160.feathers.OI;
import com.team1160.feathers.SI;
import com.team1160.feathers.api.Constants;
import com.team1160.feathers.api.DigitalServo;
import com.team1160.feathers.api.FrameMath;
import com.team1160.feathers.commands.pulley.Nothing;

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
        name = "Right";
    	am = new Jaguar(Constants.P_RIGHT_JAG_CAR, Constants.P_RIGHT_JAG_CHAN);
        angle = new DigitalServo(Constants.P_RIGHT_SERVO_CAR, Constants.P_RIGHT_SERVO_CHAN);
        l = RightLock.getInstance();
        lengthSensor = SI.getInstance().getRight();
        direction = -1;
        tapeLenMax = 34.5;
        tapeLenMin = 5;
        angleMax = 0.65;
        angleMin = 0.24;
        pulleyErrorMax = 1;
        pulleyErrorMin = .1;
        meth = new FrameMath(false, -.00369, .969, "right pulley");
    }

    void getJoystick() {
        stick = OI.getInstance().getRightStick();
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new Nothing(getInstance()));
    }
}