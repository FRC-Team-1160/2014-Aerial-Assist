package edu.wpi.first.wpilibj.templates.commands.Shooter;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

public class tensionLetGo extends CommandBase{
    
    
    public tensionLetGo(){
        requires(shoot);
    }

    protected void initialize() {
    }

    protected void execute() {
        shoot.letGo();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
