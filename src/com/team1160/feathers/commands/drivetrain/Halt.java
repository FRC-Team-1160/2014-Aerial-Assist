package com.team1160.feathers.commands.drivetrain;

import com.team1160.feathers.commands.CommandBase;

public class Halt extends CommandBase{
	
	public Halt(){
		requires(drivetrain);
	}
	
	public void execute(){
		drivetrain.halt();
	}
	
	public boolean isFinished(){
		return false;
	}
    
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
    
}
