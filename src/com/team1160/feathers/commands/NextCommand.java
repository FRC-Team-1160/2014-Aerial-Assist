package com.team1160.feathers.commands;

import com.team1160.feathers.SI;

import edu.wpi.first.wpilibj.command.Command;

public class NextCommand extends Command {

	protected void initialize() {
		SI.nextCommand = true;
	}

	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
		// TODO Auto-generated method stub
		
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
}
