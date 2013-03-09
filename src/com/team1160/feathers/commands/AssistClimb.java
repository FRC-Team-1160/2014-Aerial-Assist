package com.team1160.feathers.commands;

import com.team1160.feathers.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

public class AssistClimb extends Command {

	Drivetrain dt;
	
	public AssistClimb() {
		dt = Drivetrain.getInstance();
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
