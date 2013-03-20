package com.team1160.feathers.commands.groups.climbrungs;

import com.team1160.feathers.SI;
import com.team1160.feathers.commands.pulleys.left.LeftPulleyLength;
import com.team1160.feathers.commands.pulleys.left.LeftPulleyLock;
import com.team1160.feathers.commands.pulleys.middle.MiddlePulleyLength;
import com.team1160.feathers.commands.pulleys.right.RightPulleyLength;
import com.team1160.feathers.commands.pulleys.right.RightPulleyLock;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ClimbSecond extends CommandGroup {

    protected SI si;
    protected double angle;

    public ClimbSecond() {

        if (si == null) {
            si = SI.getInstance();
        }
        //set to 45 below frame
        //addParallel(new MiddlePulleyAngleSet(MiddlePulley.meth.calcServoFromAngle(false, Math.toRadians(-45), si.getMidl(), si.getAngleDegrees())));
        //set to 43 inches
        addSequential(new MiddlePulleyLength(43, 0.1));
        //swing to latch rung
        //addSequential(new MiddlePulleyAngleSet(MiddlePulley.meth.calcServoFromAngle(false, Math.toRadians(-60), si.getMidl(), si.getAngleDegrees())));
        //Will middlepulley keep at 30?
        addSequential(new MiddlePulleyLength(30, 0.1));
        //disengage locks
        addSequential(new LeftPulleyLock(false));
        addSequential(new RightPulleyLock(false));

        //get angle of frame
        angle = si.getAngleDegrees();

        //set L R pulleys to 35 inches
        addParallel(new LeftPulleyLength(35, 0.1));
        addParallel(new RightPulleyLength(35, 0.1));
        //set left pulley to 85 - frameangle
        //addParallel(new LeftPulleyAngleSet(LeftPulley.meth.calcServoFromAngle(false, Math.toRadians(85 - angle), si.getLeftl(), angle)));
        //set right pulley to 80(??) - frameangle.. why are these values different..?
        //addParallel(new RightPulleyAngleSet(RightPulley.meth.calcServoFromAngle(false, Math.toRadians(80 - angle), si.getRightl(), angle)));

        /*TO ADD:
         * 
         * Pull up left and right pulleys
         * engage locks
         * etc
         * 
         */
    }
}
