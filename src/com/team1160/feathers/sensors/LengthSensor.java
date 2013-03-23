package com.team1160.feathers.sensors;

import com.team1160.feathers.api.Quad;

import edu.wpi.first.wpilibj.AnalogChannel;
/*
 * The length of the tapes is read using
 * a pot with a function of voltage to
 * length, this class makes it easier to 
 * interface with.
 */

public class LengthSensor {
	protected AnalogChannel pot;    
	protected Quad quad;   //A quadratic equation 
	
	
	public LengthSensor(AnalogChannel pot, double a, double b, double c){
		this.pot = pot;
		this.quad = new Quad(a,b,c);
	}
	
	public LengthSensor(AnalogChannel pot, Quad quad){
		this.pot = pot;
		this.quad = quad;
	}
	
	public LengthSensor(int potChannel, double a, double b, double c){
		this.pot = new AnalogChannel(potChannel);
		this.quad = new Quad(a,b,c);
	}
	
	public double getLength(){
		return quad.result(pot.getVoltage());
	}
	
	public double getRaw(){
		return pot.getVoltage();
	}
}
