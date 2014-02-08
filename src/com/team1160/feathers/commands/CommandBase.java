package com.team1160.feathers.commands;

import com.team1160.feathers.OI;
import com.team1160.feathers.subsystems.Arm;
import com.team1160.feathers.subsystems.Drivetrain;
import com.team1160.feathers.subsystems.pulleys.LeftLock;
import com.team1160.feathers.subsystems.pulleys.LeftPulley;
import com.team1160.feathers.subsystems.pulleys.MiddlePulley;
import com.team1160.feathers.subsystems.pulleys.RightLock;
import com.team1160.feathers.subsystems.pulleys.RightPulley;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {

	protected static LeftLock leftLock;
	protected static RightLock rightLock;
	protected static Drivetrain drivetrain;
	protected static LeftPulley leftPulley;
	protected static RightPulley rightPulley;
	protected static MiddlePulley middlePulley;
	protected static Arm arm;
	
	public static void init(){
		leftLock = LeftLock.getInstance();
		rightLock = RightLock.getInstance();
		drivetrain = Drivetrain.getInstance();
		leftPulley = LeftPulley.getInstance();
		rightPulley = RightPulley.getInstance();
		middlePulley = MiddlePulley.getInstance();
		CommandGroupBase.initCommandGroupBase();
		OI.getInstance();
	}
}