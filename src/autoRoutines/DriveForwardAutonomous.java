package autoRoutines;

import org.usfirst.frc.team3506.robot.commands.DriveTrainLowShift;

import autoCommands.DriveStraightPIDCommand;
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
