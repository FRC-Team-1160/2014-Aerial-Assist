package com.team1160.feathers.api;

import edu.wpi.first.wpilibj.Servo;

public class DigitalServo extends Servo {

	protected double lastSet;
	public boolean freed;
	
	public DigitalServo(int channel) {
		super(channel);
		freed = false;
		setBounds(184,0,0,0,67);
	}

	public DigitalServo(int slot, int channel) {
		super(slot, channel);
		freed = false;
		setBounds(184,0,0,0,67);
	}
	
	
	public void set(double set){	
		lastSet = set;
		super.set(set);
	}
	
	public void toLastSet(){
		super.set(lastSet);
	}
        
	public void free(){
		freed = true;
		super.free();
	}

}
