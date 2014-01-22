package com.team1160.assistant;

import com.team1160.assistant.commands.Pistons.extendPiston;
import com.team1160.assistant.commands.Pistons.retractPiston;
import com.team1160.assistant.commands.Shooter.tensionAdd;
import com.team1160.assistant.commands.Shooter.tensionLetGo;
import com.team1160.assistant.commands.Shooter.tensionRelease;
import com.team1160.assistant.commands.vision.visionCommand;
import com.team1160.assistant.commands.vision.visionDoNothing;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

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
    private Button track;
    private Button stopTrack;
    
    private static OI instance;
    
    //ALLOWS CLASSES TO RETRIEVE INSTANCE OF OI
    public static OI getInstance(){
        if(instance == null){
            instance = new OI();
        }
        return instance;
    }
    
    private OI(){
        stick = new Joystick(RobotMap.JOY_PORT);
        initButtons();
    }
    
    private void initButtons(){
        
        extendPiston = new JoystickButton(stick, RobotMap.EXTEND_PISTON_BUT);
        retractPiston = new JoystickButton(stick, RobotMap.RETRACT_PISTON_BUT);
        addTension = new JoystickButton(stick, RobotMap.ADD_TENSION_BUT);
        releaseTension = new JoystickButton(stick, RobotMap.RELEASE_TENSION_BUT);
        letGo = new JoystickButton(stick, RobotMap.LET_GO_BUT);
        track = new JoystickButton(stick, RobotMap.VISION_TRACK_BUT);
        stopTrack = new JoystickButton(stick, RobotMap.STOP_VISION_TRACK_BUT);
        tieButtons();
    }
    
    private void tieButtons(){
        
        extendPiston.whenPressed(new extendPiston());
        retractPiston.whenPressed(new retractPiston());
        addTension.whenPressed(new tensionAdd());
        releaseTension.whenPressed(new tensionRelease());
        letGo.whenPressed(new tensionLetGo());
        track.whenPressed(new visionCommand());
        stopTrack.whenPressed(new visionDoNothing());
        
    }
    
    //JOYSTICK GETTER FUNCTION
    public Joystick getJoystick(){
        return stick;
    }   
}