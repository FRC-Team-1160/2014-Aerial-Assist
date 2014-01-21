package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
    //MOTORS
    public static final int leftJagMotorSlot = 0;
    public static final int leftJagMotorChannel = 0;
    public static final int rightJagMotorSlot = 0;
    public static final int rightJagMotorChannel = 0;
    
    //JOYSTICKS
    public static final int joyPort = 1;
    
    //PNEUMATICS
    public static final int solonoidChannel = 1;
    public static final int compressorSwitchChannel = 1;
    public static final int compressorRelayChannel = 1;
    
    
    
}
