package edu.wpi.first.wpilibj.templates.commands.Shooter;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

public class tensionAdd extends CommandBase{

    public tensionAdd(){
        requires(shoot);
    }
    
    protected void initialize() {
    }

    protected void execute() {
        shoot.addTension();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
