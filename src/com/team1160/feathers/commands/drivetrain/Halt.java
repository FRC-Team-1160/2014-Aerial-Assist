package com.team1160.feathers.commands.drivetrain;

import com.team1160.feathers.commands.CommandBase;

public class Halt extends CommandBase{
	
	public Halt(){
		requires(dt);
	}
	
	public void execute(){
		dt.halt();
	}
	
	public boolean isFinished(){
		return false;
	}
	
}
