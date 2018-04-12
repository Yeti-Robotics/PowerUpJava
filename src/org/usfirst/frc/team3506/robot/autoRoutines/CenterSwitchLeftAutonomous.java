package org.usfirst.frc.team3506.robot.autoRoutines;

import org.usfirst.frc.team3506.robot.commands.CloseClawCommand;
import org.usfirst.frc.team3506.robot.commands.DriveStraightCommand;
import org.usfirst.frc.team3506.robot.commands.DriveTrainLowShift;
import org.usfirst.frc.team3506.robot.commands.MoveWristTimeCommand;
import org.usfirst.frc.team3506.robot.commands.OpenClawCommand;
import org.usfirst.frc.team3506.robot.commands.DriveForDistanceCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterSwitchLeftAutonomous extends CommandGroup {

    public CenterSwitchLeftAutonomous() {
    	addSequential(new DriveTrainLowShift());
    	addSequential(new CloseClawCommand());
        addSequential(new DriveForDistanceCommand(16, 0, .5));
        addSequential(new DriveStraightCommand(88, .5));
        addSequential(new DriveForDistanceCommand(16, .5, 0));
        addSequential(new MoveWristTimeCommand(-1, .5));
        addSequential(new OpenClawCommand()); //Should drop first cube?
        /*addSequential(new MoveWristTimeCommand(.65, .45));
        addSequential(new DriveForDistanceCommand(-20, .5, 0));
        addSequential(new DriveStraightCommand(-84, -.5));
        addSequential(new DriveForDistanceCommand(-28, 0, -.5));
        addSequential(new DriveStraightCommand(72, .5));
        addSequential(new CloseClawCommand());
    	addSequential(new DriveStraightCommand(-24, -.5));
    	addSequential(new DriveForDistanceCommand(16, 0, .5));
    	addParallel(new MoveWristTimeCommand(.70, 1));
    	addSequential(new DriveStraightCommand(62, .5));
    	addSequential(new DriveForDistanceCommand(12, .5, 0));
    	addSequential(new OpenClawCommand());**/
    }
}
