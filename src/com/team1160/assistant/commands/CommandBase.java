package com.team1160.assistant.commands;

import com.team1160.assistant.OI;
import com.team1160.assistant.subsystems.*;
import edu.wpi.first.wpilibj.command.Command;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    protected static Drivetrain drivetrain;
    protected static Pneumatics airsystem;
    protected static Shooter shoot;

    public static void init() {
        
        drivetrain = Drivetrain.getInstance();
        airsystem = Pneumatics.getInstance();
        shoot = Shooter.getInstance();
        OI.getInstance();
    }
}