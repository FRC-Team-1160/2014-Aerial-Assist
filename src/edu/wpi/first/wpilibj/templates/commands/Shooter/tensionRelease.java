package edu.wpi.first.wpilibj.templates.commands.Shooter;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

public class tensionRelease extends CommandBase{
    
    public tensionRelease(){
        requires(shoot);
    }

    protected void initialize() {
    }

    protected void execute() {
        shoot.releaseTension();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
