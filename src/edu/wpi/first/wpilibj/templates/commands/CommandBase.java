package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.subsystems.*;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    protected static Drivetrain drivetrain;
    protected static Pneumatics airsystem;

    public static void init() {
        
        drivetrain = Drivetrain.getInstance();
        airsystem = Pneumatics.getInstance();
        OI.getInstance();
    }
}