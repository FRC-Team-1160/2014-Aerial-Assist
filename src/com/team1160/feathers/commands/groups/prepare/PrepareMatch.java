package com.team1160.feathers.commands.groups.prepare;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
 * Will be a function for us to run at the pits
 * it will get everything in the frame perimeter
 * currently empty due to lack of knowledge on 
 * what numbers are "in bounds"
 */
public class PrepareMatch extends CommandGroup {
    
    public PrepareMatch(){
        
        addSequential(new PrepareDrive());
        
    }

}
