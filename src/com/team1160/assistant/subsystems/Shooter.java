package com.team1160.assistant.subsystems;

import com.team1160.assistant.RobotMap;
import com.team1160.assistant.commands.Shooter.neutral;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Shooter extends PIDSubsystem implements RobotMap {
	protected static Shooter instance;
	protected Jaguar jagM;
	protected Encoder encoder;
        //speed controller
        protected final SpeedController shootmotorcontrol;
        protected final AnalogChannel  encoderchan; 
        protected final double SETPOINT =0; 
        protected final double ABSOLUTE_TOLERANCE =0; 
	public static Shooter getInstance() {
		if (instance == null) {
			instance = new Shooter();
		}
		return instance;
	}
	private Shooter() {
                super("Shooter", 0, 0, 0); //numerical values PID will be changed to experimental values
		jagM = new Jaguar(SHOOT_MOTOR_SLOT, SHOOT_MOTOR_CHAN);
		encoder = new Encoder(ENC_SHOOT_A, ENC_SHOOT_B, true);
		encoder.start();
                //speed control
                shootmotorcontrol = jagM; 
                encoderchan = new AnalogChannel(RobotMap.ENC_SHOOT_A); //use only one of the encoder channels
                getPIDController().setContinuous(false); 
                LiveWindow.addActuator("Drivetrain", "PIDSubsystem", getPIDController()); 
                setAbsoluteTolerance(ABSOLUTE_TOLERANCE); 
                shootmotorcontrol.set(SETPOINT); //I think these set up the setpoints; if not, uncomment the line below
                //setSetpoint(SETPOINT);
                enable(); 
                
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

    protected double returnPIDInput() {
        return encoderchan.getAverageVoltage(); 
    }

    protected void usePIDOutput(double output) {
       shootmotorcontrol.pidWrite(output); //To change body of generated methods, choose Tools | Templates.
    }
}