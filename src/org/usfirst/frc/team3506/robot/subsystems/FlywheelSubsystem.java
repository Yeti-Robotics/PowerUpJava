package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FlywheelSubsystem extends Subsystem {

private WPI_TalonSRX leftFlywheel, rightFlywheel;
	
	public FlywheelSubsystem() {
		//Creates a flywheel motor object connected to its spark
	    leftFlywheel = new WPI_TalonSRX(RobotMap.LEFT_FLYWHEEL_TALON);
		rightFlywheel = new WPI_TalonSRX(RobotMap.LEFT_FLYWHEEL_TALON);
	}

	//Spins the motors to intake the cube
	public void intakeCube() {
	    leftFlywheel.set(RobotMap.FLYWHEEL_INTAKE_SPEED);
	    rightFlywheel.set(RobotMap.FLYWHEEL_INTAKE_SPEED);
	}
	
	//Spins the motors to spit the cube
	public void outtakeCube() {
	    leftFlywheel.set(RobotMap.FLYWHEEL_OUTTAKE_SPEED);
	    rightFlywheel.set(RobotMap.FLYWHEEL_OUTTAKE_SPEED);
	}
	
	//Stops the flywheels from spinning
	public void stopFlywheels() {
	    leftFlywheel.set(RobotMap.FLYWHEEL_STOP_SPEED);
	    rightFlywheel.set(RobotMap.FLYWHEEL_STOP_SPEED);
	}
	
    public void initDefaultCommand() {
    }
}

