package com.team1160.feathers;

import java.io.DataOutputStream;
import java.io.IOException;

import javax.microedition.io.Connector;

import com.sun.squawk.microedition.io.FileConnection;
import com.team1160.feathers.subsystems.Drivetrain;
import com.team1160.feathers.subsystems.pulleys.LeftLock;
import com.team1160.feathers.subsystems.pulleys.LeftPulley;
import com.team1160.feathers.subsystems.pulleys.MiddlePulley;
import com.team1160.feathers.subsystems.pulleys.RightLock;
import com.team1160.feathers.subsystems.pulleys.RightPulley;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Reporter {
	protected static LeftPulley leftPulley;
	protected static RightPulley rightPulley;
	protected static MiddlePulley middlePulley;
	protected static LeftLock leftLock;
	protected static RightLock rightLock;
	protected static Drivetrain drivetrain;
	protected static OI oi;
	protected static SI si;
	protected static String epoch;
	static DataOutputStream theFile;
	static FileConnection fc;
	
	public static void initReporter(){
		leftPulley = LeftPulley.getInstance();
		rightPulley = RightPulley.getInstance();
		middlePulley = MiddlePulley.getInstance();
		leftLock = LeftLock.getInstance();
		rightLock = RightLock.getInstance();
		drivetrain = Drivetrain.getInstance();
		oi = OI.getInstance();
		si = SI.getInstance();
		epoch = String.valueOf(System.currentTimeMillis());

	}
	
	public static void report(){
		leftPulley.report();
		rightPulley.report();
		middlePulley.report();
		SmartDashboard.putNumber("Frame angle: ", si.getAngleDegrees() );
	}
	
	public static String sReport(){
		StringBuffer output = new StringBuffer();
		output.append("----Right:\n");
		output.append( "--------Lock: " + rightLock.getLockState() + " (" + rightLock.getServoVal()+ ")\n");
		output.append( "--------Pulley: " + rightPulley.getLength() + " (" + rightPulley.getRaw()+")\n");
		output.append( "--------Servo: " + rightPulley.lastSet() + "\n");
		output.append( "----Left:\n");
		output.append( "--------Lock: " + leftLock.getLockState() + " (" + leftLock.getServoVal()+ ")\n");
		output.append( "--------Pulley: " + leftPulley.getLength() + " (" + leftPulley.getRaw()+")\n");
		output.append( "--------Servo: " + leftPulley.lastSet() + "\n");
		output.append( "----Middle:\n");
		output.append( "--------Pulley: " + middlePulley.getLength() + " (" + middlePulley.getRaw()+")\n");
		output.append( "--------Servo: " + middlePulley.lastSet() + "\n");
		output.append( "----Drivetrain:\n ");
		output.append( "--------Left Jag:"+ drivetrain.getLeft() + "\n");
		output.append( "--------Right Jag:"+ drivetrain.getRight() + "\n");
		output.append( "----Input State:\n");
		output.append( "--------Drive Stick:\n");
		output.append( "------------X: " + oi.getDriveStick().getX() + "\n");
		output.append( "------------Y: " + oi.getDriveStick().getY() + "\n");
		output.append( "------------Z: " + oi.getDriveStick().getZ() + "\n");
		output.append( "--------Left Stick:\n");
		output.append( "------------X: " + oi.getLeftStick().getX() + "\n");
		output.append( "------------Y: " + oi.getLeftStick().getY() + "\n");
		output.append( "------------Z: " + oi.getLeftStick().getZ() + "\n");
		output.append( "--------Right Stick:\n");
		output.append( "------------X: " + oi.getRightStick().getX() + "\n");
		output.append( "------------Y: " + oi.getRightStick().getY() + "\n");
		output.append( "------------Z: " + oi.getRightStick().getZ() + "\n");
		output.append( "--------Gyro: " + si.getAngle() + " Radians\n");
		return output.toString();
	}
	
	public static void record(String s){
		try {
			fc = (FileConnection)Connector.open("file:///" + epoch + ".txt", Connector.WRITE);
			fc.create();
			theFile = fc.openDataOutputStream();
			theFile.writeChars(s);
		}
		catch (Exception e) {
			}
		finally{
				try {
					theFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
	
}
