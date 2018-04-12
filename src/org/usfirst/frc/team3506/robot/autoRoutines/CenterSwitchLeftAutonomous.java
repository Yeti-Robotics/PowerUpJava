package org.usfirst.frc.team3506.robot.autoRoutines;

import org.usfirst.frc.team3506.robot.commands.CloseClawCommand;
import org.usfirst.frc.team3506.robot.commands.DriveStraightCommand;
import org.usfirst.frc.team3506.robot.commands.DriveTrainLowShift;
import org.usfirst.frc.team3506.robot.commands.MoveWristTimeCommand;
import org.usfirst.frc.team3506.robot.commands.OpenClawCommand;
import org.usfirst.frc.team3506.robot.commands.DriveForDistanceCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

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
        addSequential(new MoveWristTimeCommand(-.5, .5));
        addSequential(new OpenClawCommand()); //Should drop first cube? no.
        addParallel(new MoveWristTimeCommand(.5, .5));
        addSequential(new DriveForDistanceCommand(12, -.5, 0));
        addSequential(new DriveStraightCommand(84, -.5));
        addSequential(new DriveForDistanceCommand(18, 0, -.5)); //"don't touch it, i swear!"
        addSequential(new DriveStraightCommand(70, .5));
        addSequential(new CloseClawCommand());
    	addSequential(new DriveStraightCommand(24, -.5));
    	addSequential(new DriveForDistanceCommand(13, 0, .5));//"ez, ez auto"
    	addParallel(new DriveStraightCommand(56, .5));
    	addSequential(new MoveWristTimeCommand(.55, 1.25));
    	addSequential(new WaitCommand(.5));
    	addSequential(new DriveForDistanceCommand(2, .5, 0));
    	addSequential(new OpenClawCommand());
    }
}
