package com.team1160.assistant.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.team1160.assistant.RobotMap;
import com.team1160.assistant.commands.Shooter.neutral;


public class Shooter extends Subsystem{

    
    protected static Shooter instance;
    
    protected Jaguar jagM;
    
    public static Shooter getInstance(){
        if(instance == null){
            instance = new Shooter();
        }
        return instance;
    }
    
    private Shooter(){
        jagM = new Jaguar(RobotMap.shootMotorSlot, RobotMap.shootMotorChannel);
    }
    
    protected void initDefaultCommand() {
        this.setDefaultCommand(new neutral());
    }
    
    public void neutrals(){
        jagM.set(0);
    }
    
    public void addTension(){
        jagM.set(RobotMap.addTension);
    }
    
    public void releaseTension(){
        jagM.set(RobotMap.releaseTension);
    }
    
    public void letGo(){
        jagM.set(RobotMap.letGo);
    }
    
}