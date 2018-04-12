package org.usfirst.frc.team3506.robot.autoRoutines;

import org.usfirst.frc.team3506.robot.commands.CloseClawCommand;
import org.usfirst.frc.team3506.robot.commands.DriveLeftSideCommand;
import org.usfirst.frc.team3506.robot.commands.DriveRightSideCommand;
import org.usfirst.frc.team3506.robot.commands.DriveStraightPIDCommand;
import org.usfirst.frc.team3506.robot.commands.DriveTrainLowShift;
import org.usfirst.frc.team3506.robot.commands.MoveWristCommand;
import org.usfirst.frc.team3506.robot.commands.MoveWristTimeCommand;
import org.usfirst.frc.team3506.robot.commands.OpenClawCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class CenterSwitchLeftAutonomous extends CommandGroup {

    public CenterSwitchLeftAutonomous() {
    	addSequential(new DriveTrainLowShift());
    	addSequential(new CloseClawCommand());
        addSequential(new DriveRightSideCommand(22));
        addSequential(new DriveStraightPIDCommand(104));
        addSequential(new DriveLeftSideCommand(10));
        addParallel(new MoveWristTimeCommand(-.5, .5));
        addSequential(new OpenClawCommand()); //Should drop first cube?
        addSequential(new DriveLeftSideCommand(-24));
        addSequential(new DriveStraightPIDCommand(-84));
        addSequential(new DriveRightSideCommand(-28));
        addSequential(new DriveStraightPIDCommand(48));
        addSequential(new CloseClawCommand());
    }
}
