package com.team1160.assistant.subsystems;

import com.team1160.assistant.RobotMap;
import com.team1160.assistant.commands.Shooter.Neutral;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Shooter extends Subsystem implements RobotMap,  PIDSource, PIDOutput {

    protected static Shooter instance;
    protected Talon TalM;
    protected Encoder encoder;
    //speed controller
    protected final PIDController shootmotorcontrol;

    public static Shooter getInstance() {
        if (instance == null) {
            instance = new Shooter();
        }
        return instance;
    }

    private Shooter() {
        TalM = new Talon(SHOOT_MOTOR_SLOT, SHOOT_MOTOR_CHAN);
        encoder = new Encoder(ENC_SHOOT_A, ENC_SHOOT_B, true);
        encoder.start();
        //speed control
        shootmotorcontrol = new PIDController(0, 0, 0, encoder, TalM); 
        shootmotorcontrol.startLiveWindowMode(); 
        shootmotorcontrol.enable();
        shootmotorcontrol.setAbsoluteTolerance(PICKUP_TOLERANCE);
        shootmotorcontrol.setSetpoint(PICKUP_SETPOINT);
        
    }

    protected void initDefaultCommand() {
        this.setDefaultCommand(new Neutral());
    }

    public void neutrals() {
        TalM.set(0);
    }

    public void addTension() {
        TalM.set(ADD_TENSION);
    }

    public void releaseTension() {
        TalM.set(RELEASE_TENSION);
    }

    public void letGo() {
        TalM.set(LET_GO);
    }

    public double pidGet() {
        return encoder.pidGet(); 
    }

    public void pidWrite(double d) {
       TalM.set(shootmotorcontrol.get() + d); 
    }
}