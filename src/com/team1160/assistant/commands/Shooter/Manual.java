//package com.team1160.assistant.commands.Shooter;
//
//import com.team1160.assistant.OI;
//import com.team1160.assistant.commands.CommandBase;
//import edu.wpi.first.wpilibj.Joystick;
//
//public class Manual extends CommandBase{
//    
//    Joystick shooterStick;
//    
//    public Manual(){
//        requires(shoot);
//    }
//    
//    protected void initialize() {
//        shooterStick = OI.getInstance().getShootJoystick();
//    }
//
//    protected void execute() {
//        shoot.manual(shooterStick);
//    }
//
//    protected boolean isFinished() {
//        return false;
//    }
//
//    protected void end() {
//    }
//
//    protected void interrupted() {
//    }
//
//}
