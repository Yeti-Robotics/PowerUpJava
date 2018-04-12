package autoRoutines;

import org.usfirst.frc.team3506.robot.commands.MoveWristCommand;

import autoCommands.CloseClawCommand;
import autoCommands.DriveLeftSideCommand;
import autoCommands.DriveRightSideCommand;
import autoCommands.DriveStraightPIDCommand;
import autoCommands.MoveWristTimeCommand;
import autoCommands.OpenClawCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class CenterSwitchLeftAutonomous extends CommandGroup {

    public CenterSwitchLeftAutonomous() {
    	addSequential(new CloseClawCommand());
        addSequential(new DriveRightSideCommand(22));
        addSequential(new DriveStraightPIDCommand(104));
        addSequential(new DriveLeftSideCommand(10));
        addParallel(new MoveWristTimeCommand(-.5, .6));
        addSequential(new OpenClawCommand());
        addSequential(new WaitCommand(.5));
        addSequential(new DriveLeftSideCommand(-24));
        addSequential(new DriveStraightPIDCommand(-84));
        addSequential(new DriveRightSideCommand(-28));
        addSequential(new DriveStraightPIDCommand(48));
    }
}
