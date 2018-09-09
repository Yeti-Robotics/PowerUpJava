package org.usfirst.frc.team3506.robot.autoRoutines;

import org.usfirst.frc.team3506.robot.commands.CloseClawCommand;
import org.usfirst.frc.team3506.robot.commands.DriveStraightCommand;
import org.usfirst.frc.team3506.robot.commands.DriveTrainLowShift;
import org.usfirst.frc.team3506.robot.subsystems.ClampCubeSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveForwardAutonomous extends CommandGroup {

    public DriveForwardAutonomous() { //ez auto
    	addSequential(new DriveTrainLowShift());
    	addSequential(new CloseClawCommand());
    	addSequential(new DriveStraightCommand(150, .8)); //robowranglers haha
    }
}
