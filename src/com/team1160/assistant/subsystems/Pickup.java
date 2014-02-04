package com.team1160.assistant.subsystems;

import com.team1160.assistant.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pickup extends Subsystem implements RobotMap{
    
    
    protected Talon talPickup;
    protected static Pickup instance;
    
    protected Pickup(){
        talPickup = new Talon(RobotMap.PICKUP_TAL_MOTOR_SLOT, RobotMap.PICKUP_TAL_MOTOR_CHAN);
    }
    
    public Pickup getInstance(){
        if(instance == null){
            instance = new Pickup();
        }
        return instance;
    }

    protected void initDefaultCommand() {
        
    }
    
}
