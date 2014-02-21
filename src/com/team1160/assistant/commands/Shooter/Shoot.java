package com.team1160.assistant.commands.Shooter;

import com.team1160.assistant.commands.CommandBase;

public class Shoot extends CommandBase{
    
    public Shoot(){
        requires(shoot);
    }
    
    protected void initialize() {
        shoot.timer.start();
        shoot.timer.reset();
    }

    protected void execute() {
        shoot.shootIt();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        shoot.nothing();
    }

    protected void interrupted() {
    }

}
