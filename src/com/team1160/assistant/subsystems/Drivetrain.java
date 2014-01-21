package com.team1160.assistant.subsystems;

import com.team1160.assistant.OI;
import com.team1160.assistant.RobotMap;
import com.team1160.assistant.commands.Drive.arcadeDrive;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Drivetrain extends Subsystem{

    
    //LOCAL VARIABLES - WILL BE ASSIGNED VIA CHECKS
    protected Jaguar rightJ, leftJ; //JAGUAR
    protected Joystick stick; //JOYSTICK
    protected static Drivetrain instance = null; //INSTANCE OF DRIVETRAIN CLASS
    
    //METHOD CALLED BY COMMANDBASE TO RETRIEVE INSTANCE OF DT
    public static Drivetrain getInstance() {
        //IF DT INSTANCE DOESN'T EXIST, CREATE IT
        if(instance == null){ 
            //IF LOOP TO ENSURE IT IS *NOT* INSTANTIATED MORE THAN ONCE
            instance = new Drivetrain();
        }
        //RETURN THE CREATED INSTANCE TO COMMANDBASE
        return instance;
    }
    
    //CONSTRUCTOR - IS CALLED ONCE, ONLY BY GETINSTANCE
    private Drivetrain(){
        //JAGUAR INITIALIZATION
        rightJ = new Jaguar(RobotMap.leftJagMotorSlot, RobotMap.leftJagMotorChannel);
        leftJ = new Jaguar(RobotMap.rightJagMotorSlot, RobotMap.rightJagMotorChannel);
    }
    
    protected void initDefaultCommand() {
        //DEFAULT COMMAND CLASS WILL CALL
        this.setDefaultCommand(new arcadeDrive());
    }
    
    public void arcadeDrive(){
        //MAKE SURE JOYSTICK HAS BEEN INITIALIZED
        if(stick == null){
            stick = OI.getInstance().getJoystick();
        }
        
        //STANDARD DRIVE CODE
        leftJ.set(stick.getX()-stick.getY());
	rightJ.set(stick.getX()+stick.getY());
        
    }
    
    
    

}