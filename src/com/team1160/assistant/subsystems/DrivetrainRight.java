package com.team1160.assistant.subsystems;

import com.team1160.assistant.commands.Drive.ArcadeDriveRight;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;

public class DrivetrainRight extends DrivetrainBase {

    protected static DrivetrainRight instance;

    public static DrivetrainRight getInstance() {
        if (instance == null) {
            instance = new DrivetrainRight();
        }
        return instance;
    }

    private DrivetrainRight() {

        tal = new Talon(RIGHT_TAL_MOTOR);
        enc = new Encoder(ENC_DT_RIGHT_A, ENC_DT_RIGHT_B, true);
        enc.start();
        enc.startLiveWindowMode();
        pid = new PIDController(P, I, D, enc, this);
        pid.startLiveWindowMode();
        pid.setSetpoint(SETPOINT);
        pid.setAbsoluteTolerance(ABSOLUTE);
        stick = this.getJoystick();
        pid.enable();
        startLogging("right_pid", pid);
        startLogging("right_enc", enc);
    }

    protected void initDefaultCommand() {
        this.setDefaultCommand(new ArcadeDriveRight());
    }

    public void pidWrite(double d) {
        tal.set(tal.get() + d);
        System.out.println("Right working towards: " + d);
    }

    public double pidGet() {
        return enc.pidGet();
    }

    public void arcadeRight() {
        tal.set(stick.getX() + stick.getY());
    }
}
