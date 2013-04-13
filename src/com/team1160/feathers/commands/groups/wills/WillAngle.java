package com.team1160.feathers.commands.groups.wills;

import com.team1160.feathers.commands.drivetrain.Halt;
import com.team1160.feathers.commands.pulley.Nothing;
import com.team1160.feathers.subsystems.pulleys.MiddlePulley;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class WillAngle extends CommandGroup {
    
    MiddlePulley mpulley;
    
    public WillAngle() {
        addParallel(new Halt());
        addParallel(new Nothing(mpulley));
    }
}
