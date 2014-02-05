package com.team1160.assistant.commands.Shooter;

import com.team1160.assistant.commands.CommandBase;

public class TensionLetGo extends CommandBase {
	public TensionLetGo() {
		requires(shoot);
	}
	protected void initialize() {}
	protected void execute() {
		shoot.letGo();
	}
	protected boolean isFinished() {
		return false;
	}
	protected void end() {}
	protected void interrupted() {}
}
