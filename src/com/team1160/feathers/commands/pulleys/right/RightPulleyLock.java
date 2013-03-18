package com.team1160.feathers.commands.pulleys.right;

import com.team1160.feathers.commands.CommandBase;

public class RightPulleyLock extends CommandBase {

    boolean b;
    boolean fin;

    public RightPulleyLock(boolean b) {
        requires(rightLock);
        this.b = b;
        fin = false;
    }

    protected void execute() {
        rightLock.lock(b);
        fin = true;
    }

    protected boolean isFinished() {
        return fin;
    }

    protected void end() {
        // TODO Auto-generated method stub
    }

    protected void initialize() {
        // TODO Auto-generated method stub
    }

    protected void interrupted() {
        // TODO Auto-generated method stub
    }
}
