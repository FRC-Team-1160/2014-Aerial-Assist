package com.team1160.assistant.subsystems;

import com.team1160.assistant.OI;
import com.team1160.assistant.RobotMap;
import com.team1160.assistant.commands.Drive.ArcadeDrive;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


public class Drivetrain extends PIDSubsystem implements RobotMap {
	// LOCAL VARIABLES - WILL BE ASSIGNED VIA CHECKS
	protected final Talon rightT, leftT;
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
		// dat TALON INITIALIZATION
		rightT = new Talon(LEFT_TAL_MOTOR_SLOT, RIGHT_TAL_MOTOR_CHAN);
		leftT = new Talon(RIGHT_TAL_MOTOR_SLOT, LEFT_TAL_MOTOR_CHAN);
		encLeft = new Encoder(ENC_DT_LEFT_A, ENC_DT_LEFT_B, true);
		encRight = new Encoder(ENC_DT_RIGHT_A, ENC_DT_RIGHT_B, true);
		stick = OI.getInstance().getJoystick();
		encLeft.start();
		encRight.start();
                //speed control 
                rightmotorcontrol = rightT; 
                leftmotorcontrol = leftT; 
                rightmotorchan = new AnalogChannel(ENC_DT_RIGHT_A); //connected to one of the channels
                leftmotorchan = new AnalogChannel(ENC_DT_LEFT_A); //same as above
                getPIDController().setContinuous(false); 
                LiveWindow.addActuator("Drivetrain", "PIDSubsystem", getPIDController()); 
                setAbsoluteTolerance(ABSOLUTE_TOLERANCE); 
                rightmotorcontrol.set(SETPOINT); 
                leftmotorcontrol.set(SETPOINT); //I think these set up the setpoints; if not, uncomment the line below
                //setSetpoint(SETPOINT);
                enable(); 
	}
	protected void initDefaultCommand() {
		this.setDefaultCommand(new ArcadeDrive());
	}
	public void arcadeDrive() {
		// STANDARD DRIVE CODE
		leftT.set(stick.getX() - stick.getY());
		rightT.set(stick.getX() + stick.getY());
	}
	public void autoDrive() {
            
        }

    protected double returnPIDInput() {
        return rightmotorchan.getAverageVoltage();  //this only returns rightmotorchan, no left motor 
    }
    

    protected void usePIDOutput(double output) {
        rightmotorcontrol.pidWrite(output);
        leftmotorcontrol.pidWrite(output);//To change body of generated methods, choose Tools | Templates.
    }
}