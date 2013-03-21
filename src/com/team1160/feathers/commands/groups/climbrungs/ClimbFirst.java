package com.team1160.feathers.commands.groups.climbrungs;

import com.team1160.feathers.SI;
import com.team1160.feathers.commands.CommandGroupBase;
import com.team1160.feathers.commands.TwoStep;

public class ClimbFirst extends CommandGroupBase {

    protected SI si;

    public ClimbFirst() {


        addSequential(new TwoStep());

//        addParallel(new LeftPulleyAngleSet(rAngle));
//        addParallel(new RightPulleyAngleSet(rAngle));
//
//        addParallel(new LeftPulleyLength(6, 0.25));
//        addParallel(new RightPulleyLength(6, 0.25));


    }
}
