package com.team1160.assistant.subsystems;

import com.team1160.assistant.RobotMap;
import com.team1160.assistant.commands.pickup.LowerArm;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pickup extends Subsystem implements RobotMap{
    
    
    protected Talon talPickup;
    protected static Pickup instance;
    protected double currentPos;
    
    protected Pickup(){
        talPickup = new Talon(PICKUP_TAL_MOTOR_SLOT, PICKUP_TAL_MOTOR_CHAN);
    }
    
    public Pickup getInstance(){
        if(instance == null){
            instance = new Pickup();
        }
        return instance;
    }

    protected void initDefaultCommand() {
        this.setDefaultCommand(new LowerArm());
    }
    
    public void lowerArm(){
        while(currentPos > PICKUP_HARDSTOP_L){
            talPickup.set(LOWER_ARM);
        }
    }
    
    public void stall(){
        talPickup.set(PICKUP_STALL);
    }
    
    public void raiseArm(){
        while(currentPos < PICKUP_HARDSTOP_H){
            talPickup.set(RAISE_ARM);
        }
    }
    
}
