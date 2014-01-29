package com.team1160.assistant.subsystems;

import com.team1160.assistant.RobotMap;
import com.team1160.assistant.commands.Pistons.startCompressor;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem implements RobotMap{
	protected Compressor compress;
	protected Solenoid solenOne;
	protected Solenoid solenTwo;
	protected static Pneumatics instance;
	public static Pneumatics getInstance() {
		if (instance == null) {
			instance = new Pneumatics();
		}
		return instance;
	}
	private Pneumatics() {
		compress = new Compressor(COMPRESSOR_SWITCH_CHAN,
				COMPRESSOR_SWITCH_CHAN);
		solenOne = new Solenoid(SOLENOID_ONE);
		solenTwo = new Solenoid(SOLENOID_TWO);
	}
	protected void initDefaultCommand() {
		this.setDefaultCommand(new startCompressor());
	}
	public void extendPiston() {
		solenOne.set(true);
		solenTwo.set(false);
	}
	public void retractPiston() {
		solenOne.set(false);
		solenTwo.set(true);
	}
	public void start() {
		compress.start();
	}
}