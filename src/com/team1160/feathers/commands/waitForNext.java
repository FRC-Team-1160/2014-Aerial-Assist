package com.team1160.feathers.commands;

import com.team1160.feathers.SI;

import edu.wpi.first.wpilibj.command.Command;

public class waitForNext extends Command{

	public waitForNext(){
		
	}

	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	protected boolean isFinished() {
		return SI.nextCommand;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
