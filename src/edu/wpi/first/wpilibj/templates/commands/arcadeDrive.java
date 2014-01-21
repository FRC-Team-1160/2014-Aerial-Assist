package edu.wpi.first.wpilibj.templates.commands;

public class arcadeDrive extends CommandBase{
    
    public arcadeDrive(){
        requires(drivetrain);
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        drivetrain.arcadeDrive();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
        
    }

}