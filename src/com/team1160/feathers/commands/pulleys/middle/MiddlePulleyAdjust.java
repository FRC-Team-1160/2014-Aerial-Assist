package com.team1160.feathers.commands.pulleys.middle;

import com.team1160.feathers.commands.CommandBase;

public class MiddlePulleyAdjust extends CommandBase {

    public MiddlePulleyAdjust(){
        requires(middlePulley);
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        middlePulley.joyAdjust();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
