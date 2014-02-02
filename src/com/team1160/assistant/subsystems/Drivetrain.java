package com.team1160.assistant.subsystems;

import com.team1160.assistant.OI;
import com.team1160.assistant.RobotMap;
import com.team1160.assistant.commands.Drive.arcadeDrive;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


public class Drivetrain extends PIDSubsystem implements RobotMap {
	// LOCAL VARIABLES - WILL BE ASSIGNED VIA CHECKS
	protected final Jaguar rightJ, leftJ;
	protected final Joystick stick;
	protected static Drivetrain instance = null;
	// INSTANCE OF DRIVETRAIN CLASS
	protected final Encoder encLeft;
	protected final Encoder encRight;
        //INSTANCE OF SPEEDCONTROLLER AND ANALOG CHANNELS 
        protected final SpeedController rightmotorcontrol, leftmotorcontrol; 
        protected final AnalogChannel  rightmotorchan, leftmotorchan; 
        protected final double SETPOINT =0; 
        protected final double ABSOLUTE_TOLERANCE =0; 
	// METHOD CALLED BY COMMANDBASE TO RETRIEVE INSTANCE OF DT
	public static Drivetrain getInstance() {
		// IF DT INSTANCE DOESN'T EXIST, CREATE IT
		if (instance == null) {
			// IF LOOP TO ENSURE IT IS *NOT* INSTANTIATED MORE THAN ONCE
			instance = new Drivetrain();
		}
		// RETURN THE CREATED INSTANCE TO COMMANDBASE
		return instance;
	}
	// CONSTRUCTOR - IS CALLED ONCE, ONLY BY GETINSTANCE
	private Drivetrain() {
            super("Drivetrain", 0, 0, 0); //numerical values PID will be changed to experimental value 
		// JAGUAR INITIALIZATION
		rightJ = new Jaguar(LEFT_JAG_MOTOR_SLOT, RIGHT_JAG_MOTOR_CHAN);
		leftJ = new Jaguar(RIGHT_JAG_MOTOR_SLOT, LEFT_JAG_MOTOR_CHAN);
		encLeft = new Encoder(ENC_DT_LEFT_A, ENC_DT_LEFT_B, true);
		encRight = new Encoder(ENC_DT_RIGHT_A, ENC_DT_RIGHT_B, true);
		stick = OI.getInstance().getJoystick();
		encLeft.start();
		encRight.start();
                //speed control 
                rightmotorcontrol = rightJ; 
                leftmotorcontrol = leftJ; 
                rightmotorchan = new AnalogChannel(RobotMap.ENC_DT_RIGHT_A); //connected to one of the channels
                leftmotorchan = new AnalogChannel(RobotMap.ENC_DT_LEFT_A); //same as above
                getPIDController().setContinuous(false); 
                LiveWindow.addActuator("Drivetrain", "PIDSubsystem", getPIDController()); 
                setAbsoluteTolerance(ABSOLUTE_TOLERANCE); 
                rightmotorcontrol.set(SETPOINT); 
                leftmotorcontrol.set(SETPOINT); //I think these set up the setpoints; if not, uncomment the line below
                //setSetpoint(SETPOINT);
                enable(); 
                
                
                
	}
	protected void initDefaultCommand() {
		this.setDefaultCommand(new arcadeDrive());
	}
	public void arcadeDrive() {
		// STANDARD DRIVE CODE
		leftJ.set(stick.getX() - stick.getY());
		rightJ.set(stick.getX() + stick.getY());
	}
	public void autoDrive() {}

    protected double returnPIDInput() {
        return rightmotorchan.getAverageVoltage();  //this only returns rightmotorchan, no left motor 
    }
    

    protected void usePIDOutput(double output) {
        rightmotorcontrol.pidWrite(output);
        leftmotorcontrol.pidWrite(output);//To change body of generated methods, choose Tools | Templates.
    }
}