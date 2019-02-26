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
        addSequential(new DriveForDistanceCommand(26, 0, .8));
        addSequential(new DriveStraightCommand(80, .8));
        addSequential(new DriveForDistanceCommand(25, .8, 0));
        addSequential(new MoveWristTimeCommand(-.4, .65));
        addSequential(new OpenClawCommand()); //Should drop first cube? no.
        addParallel(new MoveWristTimeCommand(.5, .6));
//        addSequential(new DriveForDistanceCommand(12, -.5, 0));
//        addSequential(new DriveStraightCommand(84, -.5));
//        addSequential(new DriveForDistanceCommand(18, 0, -.5)); //"don't touch it, i swear!"
//        addSequential(new DriveStraightCommand(64, .60));
//        addSequential(new CloseClawCommand());
//    	addSequential(new DriveStraightCommand(24, -.5));
//    	addSequential(new DriveForDistanceCommand(13, 0, .5));//"ez, ez auto"
//    	addParallel(new DriveStraightCommand(54, .5));
//    	addSequential(new MoveWristTimeCommand(-.55, 1.25));
//    	addSequential(new WaitCommand(.5));
//    	addSequential(new DriveForDistanceCommand(6, .5, 0));
//    	addSequential(new OpenClawCommand());
    }
}
