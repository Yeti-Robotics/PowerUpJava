package org.usfirst.frc.team3506.robot.autoRoutines;

import org.usfirst.frc.team3506.robot.commands.CloseClawCommand;
import org.usfirst.frc.team3506.robot.commands.DriveStraightForTimeCommand;
import org.usfirst.frc.team3506.robot.commands.DriveTrainLowShift;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveForwardTimeAutonomous extends CommandGroup {

    public DriveForwardTimeAutonomous() {
        addSequential(new DriveTrainLowShift());
        addSequential(new CloseClawCommand());
        addSequential(new DriveStraightForTimeCommand(3, 0.8));
    }
}
