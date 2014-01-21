package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.*;
import edu.wpi.first.wpilibj.templates.commands.arcadeDrive;


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