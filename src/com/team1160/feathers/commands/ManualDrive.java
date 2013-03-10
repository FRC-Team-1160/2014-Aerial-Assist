package com.team1160.feathers.commands;


public class ManualDrive extends CommandBase {

	
	public ManualDrive() {
		requires(dt);
	}


	protected void initialize() {
		// TODO Auto-generated method stub

	}

	protected void execute() {
		dt.manualDrive();
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
