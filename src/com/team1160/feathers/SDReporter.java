package com.team1160.feathers;

import com.team1160.feathers.subsystems.pulleys.LeftPulley;
import com.team1160.feathers.subsystems.pulleys.MiddlePulley;
import com.team1160.feathers.subsystems.pulleys.RightPulley;

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
		leftPulley.report();
		rightPulley.report();
		middlePulley.report();
	}
}
