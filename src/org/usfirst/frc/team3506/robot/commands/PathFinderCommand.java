package org.usfirst.frc.team3506.robot.commands;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.DistanceFollower;
import jaci.pathfinder.modifiers.TankModifier;

/**
 *
 */
public class PathFinderCommand extends Command {

	private double leftPower, rightPower, angleDiff, turn;
	private Waypoint[] points;
	private Trajectory.Config config;
	private Trajectory trajectory;
	private TankModifier modifier;
	private DistanceFollower left;
	private DistanceFollower right;

	public PathFinderCommand() {
		requires(Robot.drivetrainSubsystem);
		points = new Waypoint[] {
    			//Replace these with real numbers
    			new Waypoint(-4, -1, Pathfinder.d2r(-45)),      // Waypoint @ x=-4, y=-1, exit angle=-45 degrees
    		    new Waypoint(-2, -2, 0),
    		    new Waypoint(0, 0, 0)
    	};
    	config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, RobotMap.LOOP_TIME, RobotMap.MAX_VELOCITY, RobotMap.MAX_ACCELERATION, RobotMap.MAX_JERK);
    	trajectory = Pathfinder.generate(points, config);
    	modifier = new TankModifier(trajectory).modify(RobotMap.TRACK_WIDTH);
    	left = new DistanceFollower(modifier.getLeftTrajectory());
    	right = new DistanceFollower(modifier.getRightTrajectory());
	}

	protected void initialize() {
		Robot.drivetrainSubsystem.resetEncoders();
		
    	left.configurePIDVA(RobotMap.DRIVE_P, RobotMap.DRIVE_I, RobotMap.DRIVE_D, RobotMap.VELOCITY_TO_POWER_MOD, RobotMap.ACCELERATION_GAIN);
    	right.configurePIDVA(RobotMap.DRIVE_P, RobotMap.DRIVE_I, RobotMap.DRIVE_D, RobotMap.VELOCITY_TO_POWER_MOD, RobotMap.ACCELERATION_GAIN);
	}

	protected void execute() {
    	leftPower = left.calculate((int) Robot.drivetrainSubsystem.getLeftEncoderDistance());
    	rightPower = right.calculate((int) Robot.drivetrainSubsystem.getRightEncoderDistance());
    	angleDiff = Pathfinder.boundHalfDegrees(Pathfinder.r2d(left.getHeading()) - Robot.drivetrainSubsystem.getHeading());
    	turn = .8 * (-1.0 / 80.0) * angleDiff;
    	Robot.drivetrainSubsystem.moveDriveTrainLeft(leftPower + turn);
    	Robot.drivetrainSubsystem.moveDriveTrainRight(rightPower - turn);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
