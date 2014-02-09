package com.team1160.assistant.subsystems;

import com.team1160.assistant.commands.Drive.ArcadeDriveLeft;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;

public class DrivetrainLeft extends DrivetrainBase {

    protected static DrivetrainLeft instance;

    public static DrivetrainLeft getInstance() {
        if (instance == null) {
            instance = new DrivetrainLeft();
        }
        return instance;
    }

    private DrivetrainLeft() {

        tal = new Talon(LEFT_TAL_MOTOR);
        enc = new Encoder(ENC_DT_LEFT_A, ENC_DT_LEFT_B, true);
        enc.startLiveWindowMode();
        enc.start();
        pid = new PIDController(P, I, D, enc, this);
        pid.startLiveWindowMode();
        pid.setAbsoluteTolerance(ABSOLUTE);
        pid.setSetpoint(SETPOINT);
        stick = this.getJoystick();
        pid.enable();
        startLogging("left_pid", pid);
        startLogging("left_enc", enc);
    }

    protected void initDefaultCommand() {
        this.setDefaultCommand(new ArcadeDriveLeft());
    }

    public void pidWrite(double d) {
        tal.set(tal.get() + d);
        System.out.println("Left working towards: " + d);
    }

    public double pidGet() {
        return enc.pidGet();
    }

    public void arcadeLeft() {
        tal.set(stick.getX() - stick.getY());
    }
}