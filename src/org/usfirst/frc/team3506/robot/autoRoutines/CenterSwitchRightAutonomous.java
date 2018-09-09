package org.usfirst.frc.team3506.robot.autoRoutines;

import org.usfirst.frc.team3506.robot.commands.CloseClawCommand;
import org.usfirst.frc.team3506.robot.commands.DriveForDistanceCommand;
import org.usfirst.frc.team3506.robot.commands.DriveStraightCommand;
import org.usfirst.frc.team3506.robot.commands.DriveTrainLowShift;
import org.usfirst.frc.team3506.robot.commands.MoveWristTimeCommand;
import org.usfirst.frc.team3506.robot.commands.OpenClawCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterSwitchRightAutonomous extends CommandGroup {

    public CenterSwitchRightAutonomous() {
        addSequential(new DriveTrainLowShift());
        addSequential(new CloseClawCommand());
        addSequential(new DriveForDistanceCommand(26, 0.8, 0));
        addSequential(new DriveStraightCommand(80, .8));
        addSequential(new DriveForDistanceCommand(18, 0, 0.8));
        addSequential(new MoveWristTimeCommand(-.4, .5));
        addSequential(new OpenClawCommand()); //Should drop first cube? no.
        addParallel(new MoveWristTimeCommand(.5, .6));

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
