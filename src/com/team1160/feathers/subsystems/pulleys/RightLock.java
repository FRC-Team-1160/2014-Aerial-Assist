package com.team1160.feathers.subsystems.pulleys;

import com.team1160.feathers.api.Constants;
import com.team1160.feathers.commands.pulleys.right.RightPulleyLock;

import edu.wpi.first.wpilibj.Servo;

public class RightLock extends Lock{
    
    
    
    protected static RightLock instance;

    public static RightLock getInstance(){
        if(instance == null){
            instance = new RightLock();
        }
        return instance;
    }
    
    private RightLock(){
        this.servo = new Servo(Constants.P_RIGHT_LOCK_CAR, Constants.P_RIGHT_LOCK_CHAN);       
        this.locked = Constants.P_RIGHT_LOCK_LOCKED;
        this.unlocked = Constants.P_RIGHT_LOCK_OPEN;
    }
    

    
    protected void initDefaultCommand() {
        setDefaultCommand(new RightPulleyLock(false));
    }

}