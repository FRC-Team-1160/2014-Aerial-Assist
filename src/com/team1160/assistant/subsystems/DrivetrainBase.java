package com.team1160.assistant.subsystems;

import com.team1160.assistant.RobotMap;
import com.team1160.assistant.commands.Drive.ArcadeDrive;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DrivetrainBase extends Subsystem implements RobotMap {

    protected Talon left, right;
    protected Encoder enc_left, enc_right;
    protected Joystick stick;
    protected static DrivetrainBase instance;
    protected Timer timer;

    public static DrivetrainBase getInstance() {
        if (instance == null) {
            instance = new DrivetrainBase();
        }
        return instance;
    }

    protected DrivetrainBase() {
        left = new Talon(LEFT_TAL_MOTOR);
        right = new Talon(RIGHT_TAL_MOTOR);
        enc_left = new Encoder(ENC_DT_LEFT_A, ENC_DT_LEFT_B);
        enc_right = new Encoder(ENC_DT_RIGHT_A, ENC_DT_RIGHT_B);
        enc_left.start();
        enc_right.start();
        timer = new Timer();
    }

    public boolean autoDrive(int dist, int speed) {
        System.out.println("going bitches");
        while (enc_left.get() <= dist - 1) {
//          tal.set(speed*(.1*(dist-enc.get())));
            if (enc_left.get() <= dist - 1) {
                left.set(speed);
            } else if (enc_right.get() >= -dist + 1) {
                right.set(-speed);
            }
            right.set(-speed);
        }
        return true;
    }

    public void autoTimeDrive(double time, boolean run) {
        timer.start();
        timer.reset();
        while (run) {
            left.set(-0.5);
            right.set(0.503);
            System.out.println(timer.get());
            if (timer.get() >= time) {
                left.set(0);
                right.set(0);
                run = false;
            }
        }
    }

    protected void initDefaultCommand() {
        this.setDefaultCommand(new ArcadeDrive());
    }

    public void manualDrive(Joystick stick) {
        left.set(stick.getX() - stick.getY());
        right.set(stick.getX() + stick.getY());
    }
}