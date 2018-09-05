package org.usfirst.frc.team3506.robot.commands;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UserDriveCommand extends Command {

    public UserDriveCommand() {
    	requires(Robot.drivetrainSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	switch (Robot.drivetrainSubsystem.getDriveMode()) {
    	    case TANK: 
    	        Robot.drivetrainSubsystem.tankDrive(Robot.oi.getLeftY(), Robot.oi.getRightY());
    	     break;  
    	    case ARCADE: 
                Robot.drivetrainSubsystem.arcadeDrive(Robot.oi.getLeftY(), Robot.oi.getRightX());
             break;   
    	    case CHEEZY: 
                Robot.drivetrainSubsystem.cheezyDrive(Robot.oi.getLeftY(), Robot.oi.getRightX());
             break;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
