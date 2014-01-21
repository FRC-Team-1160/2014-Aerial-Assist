package edu.wpi.first.wpilibj.templates.commands.Shooter;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

public class neutral extends CommandBase{
    
    public neutral(){
        requires(shoot);
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        shoot.neutrals();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }

}
