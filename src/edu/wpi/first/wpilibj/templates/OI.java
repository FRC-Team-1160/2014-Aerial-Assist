package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.Pistons.extendPiston;
import edu.wpi.first.wpilibj.templates.commands.Pistons.retractPiston;
import edu.wpi.first.wpilibj.templates.commands.Shooter.tensionAdd;
import edu.wpi.first.wpilibj.templates.commands.Shooter.tensionLetGo;
import edu.wpi.first.wpilibj.templates.commands.Shooter.tensionRelease;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    //JOYSTICK
    private Joystick stick;
    
    //BUTTONS
    private Button extendPiston;
    private Button retractPiston;
    private Button addTension;
    private Button releaseTension;
    private Button letGo;
    
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
        addTension = new JoystickButton(stick, 7);
        releaseTension = new JoystickButton(stick, 8);
        letGo = new JoystickButton(stick, 6);
        tieButtons();
    }
    
    private void tieButtons(){
        
        extendPiston.whenPressed(new extendPiston());
        retractPiston.whenPressed(new retractPiston());
        addTension.whenPressed(new tensionAdd());
        releaseTension.whenPressed(new tensionRelease());
        letGo.whenPressed(new tensionLetGo());
        
    }
    
    //JOYSTICK GETTER FUNCTION
    public Joystick getJoystick(){
        return stick;
    }   
}