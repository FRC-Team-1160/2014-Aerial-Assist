package com.team1160.assistant.subsystems;

import com.team1160.assistant.commands.Drive.ArcadeDriveLeft;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;

public class DrivetrainLeft extends DrivetrainBase {

    protected static DrivetrainLeft instanceDT;

    public static DrivetrainLeft getInstance() {
        if (instanceDT == null) {
            instanceDT = new DrivetrainLeft();
        }
        return instanceDT;
    }

    private DrivetrainLeft() {
        tal = new Talon(LEFT_TAL_MOTOR);
        enc = new Encoder(ENC_DT_LEFT_A, ENC_DT_LEFT_B, true);
        enc.startLiveWindowMode();
        enc.setDistancePerPulse(PULSE_DISTANCE);
        pid = new PIDController(P, I, D, enc, this);
        pid.startLiveWindowMode();
        pid.setSetpoint(SETPOINT);
        pid.setAbsoluteTolerance(ABSOLUTE);
        stick = this.getJoystick();
        pid.setContinuous();
    }

    protected void initDefaultCommand() {
        this.setDefaultCommand(new ArcadeDriveLeft());
    }

    public void pidWrite(double d) {
        tal.set(tal.get() + d);
        System.out.println("Left working towards: " + d);
    }

    public void arcadeLeft() {
        tal.set(stick.getX() - stick.getY());
    }
}