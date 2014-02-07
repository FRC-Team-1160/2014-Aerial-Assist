package com.team1160.assistant.subsystems;

import com.team1160.assistant.OI;
import com.team1160.assistant.RobotMap;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class DrivetrainBase extends Subsystem implements RobotMap, PIDSource, PIDOutput {
    
    public Joystick getJoystick() {
        return OI.getInstance().getJoystick();
    }
   
}
