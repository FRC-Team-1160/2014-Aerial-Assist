package com.team1160.feathers.commands;

import com.team1160.feathers.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

public class CommandBase extends Command {
	protected static Drivetrain dt;
	
	protected void initialize() {
		dt = Drivetrain.getInstance();
	}

	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void end() {
		// TODO Auto-generated method stub
		
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
}
