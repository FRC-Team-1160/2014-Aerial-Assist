package com.team1160.assistant.subsystems;

import com.team1160.assistant.RobotMap;
import com.team1160.assistant.commands.Pistons.retractPiston;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem{
    
    protected Compressor compress;
    protected Solenoid solenOne;
    protected Solenoid solenTwo;
    protected static Pneumatics instance;
    
    public static Pneumatics getInstance() {
        if(instance == null){
            instance = new Pneumatics();
        }
        return instance;
    }
    
    private Pneumatics(){
        compress = new Compressor(RobotMap.COMPRESSOR_SWITCH_CHAN, RobotMap.COMPRESSOR_SWITCH_CHAN);
        solenOne = new Solenoid(RobotMap.SOLENOID_ONE);
        solenTwo = new Solenoid(RobotMap.SOLENOID_TWO);
    }
    
    protected void initDefaultCommand() {
        this.setDefaultCommand(new retractPiston());
    }
    
    public void extendPiston(){
        solenOne.set(true);
        solenTwo.set(false);
    }
    
    public void retractPiston(){
        solenOne.set(false);
        solenTwo.set(true);
    }
    
    
}