package com.team1160.feathers.subsystems;

import com.team1160.feathers.OI;
import com.team1160.feathers.api.Constants;
import com.team1160.feathers.api.DigitalServo;
import com.team1160.feathers.api.Quad;
import com.team1160.feathers.commands.pulleys.left.LeftPulleyAngle;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LeftPulley extends Subsystem{

	protected Joystick stick;
	
	protected DigitalServo angle;
	protected Jaguar am;
	
	protected Quad q;
	
	protected AnalogChannel pot;
	protected double lastSet;
	
	protected final double tapeLenMax = 42;
    protected final double tapeLenMin = .5;
    
    protected final double angleMax = 1;
    protected final double angleMin = 0;
    
    
    private final double pulleyErrorMax = 1;
    private final double pulleyErrorMin = .1;
    
    protected final int direction = 1;
    
	protected static LeftPulley instance;
	
	public static LeftPulley getInstance(){
		if(instance == null){
			instance = new LeftPulley();
		}
		return instance;
	}
	
	protected LeftPulley(){
		angle = new DigitalServo(Constants.P_LEFT_SERVO_CAR, Constants.P_LEFT_SERVO_CHAN);
		am = new Jaguar(Constants.P_LEFT_JAG_CAR, Constants.P_LEFT_JAG_CHAN);
		q = new Quad(-.6296,-12.2,74.12);
		pot = new AnalogChannel(Constants.LEFT_POT);
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new LeftPulleyAngle());
	}
	
	/* 
	 * Set angle and set velocity are our final output destitation 
	 * for every command, this allows us to do stuff like final range
	 * checks with out having to repeat our selfs
	 */
	
	public void setAngle(double set){
		set = Math.min(Math.max(set, angleMin), angleMax);  //Fun little line to figure out if set is in bounds and to fix it if not
		this.angle.set(set);
		this.lastSet = set;
	}
	
	public void setVelocity(double set){
		boolean locked = false;     //TODO get the lock condition in here somehow... either by intergrating the lock and pulley systems or other bad assery
		if((getTapeLength() >= tapeLenMax || locked ) && set > 0){
			this.am.set(0);
		}else if(getTapeLength() <= tapeLenMin && set < 0){
			this.am.set(0);
		}else{
			this.am.set(set*direction);
		}
	}
	
	public void setDeltaAngle(double delta){
		setAngle(lastSet+delta);
	}
	
	public double getTapeLength(){
		return q.result(pot.getVoltage());
	}
	
	public void setTapeLength(double goalLength, double error){
		error = Math.max(Math.min(error, pulleyErrorMax), pulleyErrorMin);
		//I think this has to be two conditions... one for forward one for back
		//Admitdly I didnt know what myoung did in some of his...
		//TODO ask myoung about that
		if((goalLength - getTapeLength()) > error){
			setVelocity(.5);
		}else if((getTapeLength() - goalLength) > error){
			setVelocity(-.5);
		}else{
			setVelocity(0);
		}
	}
	
	public void joyAngle(){
		if(stick == null){
			stick = OI.getInstance().getLeftStick();
		}
		setAngle((stick.getY()+1)/2);
	}
	
	// Used for fine tuning the rod angle
	public void joyAdjust(){
		if(stick == null){
			stick = OI.getInstance().getLeftStick();
		}
		setDeltaAngle(stick.getZ()/4);
		lastSet = lastSet -(stick.getZ()/4); //This stops the servo from moving for ever by reseting last to its previous value
	}
	
	public void joyVelocity(){
		if(stick == null){
			stick = OI.getInstance().getLeftStick();
		}
		setVelocity(-stick.getY());
	}
}
