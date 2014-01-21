package edu.wpi.first.wpilibj.templates.commands;

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
