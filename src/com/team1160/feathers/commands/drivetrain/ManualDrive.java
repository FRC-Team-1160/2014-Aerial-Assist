package com.team1160.feathers.commands.drivetrain;

import com.team1160.feathers.commands.CommandBase;


public class ManualDrive extends CommandBase {

	
	public ManualDrive() {
		requires(drivetrain);
	}


	protected void initialize() {
		// TODO Auto-generated method stub

	}

	protected void execute() {
		drivetrain.manualDrive();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		// TODO Auto-generated method stub

	}

	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
