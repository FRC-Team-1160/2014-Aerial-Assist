package com.team1160.feathers;

import com.team1160.feathers.commands.CommandBase;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class team1160 extends IterativeRobot{

	String version;
	
	public void robotInit(){
		version = "X.1";
		System.out.println("In Dev Robot Init, if you see this and are at comp STOP this is an experimental build. Version: " + version );
		CommandBase.init();		
	}	
	
	public void teleopPeriodic(){
		Scheduler.getInstance().run();
	}
	
}
