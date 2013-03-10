package com.team1160.feathers.commands;


public class AssistClimb extends CommandBase {

	public AssistClimb() {
		requires(dt);
	}

	protected void initialize() {
		// TODO Auto-generated method stub
	}
	protected void execute() {
		dt.assistClimb();
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
