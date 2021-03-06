package com.team1160.assistant.commands;

import com.team1160.assistant.OI;
import com.team1160.assistant.subsystems.*;
import edu.wpi.first.wpilibj.command.Command;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use
 * CommandBase.exampleSubsystem
 *
 * @author Author
 */
public abstract class CommandBase extends Command {

    protected static DrivetrainBase dt;
    protected static Shooter shoot;
    //protected static Vision vision;
    protected static Pickup pickup;
    protected static Pneumatics air;

    public static void init() {
        shoot = Shooter.getInstance();
        //vision = Vision.getInstance();
        pickup = Pickup.getInstance();
        dt = DrivetrainBase.getInstance();
        air = Pneumatics.getInstance();
        OI.getInstance();
    }
}