package com.team1160.assistant.commands.Drive;

import com.team1160.assistant.OI;
import com.team1160.assistant.commands.CommandBase;
import edu.wpi.first.wpilibj.Joystick;

public class ArcadeDrive extends CommandBase {
    
    Joystick stick;
    
    public ArcadeDrive() {
        requires(dt);
    }

    protected void initialize() {
        stick = OI.getInstance().getJoystick();
    }

    protected void execute() {
        dt.manualDrive(stick);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}