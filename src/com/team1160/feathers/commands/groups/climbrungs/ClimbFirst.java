package com.team1160.feathers.commands.groups.climbrungs;

import com.sun.squawk.util.MathUtils;
import com.team1160.feathers.SI;
import com.team1160.feathers.api.FrameMath;
import com.team1160.feathers.commands.pulleys.left.LeftPulleyAngleSet;
import com.team1160.feathers.commands.pulleys.left.LeftPulleyLength;
import com.team1160.feathers.commands.pulleys.middle.MiddlePulleyAngleSet;
import com.team1160.feathers.commands.pulleys.middle.MiddlePulleyLength;
import com.team1160.feathers.commands.pulleys.right.RightPulleyAngleSet;
import com.team1160.feathers.commands.pulleys.right.RightPulleyLength;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ClimbFirst extends CommandGroup {
    
    protected double frameAngle;
    protected double rAngle;
    protected double mAngle;
    protected FrameMath meth;
    protected double abc;

    protected SI si;

    public ClimbFirst() {
        
        if(si == null){
            si = SI.getInstance();
        }
        frameAngle = si.getAngleDegrees();
        
        abc = MathUtils.asin(35/30.75);
        rAngle = meth.calcServoFromAngle(true, abc, 6, frameAngle);
        
        
        addParallel(new LeftPulleyAngleSet(rAngle));
        addParallel(new RightPulleyAngleSet(rAngle));

        addParallel(new LeftPulleyLength(6, 0.25));
        addParallel(new RightPulleyLength(6, 0.25));


    }
}
