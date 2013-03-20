package com.team1160.feathers.commands.pulleys.left;

import com.team1160.feathers.commands.CommandBase;

public class LeftPulleyLock extends CommandBase {

    protected boolean b;
    protected boolean fin;

    public LeftPulleyLock(boolean b) {
        requires(leftLock);
        this.b = b;
        fin = false;
    }

    protected void execute() {
        fin = true;
    }

    protected boolean isFinished() {
        return fin;
    }

    protected void end() {
        leftLock.lock(b);
    }

    protected void initialize() {
        // TODO Auto-generated method stub
    }

    protected void interrupted() {
        // TODO Auto-generated method stub
    }
}
