package com.team1160.assistant.subsystems;

import com.team1160.assistant.commands.Drive.ArcadeDriveLeft;
import com.team1160.assistant.commands.Drive.ArcadeDriveRight;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;

public class DrivetrainRight extends DrivetrainBase{
    
    protected Talon talDT_R;
    protected Encoder enc_R;
    protected PIDController pidRight;
    protected double ABS_TOL;
    protected static DrivetrainRight instance;
    protected Joystick stick;
    
    public static DrivetrainRight getInstance(){
        if(instance == null){
            instance = new DrivetrainRight();
        }
        return instance;
    }
    
    private DrivetrainRight(){
        talDT_R = new Talon(RIGHT_TAL_MOTOR_CHAN, RIGHT_TAL_MOTOR_SLOT);
        enc_R = new Encoder(ENC_DT_RIGHT_A, ENC_DT_RIGHT_B, true);
        enc_R.start();
        pidRight = new PIDController(0, 0, 0, this, this);
        pidRight.startLiveWindowMode();
        pidRight.enable();
        pidRight.setAbsoluteTolerance(ABS_TOL);
        stick = this.getJoystick();
    }
    
    protected void initDefaultCommand() {
        this.setDefaultCommand(new ArcadeDriveRight());
    }

    public void pidWrite(double d) {
        talDT_R.set(talDT_R.get() + d);
    }

    public double pidGet() {
        return enc_R.pidGet();
    }
    
    public void arcadeRight(){
        talDT_R.set(stick.getX() + stick.getY());
    }

}
