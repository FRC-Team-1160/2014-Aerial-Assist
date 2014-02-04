package com.team1160.assistant;

import com.team1160.assistant.commands.CommandBase;
import com.team1160.assistant.vision.Vision;
import com.team1160.assistant.vision.Vision.Executor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Team1160 extends IterativeRobot {
	Vision vision;
	public void robotInit() {
		vision = new Vision();
                vision.exec.startVision();
		Version.getInstance();
		CommandBase.init();
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