package org.usfirst.frc.team3506.robot.commands;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForwardWithEncoders extends Command {

	double distance, power;
	
    public DriveForwardWithEncoders(double distance, double power) {
    	this.distance = distance;
    	this.power = power;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	Robot.drivetrainSubsystem.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrainSubsystem.tankDrive(-power, -power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        if (distance <= ((Robot.leftDrivetrainSubsystem.getLeftEncoderValue() + Robot.leftDrivetrainSubsystem.getRightEncoderValue()) / 2)){
        	return true;
//        }
//        else {
//        	return false;
//        }
    }

    // Called once after isFinished returns true
    protected void end() {
//    	Robot.leftDrivetrainSubsystem.tankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
