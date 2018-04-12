package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FlywheelSubsystem extends Subsystem {

private Spark flywheel;
	
	public FlywheelSubsystem() {
		//Creates a flywheel motor object connected to its spark
		flywheel = new Spark(RobotMap.FLYWHEEL_SPARK);
	}

	//Spins the motors to intake the cube
	public void intakeCube() {
		flywheel.set(RobotMap.FLYWHEEL_INTAKE_SPEED);
	}
	
	//Spins the motors to spit the cube
	public void outtakeCube() {
		flywheel.set(RobotMap.FLYWHEEL_OUTTAKE_SPEED);
	}
	
	//Stops the flywheels from spinning
	public void stopFlywheels() {
		flywheel.set(RobotMap.FLYWHEEL_STOP_SPEED);
	}
	
    public void initDefaultCommand() {
    }
}

