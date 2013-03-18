package com.team1160.feathers.commands.groups.climbrungs;

import com.team1160.feathers.SI;
import com.team1160.feathers.commands.pulleys.left.LeftPulleyLock;
import com.team1160.feathers.commands.pulleys.middle.MiddlePulleyAngleSetSpecial;
import com.team1160.feathers.commands.pulleys.middle.MiddlePulleyLength;
import com.team1160.feathers.commands.pulleys.right.RightPulleyLock;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ClimbSecond extends CommandGroup {

    SI si;
    
    public ClimbSecond() {
        
        if (si == null){
            si = SI.getInstance();
        }
        
        //addParallel(new MiddlePulleyAngleSet());
        addSequential(new MiddlePulleyLength(43, 0.1));
        
        addSequential(new MiddlePulleyLength(41, 0.1));
        addSequential(new LeftPulleyLock(false));
        addSequential(new RightPulleyLock(false));
        
    }
}
