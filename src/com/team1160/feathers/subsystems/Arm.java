package com.team1160.feathers.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {

	private Arm instance;
	
	public Arm getInstance(){
		if(instance == null){
			instance = new Arm();
		}
		return instance;
	}
	
	public Arm() {
		// TODO Auto-generated constructor stub
	}

	public Arm(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
