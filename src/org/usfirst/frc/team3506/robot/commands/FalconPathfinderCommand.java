package org.usfirst.frc.team3506.robot.commands;


import org.usfirst.frc.team3506.robot.FalconPathPlanner;
import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FalconPathfinderCommand extends Command {
    
    double[][] waypoints;
    double totalTime;
    FalconPathPlanner path;
    int step;

    public FalconPathfinderCommand() {
        requires(Robot.drivetrainSubsystem);
        waypoints = new double[][] {
                {
                        20,
                        47.19
                },
                {
                        206.02,
                        47.19
                },
                {
                        233.02,
                        88.58
                },
                {
                        233.02,
                        229.71
                },
                {
                        271.76,
                        243.3
                }
        };
        totalTime = 10;
        path = new FalconPathPlanner(waypoints);
        step = 0;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        path.calculate(totalTime, RobotMap.LOOP_TIME, RobotMap.TRACK_WIDTH);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.drivetrainSubsystem.tankDrive(path.smoothLeftVelocity[step][1], path.smoothRightVelocity[step][1]);
        step++;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return step == path.numFinalPoints;
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
