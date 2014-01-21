package edu.wpi.first.wpilibj.templates.commands;

public class extendPiston extends CommandBase{
    
    public extendPiston(){
        requires(airsystem);
    }
    
    protected void initialize() {
        airsystem.extendPiston();
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
