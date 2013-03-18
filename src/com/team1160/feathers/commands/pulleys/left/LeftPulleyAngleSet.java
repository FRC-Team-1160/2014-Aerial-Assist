package com.team1160.feathers.commands.pulleys.left;

import com.team1160.feathers.SI;
import com.team1160.feathers.commands.CommandBase;

public class LeftPulleyAngleSet extends CommandBase{
    
    protected double goal;
    protected SI si;
    
    public LeftPulleyAngleSet(double g){
        this.goal = g;
        requires(leftPulley); 
    }

    
    protected void initialize() {
        leftPulley.setAngle(goal);
    }


    protected void execute() {

    }


    protected boolean isFinished() {
        return true;
    }
    
    protected void end() {
        
    }

    protected void interrupted() {
        
    }
}
