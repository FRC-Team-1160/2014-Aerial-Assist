package com.team1160.assistant.commands.pickup;

import com.team1160.assistant.commands.CommandBase;

public class RaiseArm extends CommandBase {

    public RaiseArm() {
        requires(pickup);
    }

    protected void initialize() {
        
    }

    protected void execute() {
        pickup.raiseArm();
    }

    protected boolean isFinished() {
        if (pickup.getLimitHigh()){
            System.out.println("Pick up is high");
            return true;
        }else{
            return false;
        }
    }

    protected void end() {
        pickup.stall();
    }

    protected void interrupted() {
    }
}
