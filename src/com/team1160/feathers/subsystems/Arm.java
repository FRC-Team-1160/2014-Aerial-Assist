package com.team1160.feathers.subsystems;

import com.team1160.feathers.OI;
import com.team1160.feathers.api.Constants;
import com.team1160.feathers.api.DigitalServo;
import com.team1160.feathers.commands.arm.ArmNothing;
import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {

    protected Victor motor;
    protected DigitalServo grip;
    private static Arm instance;
    protected Joystick stick;

    public Arm getInstance() {
        if (instance == null) {
            instance = new Arm();
        }
        return instance;
    }

    private Arm() {
        
    }

    public Arm(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new ArmNothing());
    }
    
    protected void armGoPvoom(){
        
    }
    
    public void armMove(double d){
        motor.set(d);
    }
    
    public void manualArmControl(){
        if (stick == null){
            stick = OI.getInstance().getDriveStick();
        }
        motor.set(-stick.getAxis(Joystick.AxisType.kY));
    }
    
    public void setGrip(boolean ehansBitch){
        if(ehansBitch){
            grip.set(Constants.G_SERVO_GRIP);
        }
        else if(!ehansBitch){
            grip.set(Constants.G_SERVO_OPEN);
        }
    }
}
