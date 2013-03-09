package com.team1160.feathers;

import com.team1160.feathers.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class team1160 extends IterativeRobot{

	public void robotInit(){
		System.out.println("bitch im in the new robot init");
		OI.getInstance();
		Drivetrain.getInstance();
	}
	
	public void teleopPeriodic(){
		Scheduler.getInstance().run();
	}
	
}
