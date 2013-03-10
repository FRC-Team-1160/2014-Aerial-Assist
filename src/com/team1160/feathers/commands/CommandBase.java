package com.team1160.feathers.commands;

import com.team1160.feathers.OI;
import com.team1160.feathers.subsystems.Drivetrain;
import com.team1160.feathers.subsystems.*;

import edu.wpi.first.wpilibj.command.Command;

public class CommandBase extends Command {
	
	
	protected static Drivetrain dt;
        protected static LeftPulley lp;
        protected static RightPulley rp;
        protected static MiddlePulley mp;
	
	public static void init(){
		dt = Drivetrain.getInstance();
                lp = LeftPulley.getInstance();
                rp = RightPulley.getInstance();
                mp = MiddlePulley.getInstance();
		OI.getInstance();
	}
	
	protected void initialize() {
	}

	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void end() {
		// TODO Auto-generated method stub
		
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
}
