package com.team1160.assistant.commands.pickup;

import com.team1160.assistant.commands.CommandBase;

public class LowerArm extends CommandBase {

    public LowerArm() {
        requires(pickup);
    }

    protected void initialize() {
    }

    protected void execute() {
        pickup.lowerArm();

    }

    protected boolean isFinished() {
        if (pickup.getLimitLower()) {
            System.out.println("Pick up is low");
            return true;
        } else {
            return false;
        }
    }

    protected void end() {
        pickup.stall();
    }

    protected void interrupted() {
    }
}
