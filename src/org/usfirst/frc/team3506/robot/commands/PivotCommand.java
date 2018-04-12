package org.usfirst.frc.team3506.robot.commands;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PivotCommand extends Command {

	private double distance, power;
	private boolean turnClockwise;
	
    public PivotCommand(double distance, double power, boolean turnClockwise) {
        requires(Robot.drivetrainSubsystem);
        this.distance = distance;
        this.power = power;
        this.turnClockwise = turnClockwise;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrainSubsystem.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (turnClockwise) {
    		Robot.drivetrainSubsystem.tankDrive(power, -power);
    	} else {
    		Robot.drivetrainSubsystem.tankDrive(-power, power);
    	}
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
    	end();
    }
}
