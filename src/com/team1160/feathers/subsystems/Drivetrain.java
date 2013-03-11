package com.team1160.feathers.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.team1160.feathers.OI;
import com.team1160.feathers.api.Constants;
import com.team1160.feathers.commands.drivetrain.ManualDrive;

public class Drivetrain extends Subsystem {

	protected Jaguar right, left;
	protected Joystick drive;
	
	private static Drivetrain instance = null;
	
	public static Drivetrain getInstance(){
		if(instance == null){
			instance = new Drivetrain();
		}
		return instance;
	}
	
	
	private Drivetrain() {
		right = new Jaguar(Constants.DT_RIGHT_JAG_CAR, Constants.DT_RIGHT_JAG_CHAN);
		left = new Jaguar(Constants.DT_LEFT_JAG_CAR, Constants.DT_LEFT_JAG_CHAN);
	}

	protected void initDefaultCommand() {
		this.setDefaultCommand(new ManualDrive());
	}

	public void manualDrive(){
		if(drive == null){
			drive = OI.getInstance().getDriveStick();
		}
		left.set(drive.getX()-drive.getY());
		right.set(drive.getX()+drive.getY());
	}
	
	public void assistClimb(){
		left.set(Constants.ClimbAssist);
		right.set(-Constants.ClimbAssist);
	}
	
	public void halt(){
		left.set(0);
		right.set(0);
	}
	
	public void setRight(double set){
		right.set(set);
	}
	
	public void setLeft(double set){
		left.set(set);
	}

}
