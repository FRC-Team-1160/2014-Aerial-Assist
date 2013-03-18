package com.team1160.feathers.commands.groups.climbrungs;

import com.sun.squawk.util.MathUtils;
import com.team1160.feathers.SI;
import com.team1160.feathers.api.FrameMath;
import com.team1160.feathers.commands.pulleys.left.LeftPulleyAngleSet;
import com.team1160.feathers.commands.pulleys.left.LeftPulleyAngleSetSpecial;
import com.team1160.feathers.commands.pulleys.left.LeftPulleyLength;
import com.team1160.feathers.commands.pulleys.left.LeftPulleyLock;
import com.team1160.feathers.commands.pulleys.right.RightPulleyAngleSet;
import com.team1160.feathers.commands.pulleys.right.RightPulleyAngleSetSpecial;
import com.team1160.feathers.commands.pulleys.right.RightPulleyLength;
import com.team1160.feathers.commands.pulleys.right.RightPulleyLock;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ClimbFirst extends CommandGroup {
    
    protected double frameAngle;
    protected double rAngle;
    protected double lAngle;
    protected FrameMath meth;
    protected double abc;

    protected SI si;

    public ClimbFirst() {
        
        
        addSequential(new LeftPulleyLock(true));
        addSequential(new RightPulleyLock(true));
        addParallel(new RightPulleyAngleSetSpecial(true, 6));
        addParallel(new LeftPulleyAngleSetSpecial(true, 6));
        

    }
}
