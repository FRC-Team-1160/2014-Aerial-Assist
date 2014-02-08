package com.team1160.assistant.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonGroup extends CommandGroup{
    
    public AutonGroup(){
        
        addSequential(new DriveForward(10));
        
    }
    
}
