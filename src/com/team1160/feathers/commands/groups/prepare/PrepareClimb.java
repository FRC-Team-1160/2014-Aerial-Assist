package com.team1160.feathers.commands.groups.prepare;

import com.sun.squawk.util.MathUtils;
import com.team1160.feathers.commands.pulleyAngleLength;
import com.team1160.feathers.subsystems.pulleys.LeftPulley;
import com.team1160.feathers.subsystems.pulleys.MiddlePulley;
import com.team1160.feathers.subsystems.pulleys.Pulley;
import com.team1160.feathers.subsystems.pulleys.RightPulley;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PrepareClimb extends CommandGroup{

	double abc;
	Pulley left, right, middle;
	
    public PrepareClimb(){
       
    	left = LeftPulley.getInstance();
    	right = RightPulley.getInstance();
    	middle = MiddlePulley.getInstance();
    	
        abc  = 45;
    	addParallel(new pulleyAngleLength(right, abc, 35));
        addParallel(new pulleyAngleLength(middle, 80, 20));   
        addParallel(new pulleyAngleLength(left , abc, 35));
    }	
    
}
