package com.team1160.feathers.commands.groups.prepare;

import edu.wpi.first.wpilibj.command.CommandGroup;
import com.team1160.feathers.commands.CommandBase;
import com.team1160.feathers.commands.pulleys.left.LeftPulleyLength;
import com.team1160.feathers.commands.pulleys.middle.MiddlePulleyLength;
import com.team1160.feathers.commands.pulleys.right.RightPulleyLength;

public class PrepareDrive extends CommandGroup{
    
    public PrepareDrive(){
        addParallel(new LeftPulleyLength(1.5, 0.5));
        addParallel(new MiddlePulleyLength(1.5, 0.5));
        addParallel(new RightPulleyLength(1.5, 0.5));
    }
    
}
