package com.team1160.feathers;

import com.team1160.feathers.subsystems.pulleys.LeftPulley;
import com.team1160.feathers.subsystems.pulleys.MiddlePulley;
import com.team1160.feathers.subsystems.pulleys.RightPulley;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SDReporter {
	protected static LeftPulley leftPulley;
	protected static RightPulley rightPulley;
	protected static MiddlePulley middlePulley;
	protected static SI si;
	public static void initReporter(){
		leftPulley = LeftPulley.getInstance();
		rightPulley = RightPulley.getInstance();
		middlePulley = MiddlePulley.getInstance();
		si = SI.getInstance();
	}
	
	public static void report(){
		leftPulley.report();
		rightPulley.report();
		middlePulley.report();
		SmartDashboard.putNumber("Frame angle: ", si.getAngleDegrees() );
	}
}
