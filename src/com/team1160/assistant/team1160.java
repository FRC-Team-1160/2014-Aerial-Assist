package com.team1160.assistant;

import com.team1160.assistant.commands.CommandBase;
import com.team1160.assistant.vision.Vision;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import java.util.Random;

public class team1160 extends IterativeRobot {
    
    Vision vision;
    final double version = 0.1;
    String s1;
    
    public void robotInit(){
        Random rand = new Random();
        int a = rand.nextInt(3);
        System.out.println("Successful deploy. Currently: v" + version + "Random message: " + s1);
        vision = new Vision();
        CommandBase.init();
    }
    
    public void autonomous(){
        vision.autonomous = true;
        vision.vision(true);
    }
    
    public void teleopPeriodic(){
        Scheduler.getInstance().run();
    }
    
}