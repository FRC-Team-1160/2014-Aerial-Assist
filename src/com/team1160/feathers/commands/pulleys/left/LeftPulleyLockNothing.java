package com.team1160.feathers.commands.pulleys.left;

import com.team1160.feathers.commands.CommandBase;

public class LeftPulleyLockNothing extends CommandBase{
    
    public LeftPulleyLockNothing(){
        requires(leftLock);
    }

    protected void initialize() {
        
    }

    protected void execute() {
        leftLock.lock(leftLock.getLockState());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
}
