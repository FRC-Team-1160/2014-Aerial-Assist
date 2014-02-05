package com.team1160.assistant;

import com.team1160.assistant.commands.CommandBase;
import com.team1160.assistant.vision.Vision;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Team1160 extends IterativeRobot {
	Vision vision;
	public void robotInit() {
		Version.getInstance();
		CommandBase.init();
		vision = new Vision();
                vision.exec.startVision();
	}
	public void autonomous() {
		vision.autonomous = true;
		vision.vision();
	}
	public void teleopPeriodic() {
		vision.autonomous = false;
		Scheduler.getInstance().run();
	}
}