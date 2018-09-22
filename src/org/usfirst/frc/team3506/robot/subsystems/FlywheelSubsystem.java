package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.NeutralMode;
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
		rightFlywheel = new WPI_TalonSRX(RobotMap.RIGHT_FLYWHEEL_TALON);
		rightFlywheel.setInverted(true);
		
		//Enabling current limiting for left and right flywheel talons
		leftFlywheel.configContinuousCurrentLimit(RobotMap.FLYWHEEL_CONTINUOUS_CURRENT_LIMIT, 0);
		leftFlywheel.configPeakCurrentLimit(RobotMap.FLYWHEEL_PEAK_CURRENT_LIMIT, 0);
		leftFlywheel.configPeakCurrentDuration(RobotMap.FLYWHEEL_PEAK_CURRENT_DURATION, 0);
		leftFlywheel.enableCurrentLimit(true);
		
		rightFlywheel.configContinuousCurrentLimit(RobotMap.FLYWHEEL_CONTINUOUS_CURRENT_LIMIT, 0);
		rightFlywheel.configPeakCurrentLimit(RobotMap.FLYWHEEL_PEAK_CURRENT_LIMIT, 0);
		rightFlywheel.configPeakCurrentDuration(RobotMap.FLYWHEEL_PEAK_CURRENT_DURATION, 0);
		rightFlywheel.enableCurrentLimit(true);

        //Set the talons' neutral state to brake mode
		leftFlywheel.setNeutralMode(NeutralMode.Coast);
        rightFlywheel.setNeutralMode(NeutralMode.Coast);
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
    
    public void setCurrentLimiting(boolean currentLimit) {
        leftFlywheel.enableCurrentLimit(currentLimit);
        rightFlywheel.enableCurrentLimit(currentLimit);
    }
}

