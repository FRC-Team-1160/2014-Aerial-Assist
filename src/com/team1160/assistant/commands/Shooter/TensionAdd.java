package com.team1160.assistant.commands.Shooter;

import com.team1160.assistant.commands.CommandBase;

public class TensionAdd extends CommandBase {
	public TensionAdd() {
		requires(shoot);
	}
	protected void initialize() {}
	protected void execute() {
		shoot.addTension();
	}
	protected boolean isFinished() {
		return false;
	}
	protected void end() {}
	protected void interrupted() {}
}
