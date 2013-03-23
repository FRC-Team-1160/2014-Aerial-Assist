package com.team1160.feathers.commands.groups.climbrungs;

import com.team1160.feathers.Reporter;
import com.team1160.feathers.SI;
import com.team1160.feathers.commands.CommandGroupBase;
import com.team1160.feathers.commands.DefensiveClimb;

/*
 * Pretty much what it sounds like
 * this command group is what has
 * us climb the first rung, all in
 * all this step is pretty easy
 */

public class ClimbFirst extends CommandGroupBase {

	protected String report;
	
    public void initialize(){
    	SI.reset();  // Right before we climb reset the gyro to "true" zero for less dangerous climbs
    	report = "Climb First:\n";
    	report += "--Start:\n";
    	report += Reporter.sReport();
    }
    
    public void end(){
    	report += "--End:\n";
    	report += Reporter.sReport();
    	Reporter.record(report);
    	}

    public void interupt(){
    	this.end();
    }
	
	public ClimbFirst() {
        /* 
         * Defensive climb denotes a climb mode where the pawls are locked
         * and the servos are actively protecting them selves^ it takes 5
         * params: the pulley, the lock, the target length, if we are on 
         * floor(changes servo equations), and velocity.
         * ^ - More on this can be found in the pulley class
         */
		addParallel(new DefensiveClimb(rightPulley, rightLock, 6, true, .75));
        addParallel(new DefensiveClimb(leftPulley, leftLock, 6.5, true, .66));    	
    }
}
