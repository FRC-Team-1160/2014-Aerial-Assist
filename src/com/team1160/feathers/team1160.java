package com.team1160.feathers;

import com.team1160.feathers.commands.CommandBase;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class team1160 extends IterativeRobot{

	String version;
	
	public void robotInit(){
		version = "1.0";
		System.out.println("In Robot Init, good luck. Version: " + version );
		CommandBase.init();		
	}	
	
	public void teleopPeriodic(){
		Scheduler.getInstance().run();
	}
	
}
