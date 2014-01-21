package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
    //---MOTORS---
    
    //-DRIVE-
    public static final int leftJagMotorSlot = 0;
    public static final int leftJagMotorChannel = 0;
    public static final int rightJagMotorSlot = 0;
    public static final int rightJagMotorChannel = 0;
    
    //-SHOOT-
    public static final int shootMotorSlot = 0;
    public static final int shootMotorChannel = 0;
    
    //---JOYSTICKS---
    public static final int joyPort = 1;
    
    //---PNEUMATICS---
    public static final int solonoidOneChannel = 1;
    public static final int solonoidTwoChannel = 2;
    public static final int compressorSwitchChannel = 1;
    public static final int compressorRelayChannel = 1;
    
    //---SPEED VALUES---
    public static final int letGo = 0;
    public static final int addTension = 0;
    public static final int releaseTension = 0;
    
    //---JOYSTICK BUTTONS---
    public static final int extendPistonBut = 4;
    public static final int retractPistonBut = 5;
    public static final int releaseTensionBut = 6;
    public static final int addTensionBut = 7;
    public static final int letGoBut = 8;
    
}
