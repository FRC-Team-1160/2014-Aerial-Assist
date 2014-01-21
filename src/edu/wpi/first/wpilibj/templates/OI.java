package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.extendPiston;
import edu.wpi.first.wpilibj.templates.commands.retractPiston;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    //JOYSTICK
    private Joystick stick;
    
    //MOTOR
    private Jaguar jagl;
    private Jaguar jagr;
    
    //PNEUMATICS
    private Solenoid solOne;
    private Solenoid solTwo;
    private Compressor comp;
    
    //BUTTONS
    private Button extendPiston;
    private Button retractPiston;
    
    private static OI instance;
    
    //ALLOWS CLASSES TO RETRIEVE INSTANCE OF OI
    public static OI getInstance(){
        if(instance == null){
            instance = new OI();
        }
        return instance;
    }
    
    private OI(){
        stick = new Joystick(RobotMap.joyPort);
        initButtons();
    }
    
    private void initButtons(){
        
        extendPiston = new JoystickButton(stick, 4);
        retractPiston = new JoystickButton(stick, 5);
        tieButtons();
    }
    
    private void tieButtons(){
        
        extendPiston.whenPressed(new extendPiston());
        retractPiston.whenPressed(new retractPiston());
        
    }
    
    //JOYSTICK GETTER FUNCTION
    public Joystick getJoystick(){
        return stick;
    }   
}