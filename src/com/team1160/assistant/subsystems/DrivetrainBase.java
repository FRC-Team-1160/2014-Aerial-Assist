package com.team1160.assistant.subsystems;

import com.team1160.assistant.OI;
import com.team1160.assistant.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public abstract class DrivetrainBase extends Subsystem implements RobotMap, PIDOutput {

    protected Talon tal;
    protected Encoder enc;
    protected PIDController pid;
    protected Joystick stick;
    protected SmartDashboard sd;

    public Joystick getJoystick() {
        if (stick == null) {
            stick = OI.getInstance().getJoystick();
        }
        return stick;
    }

    public void driveDist() {
    }
    
    public void startLogging(String side, PIDController p){
        SmartDashboard.putData(side, p);
    }
    public void startLogging(String side, Encoder p){
        SmartDashboard.putData(side, p);
    }
    
}
