package com.team1160.feathers.commands;

import com.team1160.feathers.SI;

public class MiddleFinish extends CommandBase{
    
    protected SI si;
    
    public MiddleFinish(){
        if(si == null){
            si = SI.getInstance();
        }
    }

    protected void initialize() {
        si.middleFinish = true;
    }

    protected void execute() {
        
    }


    protected boolean isFinished() {
        return true;
    }


    protected void end() {
        if(!si.middleFinish){
            si.middleFinish = true;
        }
    }


    protected void interrupted() {
        if(!si.middleFinish)
            si.middleFinish = true;
    }

}
