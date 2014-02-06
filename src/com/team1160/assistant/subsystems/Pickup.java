package com.team1160.assistant.subsystems;

import com.team1160.assistant.RobotMap;
import com.team1160.assistant.commands.pickup.LowerArm;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Pickup extends PIDSubsystem implements RobotMap {

    protected Talon talPickup;
    protected static Pickup instance;
    protected double currentPos;
    protected Encoder enc;
    protected final SpeedController motorcontrol;
    protected final AnalogChannel motorchan;
    protected final double SETPOINT = 0;
    protected final double ABSOLUTE_TOLERANCE = 0;

    private Pickup() {
        super("Pickup", 0, 0, 0);
        talPickup = new Talon(PICKUP_TAL_MOTOR_SLOT, PICKUP_TAL_MOTOR_CHAN);
        motorcontrol = talPickup;
        motorchan = new AnalogChannel(ENC_PICKUP_A);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("Pickup", "PIDSubsystem", getPIDController());
        setAbsoluteTolerance(ABSOLUTE_TOLERANCE);
        motorcontrol.set(SETPOINT);
        //I think these set up the setpoints; if not, uncomment the line below
        //setSetpoint(SETPOINT);
        enable();
        

    }

    public static Pickup getInstance() {
        if (instance == null) {
            instance = new Pickup();
        }
        return instance;
    }

    protected void initDefaultCommand() {
        this.setDefaultCommand(new LowerArm());
    }

    public void lowerArm() {
        while (currentPos > PICKUP_HARDSTOP_L) {
            talPickup.set(LOWER_ARM);
        }
    }

    public void stall() {
        talPickup.set(PICKUP_STALL);
    }

    public void raiseArm() {
        while (currentPos < PICKUP_HARDSTOP_H) {
            talPickup.set(RAISE_ARM);
        }
    }

    protected double returnPIDInput() {
        return motorchan.getAverageVoltage();
    }

    protected void usePIDOutput(double output) {
        motorcontrol.pidWrite(output);
    }
}
