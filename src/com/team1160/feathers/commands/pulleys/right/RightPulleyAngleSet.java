package com.team1160.feathers.commands.pulleys.right;

import com.team1160.feathers.commands.CommandBase;

public class RightPulleyAngleSet extends CommandBase{
    
    protected double goal;
    
    public RightPulleyAngleSet(double g){
        this.goal = g;
        requires(rightPulley);
    }
    
    protected void initialize(){
        rightPulley.setAngle(goal);
    }

    protected void execute() {

    }


    protected boolean isFinished() {
        //change
        return true;
    }
    
    protected void end() {
        
    }

    protected void interrupted() {
        
    }
}
