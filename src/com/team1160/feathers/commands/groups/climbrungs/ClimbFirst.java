package com.team1160.feathers.commands.groups.climbrungs;

import com.team1160.feathers.commands.pulleys.left.LeftPulleyAngleSet;
import com.team1160.feathers.commands.pulleys.left.LeftPulleyLength;
import com.team1160.feathers.commands.pulleys.middle.MiddlePulleyAngleSet;
import com.team1160.feathers.commands.pulleys.middle.MiddlePulleyLength;
import com.team1160.feathers.commands.pulleys.right.RightPulleyAngleSet;
import com.team1160.feathers.commands.pulleys.right.RightPulleyLength;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ClimbFirst extends CommandGroup {

    public ClimbFirst() {
        //Bullshit angle+length values.... change before use
        addParallel(new LeftPulleyAngleSet(.3));
        addParallel(new RightPulleyAngleSet(.2));
        addParallel(new MiddlePulleyAngleSet(.1));
        //Again.. change before use
        addParallel(new LeftPulleyLength(10, 0.5));
        addParallel(new RightPulleyLength(10, 0.5));
        addParallel(new MiddlePulleyLength(10, 0.5));


    }
}
