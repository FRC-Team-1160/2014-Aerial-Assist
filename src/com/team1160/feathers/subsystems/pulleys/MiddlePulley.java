package com.team1160.feathers.subsystems.pulleys;

import com.team1160.feathers.OI;
import com.team1160.feathers.SI;
import com.team1160.feathers.api.Constants;
import com.team1160.feathers.api.DigitalServo;
import com.team1160.feathers.commands.pulleys.middle.MiddleNothing;
	
import edu.wpi.first.wpilibj.Jaguar;

public class MiddlePulley extends Pulley {

    protected static MiddlePulley instance;

    public static MiddlePulley getInstance() {
        if (instance == null) {
            instance = new MiddlePulley();
        }
        return instance;
    }

    protected MiddlePulley() {
        name = "Middle";
    	am = new Jaguar(Constants.P_TOP_JAG_CAR, Constants.P_TOP_JAG_CHAN);
        angle = new DigitalServo(Constants.P_TOP_SERVO_CAR, Constants.P_TOP_SERVO_CHAN);
        //l = LeftLock.getInstance();
        lengthSensor = SI.getInstance().getMid();
        direction = -1;
        tapeLenMax = 42;
        tapeLenMin = .5;
        angleMax = 0.78;
        angleMin = 0.1;
        pulleyErrorMax = 1;
        pulleyErrorMin = .1;
    }
    
    protected void initDefaultCommand() {
        setDefaultCommand(new MiddleNothing());
    }

    void getJoystick() {
        stick = OI.getInstance().getDriveStick();
    }

    public void setVelocity(double set) {
        if ((lengthSensor.getLength() >= tapeLenMax) && set > 0) {
            this.am.set(0);
        } else if (lengthSensor.getLength() <= tapeLenMin && set < 0) {
            this.am.set(0);
        } else {
            this.am.set(set * direction);
        }
    }
}
