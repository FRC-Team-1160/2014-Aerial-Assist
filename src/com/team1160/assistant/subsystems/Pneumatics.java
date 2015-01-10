package com.team1160.assistant.subsystems;

import com.team1160.assistant.RobotMap;
import com.team1160.assistant.commands.pneumatics.Retract;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem implements RobotMap{
    private Compressor comp;
    private DoubleSolenoid piston;
    private static Pneumatics instance;
    
    private Pneumatics(){
        comp = new Compressor(PRESSURE_SWITCH, RELAY_CHANNEL);
        piston = new DoubleSolenoid(LEFT_PORT, RIGHT_PORT);
        comp.start();
    }
    
    public static Pneumatics getInstance(){
        if(instance == null){
            instance = new Pneumatics();
        }
        return instance;
    }
    
    protected void initDefaultCommand() {
        setDefaultCommand(new Retract());
    }
    
    public void forward(){
        piston.set(DoubleSolenoid.Value.kForward);
    }
    
    public void back(){
        piston.set(DoubleSolenoid.Value.kReverse);
    }

    
}
