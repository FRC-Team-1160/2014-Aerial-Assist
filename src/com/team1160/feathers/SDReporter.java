package com.team1160.feathers;

import com.team1160.feathers.subsystems.pulleys.LeftPulley;
import com.team1160.feathers.subsystems.pulleys.RightPulley;
import com.team1160.feathers.subsystems.pulleys.MiddlePulley;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SDReporter {
	protected static LeftPulley leftPulley;
	protected static RightPulley rightPulley;
	protected static MiddlePulley middlePulley;
	
	public static void initReporter(){
		leftPulley = LeftPulley.getInstance();
		rightPulley = RightPulley.getInstance();
		middlePulley = MiddlePulley.getInstance();
	}
	
	public static void report(){
		SmartDashboard.putNumber("Left Volts:", leftPulley.getRawDistance());
		SmartDashboard.putNumber("Right Volts:" , rightPulley.getRawDistance());
		SmartDashboard.putNumber("Middle Volts:", middlePulley.getRawDistance());
	}
}
