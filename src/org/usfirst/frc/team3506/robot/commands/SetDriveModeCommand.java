package org.usfirst.frc.team3506.robot.commands;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystem.DriveMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetDriveModeCommand extends Command {

    private DriveMode driveMode;
    
    public SetDriveModeCommand(DriveMode driveMode) {
        this.driveMode = driveMode;
        requires(Robot.drivetrainSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.drivetrainSubsystem.setDriveMode(driveMode);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
