package com.team1160.feathers.commands.groups.wills;

import com.team1160.feathers.commands.drivetrain.Halt;
import com.team1160.feathers.commands.pulleys.middle.MiddlePulleyExtend;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class WillLength extends CommandGroup {
	public WillLength(){
		addParallel(new Halt());
		addParallel(new MiddlePulleyExtend());
	}
}
