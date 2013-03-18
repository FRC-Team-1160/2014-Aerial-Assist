package com.team1160.feathers.commands.groups.prepare;

import com.sun.squawk.util.MathUtils;
import com.team1160.feathers.SI;
import com.team1160.feathers.api.FrameMath;
import com.team1160.feathers.commands.pulleys.left.LeftPulleyAngleSet;
import com.team1160.feathers.commands.pulleys.left.LeftPulleyLength;
import com.team1160.feathers.commands.pulleys.right.RightPulleyAngleSet;
import com.team1160.feathers.commands.pulleys.right.RightPulleyLength;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class PrepareClimb extends CommandGroup{
    
    protected SI si;
    protected FrameMath meth;
    protected double rAngle, lAngle, abc, frameAngle;
    
    public PrepareClimb(){
        if(si == null){
            si = SI.getInstance();
        }
        
        si.reset();
        
        frameAngle = si.getAngleDegrees();
        
        abc = MathUtils.asin(35/30.75);
        rAngle = meth.calcServoFromAngle(true, abc, si.getRightl(), frameAngle);
        lAngle = meth.calcServoFromAngle(true, abc, si.getLeftl(), frameAngle);
        
        
        addParallel(new LeftPulleyAngleSet(lAngle));
        addParallel(new RightPulleyAngleSet(rAngle));

        addParallel(new LeftPulleyLength(35, 0.25));
        addParallel(new RightPulleyLength(35, 0.25));
        
    }
    
}
