package com.team1160.assistant;

import com.team1160.assistant.commands.CommandBase;
import com.team1160.assistant.commands.DriveForward;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Team1160 extends IterativeRobot {

    Command autonomous;

    public void robotInit() {
        CommandBase.init();
        Version.getInstance();
        autonomous = new DriveForward();

    }

    public void autonomousInit() {
        autonomous.start();
    }
    
    public void autonomousPeriodic(){
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        autonomous.cancel();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
}