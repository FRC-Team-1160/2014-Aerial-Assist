package com.team1160.feathers.subsystems.pulleys;

import com.team1160.feathers.api.Constants;
import com.team1160.feathers.commands.pulleys.left.LeftPulleyLock;

import edu.wpi.first.wpilibj.Servo;

public class LeftLock extends Lock {

    protected static LeftLock instance;
    
    public static LeftLock getInstance() {
        if (instance == null) {
            instance = new LeftLock();
        }
        return instance;
    }

    protected LeftLock() {
        servo = new Servo(Constants.P_LEFT_LOCK_CAR, Constants.P_LEFT_LOCK_CHAN);
        locked = Constants.P_LEFT_LOCK_LOCKED;
        unlocked = Constants.P_LEFT_LOCK_OPEN;
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new LeftPulleyLock(false));
    }
}
