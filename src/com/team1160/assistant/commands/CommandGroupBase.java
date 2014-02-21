package com.team1160.assistant.commands;

import com.team1160.assistant.subsystems.DrivetrainBase;
import com.team1160.assistant.subsystems.Pickup;
import com.team1160.assistant.subsystems.Shooter;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class CommandGroupBase extends CommandGroup {

    protected static DrivetrainBase dt;
    protected static Shooter shoot;
    protected static Pickup pickup;

    public static void initCommandGroupBase() {

        shoot = Shooter.getInstance();
        pickup = Pickup.getInstance();
        dt = DrivetrainBase.getInstance();

    }
}
