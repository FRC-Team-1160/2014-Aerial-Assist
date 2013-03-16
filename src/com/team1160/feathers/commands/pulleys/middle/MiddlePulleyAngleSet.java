package com.team1160.feathers.commands.pulleys.middle;

import com.team1160.feathers.commands.CommandBase;

public class MiddlePulleyAngleSet extends CommandBase{
    
    protected double goal;
    
    public MiddlePulleyAngleSet(double g){
        this.goal = g;
        requires(middlePulley);
    }
    protected void initialize(){
        middlePulley.setAngle(goal);
    }

    protected void execute() {

    }


    protected boolean isFinished() {
        //change
        return false;
    }
    
    protected void end() {
        
    }

    protected void interrupted() {
        
    }
}