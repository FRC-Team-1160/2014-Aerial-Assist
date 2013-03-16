package com.team1160.feathers.commands.groups.prepare;

import com.team1160.feathers.commands.pulleys.left.LeftPulleyLength;
import com.team1160.feathers.commands.pulleys.middle.MiddlePulleyLength;
import com.team1160.feathers.commands.pulleys.right.RightPulleyLength;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class PrepareClimb extends CommandGroup{
    
    public PrepareClimb(){
        addParallel(new RightPulleyLength(6, 0.5));
        addParallel(new LeftPulleyLength(6, 0.5));
        addParallel(new MiddlePulleyLength(6, 0.5));
    }
    
}
