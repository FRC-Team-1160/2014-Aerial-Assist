package com.team1160.assistant.subsystems;

import com.team1160.assistant.commands.Drive.ArcadeDriveRight;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;


public class DrivetrainLeft extends DrivetrainBase{
    
    protected static DrivetrainLeft instance;
    
    public static DrivetrainLeft getInstance(){
        if(instance == null){
            instance = new DrivetrainLeft();
        }
        return instance;
    }
    
    private DrivetrainLeft(){
        
        tal = new Talon(LEFT_TAL_MOTOR_CHAN, LEFT_TAL_MOTOR_SLOT);
        enc = new Encoder(ENC_DT_LEFT_A, ENC_DT_LEFT_B, true);
        enc.startLiveWindowMode();
        enc.start();
        pid = new PIDController(0, 0, 0, enc, this);
        pid.startLiveWindowMode();
        pid.enable();
        pid.setAbsoluteTolerance(DRIVE_LEFT_TOLERANCE);
        pid.setSetpoint(DRIVE_LEFT_SETPOINT); 
        stick = this.getJoystick();
    }
    
    protected void initDefaultCommand() {
        this.setDefaultCommand(new ArcadeDriveRight());
    }

    public void pidWrite(double d) {
        tal.set(tal.get() + d);
    }

    public double pidGet() {
        return enc.pidGet();
    }
    
    public void arcadeLeft(){
        tal.set(stick.getX() - stick.getY());
    }

}