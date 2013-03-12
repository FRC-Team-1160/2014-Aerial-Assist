package com.team1160.feathers.subsystems;

import com.team1160.feathers.api.Constants;
import com.team1160.feathers.commands.pulleys.left.LeftPulleyLock;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LeftLock extends Subsystem {

    protected static LeftLock instance;
    protected Servo lock;

    public static LeftLock getInstance() {
        if (instance == null) {
            instance = new LeftLock();
        }
        return instance;
    }

    protected LeftLock() {
        lock = new Servo(Constants.P_LEFT_LOCK_CAR, Constants.P_LEFT_LOCK_CHAN);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new LeftPulleyLock(false));
    }

    public void lock(boolean lock) {
        if(lock) {
            this.lock.set(Constants.P_LEFT_LOCK_LOCKED);
        } else {
            this.lock.set(Constants.P_LEFT_LOCK_OPEN);
        }
    }
}
