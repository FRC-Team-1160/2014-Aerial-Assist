package edu.wpi.first.wpilibj.templates.commands.Pistons;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

public class retractPiston extends CommandBase{

    
    public retractPiston(){
        requires(airsystem);
    }
    
    protected void initialize() {
        airsystem.retractPiston();
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
