package com.team1160.feathers.commands;

import edu.wpi.first.wpilibj.command.WaitForChildren;

public class TwoStep extends CommandGroupBase {

    public TwoStep() {
        addParallel(new DefensiveClimb(rightPulley, rightLock, 11, true, .8));
        addParallel(new DefensiveClimb(leftPulley, leftLock, 11, true, .66));
        addSequential(new WaitForChildren());
        addParallel(new DefensiveClimb(rightPulley, rightLock, 6, true, .26));
        addParallel(new DefensiveClimb(leftPulley, leftLock, 6, true, .22));


    }
}