package com.team1160.feathers.commands.pulleys.right;

import com.team1160.feathers.commands.CommandBase;

public class RightPulleyLockNothing extends CommandBase{
    
    
    
    public RightPulleyLockNothing(){
        requires(rightLock);
    }

    protected void initialize() {
        
    }

    protected void execute() {
        rightLock.lock(rightLock.getLockState());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {

    }

    protected void interrupted() {

    }
    
}
