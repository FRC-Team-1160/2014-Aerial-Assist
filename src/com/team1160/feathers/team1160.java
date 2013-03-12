package com.team1160.feathers;

import com.team1160.feathers.api.Constants;
import com.team1160.feathers.api.DigitalServo;
import com.team1160.feathers.commands.CommandBase;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class team1160 extends IterativeRobot{

	String version;
	
//	DigitalServo test;
	
	public void robotInit(){
//		System.out.println("fucking jag stop not doing that");
//		test = new DigitalServo(Constants.P_LEFT_LOCK_CAR, Constants.P_LEFT_LOCK_CHAN);
		version = "1.0";
		System.out.println("In Robot Init, good luck. Version: " + version );
		CommandBase.init();		
	}	
	
	public void teleopPeriodic(){
		Scheduler.getInstance().run();
	}
	
}
