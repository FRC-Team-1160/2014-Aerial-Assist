package com.team1160.feathers.commands.groups.prepare;

import com.team1160.feathers.commands.pulleyAngleLength;
import com.team1160.feathers.subsystems.pulleys.LeftPulley;
import com.team1160.feathers.subsystems.pulleys.MiddlePulley;
import com.team1160.feathers.subsystems.pulleys.Pulley;
import com.team1160.feathers.subsystems.pulleys.RightPulley;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PrepareDrive extends CommandGroup{
    
	Pulley left,right,middle;
	
    public PrepareDrive(){
    	left = LeftPulley.getInstance();
    	right = RightPulley.getInstance();
    	middle = MiddlePulley.getInstance();
    	addParallel(new pulleyAngleLength(left, 180, 5, false));
        addParallel(new pulleyAngleLength(right, 180, 5, false));
        addParallel(new pulleyAngleLength(middle, 90, 9.5, false));
    }
    
}
