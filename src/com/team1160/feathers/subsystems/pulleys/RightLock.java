package com.team1160.feathers.subsystems.pulleys;

import com.team1160.feathers.api.Constants;
import com.team1160.feathers.commands.pulleys.right.RightPulleyLock;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RightLock extends Subsystem implements lock{
    
    protected Servo lock;
    protected boolean l;
    
    
    protected static RightLock instance;

    public static RightLock getInstance(){
        if(instance == null){
            instance = new RightLock();
        }
        return instance;
    }
    
    private RightLock(){
        this.lock = new Servo(Constants.P_RIGHT_LOCK_CAR, Constants.P_RIGHT_LOCK_CHAN);       
    }
    

    public void lock(boolean lock) {
        this.l = lock;
    	if (lock) {
            this.lock.set(Constants.P_RIGHT_LOCK_LOCKED);
        } else {
            this.lock.set(Constants.P_RIGHT_LOCK_OPEN);
        }
    
    }
    
    protected void initDefaultCommand() {
        setDefaultCommand(new RightPulleyLock(false));
    }

    public boolean getLockState() {
        return l;
    }
}