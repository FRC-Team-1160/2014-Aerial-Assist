package com.team1160.assistant.subsystems;

import com.team1160.assistant.RobotMap;
import com.team1160.assistant.commands.Shooter.Manual;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem implements RobotMap {

    protected static Shooter instance;
    protected Talon TalM_A, TalM_B;
    protected DigitalInput limSwitch;
    public Timer timer;

    public static Shooter getInstance() {
        if (instance == null) {
            instance = new Shooter();
        }
        return instance;
    }

    private Shooter() {
        TalM_A = new Talon(SHOOT_MOTOR_A);
        TalM_B = new Talon(SHOOT_MOTOR_B);
        limSwitch = new DigitalInput(LIMIT_SHOOTER_L);
        timer = new Timer();
        timer.start();
        timer.reset();
    }

    public void manual(Joystick shoot) {
        TalM_A.set(shoot.getY());
        TalM_B.set(shoot.getY());
    }

    protected void initDefaultCommand() {
        this.setDefaultCommand(null);
    }

    public void resetIt() {
        if (timer.get() <= RESET_LENGTH) {
            TalM_A.set(-0.2);
            TalM_B.set(-0.2);
        }else{
            TalM_A.set(0);
            TalM_B.set(0);
        }
    }

    public void shootIt() {
        System.out.println(timer.get());
        if (timer.get() <= SHOOT_LENGTH) {
            TalM_A.set(1);
            TalM_B.set(1);
        } else {
            TalM_A.set(0);
            TalM_B.set(0);
        }
    }

    public boolean getSwitch() {
        return limSwitch.get();
    }

    public void nothing() {
        TalM_A.set(0);
        TalM_B.set(0);
    }
}