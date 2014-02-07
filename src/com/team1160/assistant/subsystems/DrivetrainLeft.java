package com.team1160.assistant.subsystems;

import com.team1160.assistant.commands.Drive.ArcadeDriveLeft;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;


public class DrivetrainLeft extends DrivetrainBase{
    
    protected static DrivetrainLeft instance;
    protected Encoder enc_L;
    protected PIDController pidLeft;
    protected Talon talDT_L;
    protected double ABS_TOL = 0;
    protected Joystick stick;
    
    public static DrivetrainLeft getInstance(){
        if(instance == null){
            instance = new DrivetrainLeft();
        }
        return instance;
    }
    
    private DrivetrainLeft(){
        
        talDT_L = new Talon(LEFT_TAL_MOTOR_CHAN, LEFT_TAL_MOTOR_SLOT);
        enc_L = new Encoder(ENC_DT_LEFT_A, ENC_DT_LEFT_B, true);
        enc_L.start();
        pidLeft = new PIDController(0, 0, 0, this, this);
        pidLeft.startLiveWindowMode();
        pidLeft.enable();
        pidLeft.setAbsoluteTolerance(ABS_TOL);
        stick = this.getJoystick();
    }
    
    protected void initDefaultCommand() {
        this.setDefaultCommand(new ArcadeDriveLeft());
    }

    public void pidWrite(double d) {
        talDT_L.set(talDT_L.get() + d);
    }

    public double pidGet() {
        return enc_L.pidGet();
    }
    
    public void arcadeLeft(){
        talDT_L.set(stick.getX() - stick.getY());
    }

}