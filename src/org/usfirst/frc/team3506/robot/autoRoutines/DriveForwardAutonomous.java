package org.usfirst.frc.team3506.robot.autoRoutines;

import org.usfirst.frc.team3506.robot.commands.DriveStraightPIDCommand;
import org.usfirst.frc.team3506.robot.commands.DriveTrainLowShift;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveForwardAutonomous extends CommandGroup {

    public DriveForwardAutonomous() { //ez auto
    	addSequential(new DriveTrainLowShift());
    	addSequential(new DriveStraightPIDCommand(148)); //robowranglers haha
    }
}
