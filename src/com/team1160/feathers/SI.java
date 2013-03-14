package com.team1160.feathers;

import com.team1160.feathers.api.Constants;
import com.team1160.feathers.api.Quad;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Gyro;

public class SI {
	
	protected AnalogChannel top;
	protected AnalogChannel left;
	protected AnalogChannel right;
	
	protected Quad qTop;
	protected Quad qLeft;
	protected Quad qRight;
	
	protected Gyro gyro;
	
	protected static SI instance;
	
	public static SI getInstance(){
		if(instance == null){
			instance = new SI();
		}
		return instance;
	}
	
	protected SI(){
		top = new AnalogChannel(Constants.MID_POT);
		left = new AnalogChannel(Constants.LEFT_POT);
		right = new AnalogChannel(Constants.RIGHT_POT);
	
		qTop = new Quad(1,1,1);
		qLeft = new Quad(1,1,1);
		qRight = new Quad(1,1,1);
		
		gyro = new Gyro(Constants.GYRO);
	}
	
	public double getTopLength(){
		return qTop.result(top.getVoltage());
	}
	
	public double getLeftLength(){
		return qLeft.result(left.getVoltage());
	}
	
	public double getRightLength(){
		return qRight.result(right.getVoltage());
	}
	
	public double getAngle(){
		return gyro.getAngle();
	}
	
	public void reset(){
		gyro.reset();
	}
	
	
}
