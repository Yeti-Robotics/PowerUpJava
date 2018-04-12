package autoCommands;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PivotPIDCommand extends Command {

	private double distance;
	private boolean turnClockwise;
	
    public PivotPIDCommand(double distance, boolean turnClockwise) {
        requires(Robot.drivetrainSubsystem);
        this.distance = distance;
        this.turnClockwise = turnClockwise;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrainSubsystem.resetEncoders();

    	if (turnClockwise) {
			Robot.leftDrivetrainSubsystem.setSetpoint(distance);
			Robot.rightDrivetrainSubsystem.setSetpoint(-distance);
		} else {
			Robot.leftDrivetrainSubsystem.setSetpoint(-distance);
			Robot.rightDrivetrainSubsystem.setSetpoint(distance);
		}
		Robot.leftDrivetrainSubsystem.enable();
    	Robot.rightDrivetrainSubsystem.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.leftDrivetrainSubsystem.onTarget() && Robot.rightDrivetrainSubsystem.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.leftDrivetrainSubsystem.disable();
    	Robot.rightDrivetrainSubsystem.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
