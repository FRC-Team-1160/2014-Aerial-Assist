package com.team1160.feathers.commands.pulley;

import com.team1160.feathers.commands.CommandBase;
import com.team1160.feathers.subsystems.pulleys.Pulley;

public class Nothing extends CommandBase{
    
    Pulley pulley;
    
    public Nothing(Pulley pulley){
        
        requires(pulley);
        this.pulley = pulley;
    }

    protected void initialize() {
        
    }

    protected void execute() {
        pulley.setVelocity(0);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
    
    
}
