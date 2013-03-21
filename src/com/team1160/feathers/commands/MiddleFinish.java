package com.team1160.feathers.commands;

import com.team1160.feathers.SI;

public class MiddleFinish extends CommandBase{
    
    Boolean b;
    public MiddleFinish(boolean b){
    	this.b = b;
    }

    protected void initialize() {
        SI.middleFinish = b;
    }

    protected void execute() {
        
    }


    protected boolean isFinished() {
        return true;
    }


    protected void end() {
        if(!SI.middleFinish){
            SI.middleFinish = b;
        }
    }


    protected void interrupted() {
    	this.end();
    }

}
