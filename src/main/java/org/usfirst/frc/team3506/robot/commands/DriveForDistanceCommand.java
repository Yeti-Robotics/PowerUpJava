package org.usfirst.frc.team3506.robot.commands;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForDistanceCommand extends Command {
	
	private double distance, powerL, powerR;

    public DriveForDistanceCommand(double distance, double powerL, double powerR) {
    	requires(Robot.drivetrainSubsystem);
        this.distance = distance;
        this.powerL = powerL;
        this.powerR = powerR;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrainSubsystem.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		Robot.drivetrainSubsystem.tankDrive(powerL, powerR);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.drivetrainSubsystem.getAvgEncoderDistance() >= distance;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrainSubsystem.tankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
