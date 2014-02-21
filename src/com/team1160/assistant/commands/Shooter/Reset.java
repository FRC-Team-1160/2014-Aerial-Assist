package com.team1160.assistant.commands.Shooter;

import com.team1160.assistant.commands.CommandBase;

public class Reset extends CommandBase{
    
    public Reset(){
        requires(shoot);
    }

    protected void initialize() {
        shoot.timer.start();
        shoot.timer.reset();
    }

    protected void execute() {
        shoot.resetIt();
    }

    protected boolean isFinished() {
        //return shoot.getSwitch();
        return false;
    }

    protected void end() {
        shoot.nothing();
    }

    protected void interrupted() {
    }

}
