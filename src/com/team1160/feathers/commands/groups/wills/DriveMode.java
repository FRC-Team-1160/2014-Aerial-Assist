package com.team1160.feathers.commands.groups.wills;

import com.team1160.feathers.commands.drivetrain.ManualDrive;
import com.team1160.feathers.commands.pulley.Nothing;
import com.team1160.feathers.subsystems.pulleys.MiddlePulley;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveMode extends CommandGroup {
    
    MiddlePulley mpulley;
    
    public DriveMode() {
        
        if(mpulley == null){
            mpulley.getInstance();
        }
        
        addParallel(new ManualDrive());
        addParallel(new Nothing(mpulley));
    }
}
