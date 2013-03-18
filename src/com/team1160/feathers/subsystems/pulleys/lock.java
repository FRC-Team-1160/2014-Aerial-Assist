package com.team1160.feathers.subsystems.pulleys;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class Lock extends Subsystem {

	protected boolean lock;
	protected Servo servo;
	protected double locked, unlocked;

	public void lock(boolean lock){
		this.lock = lock;
		if(lock){
			servo.set(locked);
		}else{
			servo.set(unlocked);
		}
	}
	
	public boolean getLockState(){
		return lock;
	}
	
}
