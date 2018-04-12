package org.usfirst.frc.team3506.robot.autoRoutines;

import org.usfirst.frc.team3506.robot.commands.DriveStraightCommand;
import org.usfirst.frc.team3506.robot.commands.DriveTrainLowShift;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveForwardAutonomous extends CommandGroup {

    public DriveForwardAutonomous() { //ez auto
    	addSequential(new DriveTrainLowShift());
    	addSequential(new DriveStraightCommand(148, .5)); //robowranglers haha
    }
}
