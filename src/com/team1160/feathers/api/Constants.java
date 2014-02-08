package com.team1160.feathers.api;

public interface Constants {

	//Output
	int DT_LEFT_JAG_CHAN = 2;
	int DT_LEFT_JAG_CAR = 2;
	int DT_RIGHT_JAG_CHAN = 3;
	int DT_RIGHT_JAG_CAR = 1;

	//Pulley System
	// Top Pulley
		int P_TOP_JAG_CHAN = 1;
		int P_TOP_JAG_CAR = 1;
		int P_TOP_SERVO_CHAN = 5;
		int P_TOP_SERVO_CAR = 1;
		double P_TOP_LOCK_LOCKED = .9;
		double P_TOP_LOCK_OPEN = .1;
		double P_TOP_HOME = .30;
		double P_TOP_MAX = .9;
		double P_TOP_MIN = .2;
	// Right Pulley
		int P_RIGHT_JAG_CHAN = 2;
		int P_RIGHT_JAG_CAR = 1;
		int P_RIGHT_SERVO_CHAN = 6;
		int P_RIGHT_SERVO_CAR = 1;
		int P_RIGHT_LOCK_CHAN = 4;
		int P_RIGHT_LOCK_CAR = 1;
		double P_RIGHT_LOCK_LOCKED = .48;
		double P_RIGHT_LOCK_OPEN = .93;
		double P_RIGHT_HOME = .63;
		double P_RIGHT_MAX = 1;
		double P_RIGHT_MIN = .63;
	// Left Pulley
		int P_LEFT_JAG_CHAN = 1;
		int P_LEFT_JAG_CAR = 2;
		int P_LEFT_SERVO_CHAN = 4;
		int P_LEFT_SERVO_CAR = 2;
		int P_LEFT_LOCK_CHAN = 5;
		int P_LEFT_LOCK_CAR = 2;
		double P_LEFT_LOCK_LOCKED = .68;
		double P_LEFT_LOCK_OPEN = .3;  // Value subject to change
		double P_LEFT_HOME = .62;
		double P_LEFT_MAX =.62;
		double P_LEFT_MIN = .2;
// Arm system
	// Arm
		int A_MOTOR_CHAN = 8;   
		int A_MOTOR_CAR =2;                       
	// Gripper
		int G_SERVO_CHAN = 9;
		int G_SERVO_CAR = 1;
		double G_SERVO_GRIP = .9;	
		double G_SERVO_OPEN = .1;


	
	//Human Input
	int DRIVESTICK = 1;
	int LeftStick = 2;
	int RightStick = 3;
	//Robot Input
	int GYRO = 1;
	int LEFT_POT = 3;
	int RIGHT_POT = 2;
	int MID_POT = 4;
	
	//Values
	double ClimbAssist = .3;
	
}
