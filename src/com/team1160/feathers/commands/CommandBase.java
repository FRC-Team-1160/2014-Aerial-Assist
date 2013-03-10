package com.team1160.feathers.commands;

import com.team1160.feathers.OI;
import com.team1160.feathers.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

public class CommandBase extends Command {
	
	
	protected static Drivetrain dt;
	
	public static void init(){
		dt = Drivetrain.getInstance();
		OI.getInstance();
	}
	
	protected void initialize() {
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
