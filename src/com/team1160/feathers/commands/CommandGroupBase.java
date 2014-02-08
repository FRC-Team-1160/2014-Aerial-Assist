package com.team1160.feathers.commands;

import com.team1160.feathers.subsystems.pulleys.LeftLock;
import com.team1160.feathers.subsystems.pulleys.LeftPulley;
import com.team1160.feathers.subsystems.pulleys.MiddlePulley;
import com.team1160.feathers.subsystems.pulleys.RightLock;
import com.team1160.feathers.subsystems.pulleys.RightPulley;

import edu.wpi.first.wpilibj.command.CommandGroup;

public abstract class CommandGroupBase extends CommandGroup{
	
	protected static LeftPulley leftPulley;
	protected static RightPulley rightPulley;
	protected static MiddlePulley middlePulley;
	protected static LeftLock leftLock;
	protected static RightLock rightLock;
	
	public static void initCommandGroupBase(){
		leftPulley = LeftPulley.getInstance();
		rightPulley = RightPulley.getInstance();
		middlePulley = MiddlePulley.getInstance();
		leftLock = LeftLock.getInstance();
		rightLock = RightLock.getInstance();
	}
	
}
