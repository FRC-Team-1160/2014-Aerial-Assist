package com.team1160.assistant.subsystems;

import com.team1160.assistant.RobotMap;
import com.team1160.assistant.commands.pickup.Stall;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pickup extends Subsystem implements PIDOutput, RobotMap {

    protected Talon talPickup;
    protected static Pickup instance;
    protected Encoder enc;
    protected PIDController pid;

    private Pickup() {
        talPickup = new Talon(PICKUP_TAL_MOTOR_CHAN);
        enc = new Encoder(ENC_PICKUP_A, ENC_PICKUP_B, true);
        enc.start();
        enc.startLiveWindowMode(); 
        pid = new PIDController(0, 0, 0, enc, this);
        pid.startLiveWindowMode();
        pid.enable();
        pid.setAbsoluteTolerance(PICKUP_TOLERANCE);
        pid.setSetpoint(PICKUP_SETPOINT); 
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

//    public void lowerArm() {
//        while (currentPos > PICKUP_HARDSTOP_L) {
//            talPickup.set(LOWER_ARM);
//        }
//    }

    public void stall() {
        talPickup.set(0);
    }

//    public void raiseArm() {
//        while (currentPos < PICKUP_HARDSTOP_H) {
//            talPickup.set(RAISE_ARM);
//        }
//    }

    public double pidGet() {
        return enc.pidGet();
    }

    public void pidWrite(double d) {
        talPickup.set(talPickup.get()+d);
    }
    
    public void raiseArm(){
        talPickup.set(-1);
    }
    
    public void lowerArm(){
        talPickup.set(1);
    }
    
}
