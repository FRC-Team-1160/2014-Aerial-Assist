package com.team1160.feathers.commands.groups.climbrungs;

import com.team1160.feathers.SI;
import com.team1160.feathers.commands.CommandGroupBase;
import com.team1160.feathers.commands.DefensiveClimb;

public class ClimbFirst extends CommandGroupBase {
    

    protected SI si;

    public ClimbFirst() {
        
        
    	addParallel(new DefensiveClimb(rightPulley, rightLock, 7.5, true, .8));
    	addParallel(new DefensiveClimb(leftPulley, leftLock, 6.8, true, .66));
        
//        addParallel(new LeftPulleyAngleSet(rAngle));
//        addParallel(new RightPulleyAngleSet(rAngle));
//
//        addParallel(new LeftPulleyLength(6, 0.25));
//        addParallel(new RightPulleyLength(6, 0.25));


    }
}
