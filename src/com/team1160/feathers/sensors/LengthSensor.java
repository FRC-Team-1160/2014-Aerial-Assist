package com.team1160.feathers.sensors;

import com.team1160.feathers.api.Quad;

import edu.wpi.first.wpilibj.AnalogChannel;

public class LengthSensor {
	protected AnalogChannel pot;
	protected Quad quad;
	
	
	public LengthSensor(AnalogChannel pot, double a, double b, double c){
		this.pot = pot;
		this.quad = new Quad(a,b,c);
	}
	
	public LengthSensor(int potChannel, double a, double b, double c){
		this.pot = new AnalogChannel(potChannel);
		this.quad = new Quad(a,b,c);
	}
	
	public double getLength(){
		return quad.result(pot.getVoltage());
	}
	
}
