package com.team1160.assistant;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import com.team1160.assistant.commands.Pistons.extendPiston;
import com.team1160.assistant.commands.Pistons.retractPiston;
import com.team1160.assistant.commands.Shooter.tensionAdd;
import com.team1160.assistant.commands.Shooter.tensionLetGo;
import com.team1160.assistant.commands.Shooter.tensionRelease;

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
        
        extendPiston = new JoystickButton(stick, RobotMap.extendPistonBut);
        retractPiston = new JoystickButton(stick, RobotMap.retractPistonBut);
        addTension = new JoystickButton(stick, RobotMap.addTensionBut);
        releaseTension = new JoystickButton(stick, RobotMap.releaseTensionBut);
        letGo = new JoystickButton(stick, RobotMap.letGoBut);
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