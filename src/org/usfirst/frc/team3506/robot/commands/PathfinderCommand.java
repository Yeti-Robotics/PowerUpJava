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
public class PathfinderCommand extends Command {

	private double leftPower, rightPower, angleDiff, turn;
	private Waypoint[] points;
	private Trajectory.Config config;
	private Trajectory trajectory;
	private TankModifier modifier;
	private DistanceFollower left;
	private DistanceFollower right;

	public PathfinderCommand() {
		requires(Robot.drivetrainSubsystem);
		points = new Waypoint[] {
    			//Replace these with real numbers
                new Waypoint(20, 47.19, Pathfinder.d2r(0)),
                new Waypoint(206.02, 47.19, Pathfinder.d2r(0)),
                new Waypoint(233.02, 88.58, Pathfinder.d2r(90)),
                new Waypoint(233.02, 229.71, Pathfinder.d2r(90)),
                new Waypoint(271.76, 243.3, Pathfinder.d2r(0))
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
//    	angleDiff = Pathfinder.boundHalfDegrees(Pathfinder.r2d(left.getHeading()) - Robot.drivetrainSubsystem.getHeading());
//    	turn = .8 * (-1.0 / 80.0) * angleDiff;
//    	Robot.drivetrainSubsystem.tankDrive(leftPower + turn, rightPower - turn);
    	Robot.drivetrainSubsystem.tankDrive(leftPower, rightPower);
	}

	protected boolean isFinished() {
		return left.isFinished() && right.isFinished();
	}

	protected void end() {
	    Robot.drivetrainSubsystem.tankDrive(0, 0);
	}

	protected void interrupted() {
	    end();
	}
}
