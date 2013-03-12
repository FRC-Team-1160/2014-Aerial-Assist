package com.team1160.feathers;

import com.team1160.feathers.commands.CommandBase;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class team1160 extends IterativeRobot{

	public void robotInit(){
		System.out.println("yup still in the restroom");
		CommandBase.init();		
	}
	
	public void teleopPeriodic(){
		Scheduler.getInstance().run();
	}
	
}
