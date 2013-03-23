package com.team1160.feathers;

import com.team1160.feathers.api.DigitalServo;
import com.team1160.feathers.commands.CommandBase;
import com.team1160.feathers.subsystems.pulleys.LeftLock;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Scheduler;

public class team1160 extends IterativeRobot{

	LeftLock ll;
	String version;
	DigitalServo ds;
	Joystick js;
	public void robotInit(){
		version = "X.1.2.2";
		System.out.println("Ins Dev Robot Init, good deploy, if you see this and are at comp STOP this is an experimental build. Version: " + version );
		CommandBase.init();		
		Reporter.initReporter();
		
	}	
	
	public void teleopPeriodic(){
		Scheduler.getInstance().run();
		Reporter.report();	
	}
	
}
