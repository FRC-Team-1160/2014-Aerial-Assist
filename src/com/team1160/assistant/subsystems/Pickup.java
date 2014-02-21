package com.team1160.assistant.subsystems;

import com.team1160.assistant.RobotMap;
import com.team1160.assistant.commands.pickup.Stall;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pickup extends Subsystem implements RobotMap {

    protected Talon talPickup;
    protected static Pickup instance;
    protected DigitalInput limitSwitchL, limitSwitchH;

    private Pickup() {
        talPickup = new Talon(PICKUP_TAL_MOTOR);
        limitSwitchL = new DigitalInput(LIMIT_PICKUP_L);
        limitSwitchH = new DigitalInput(LIMIT_PICKUP_H);
    }

    public static Pickup getInstance() {
        if (instance == null) {
            instance = new Pickup();
        }
        return instance;
    }

    protected void initDefaultCommand() {
        this.setDefaultCommand(new Stall());
    }

    public void stall() {
        talPickup.set(0);
    }
    
    public void raiseArm(){
        talPickup.set(RAISE_ARM);
    }
    
    public void lowerArm(){
        talPickup.set(LOWER_ARM);
    }
    
    public boolean getLimitLower(){
        return limitSwitchL.get();
    }
    
    public boolean getLimitHigh(){
        return limitSwitchH.get();
    }
    
    public void manualAdjUP(){
        talPickup.set(-0.5);
    }
    
    public void manualAdjDOWN(){
        talPickup.set(0.5);
    }
    
}
