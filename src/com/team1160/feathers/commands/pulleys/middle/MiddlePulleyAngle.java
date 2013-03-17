package com.team1160.feathers.commands.pulleys.middle;

import com.team1160.feathers.SI;
import com.team1160.feathers.api.FrameMath;
import com.team1160.feathers.commands.CommandBase;

public class MiddlePulleyAngle extends CommandBase{
    
    FrameMath meth;
    SI si;
    
    public MiddlePulleyAngle(){
        if (si == null){
            si = SI.getInstance();
        }
        requires(middlePulley);
    }
    
    protected void execute(){
        middlePulley.setAngle(meth.calcServoFromAngle(true, 45, 10, si.getAngle()));
    }
    
    protected boolean isFinished(){
        return false;
    }
    protected void end() {
		// TODO Auto-generated method stub
		
	}

	
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
    
    
}
