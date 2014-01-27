package com.team1160.assistant.subsystems;

import com.team1160.assistant.RobotMap;
import com.team1160.assistant.commands.Shooter.neutral;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem implements RobotMap {
	protected static Shooter instance;
	protected Jaguar jagM;
	protected Encoder encoder;
	public static Shooter getInstance() {
		if (instance == null) {
			instance = new Shooter();
		}
		return instance;
	}
	private Shooter() {
		jagM = new Jaguar(SHOOT_MOTOR_SLOT, SHOOT_MOTOR_CHAN);
		encoder = new Encoder(ENC_SHOOT_A, ENC_SHOOT_B, true);
		encoder.start();
	}
	protected void initDefaultCommand() {
		this.setDefaultCommand(new neutral());
	}
	public void neutrals() {
		jagM.set(0);
	}
	public void addTension() {
		jagM.set(ADD_TENSION);
	}
	public void releaseTension() {
		jagM.set(RELEASE_TENSION);
	}
	public void letGo() {
		jagM.set(LET_GO);
	}
}