package com.team1160.assistant.subsystems;

import com.team1160.assistant.RobotMap;
import com.team1160.assistant.commands.Shooter.neutral;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;


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
        jagM = new Jaguar(RobotMap.SHOOT_MOTOR_SLOT, RobotMap.SHOOT_MOTOR_CHAN);
    }
    
    protected void initDefaultCommand() {
        this.setDefaultCommand(new neutral());
    }
    
    public void neutrals(){
        jagM.set(0);
    }
    
    public void addTension(){
        jagM.set(RobotMap.ADD_TENSION);
    }
    
    public void releaseTension(){
        jagM.set(RobotMap.RELEASE_TENSION);
    }
    
    public void letGo(){
        jagM.set(RobotMap.LET_GO);
    }
    
}