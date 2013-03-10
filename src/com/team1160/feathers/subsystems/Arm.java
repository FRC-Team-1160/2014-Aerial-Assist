package com.team1160.feathers.subsystems;

import com.team1160.feathers.api.DigitalServo;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {

	protected Victor motor;
	protected DigitalServo grip;
	
	private static Arm instance;
	
	public Arm getInstance(){
		if(instance == null){
			instance = new Arm();
		}
		return instance;
	}
	
	private Arm() {
		
	}

	public Arm(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
