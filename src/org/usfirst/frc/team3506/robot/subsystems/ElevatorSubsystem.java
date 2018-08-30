package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElevatorSubsystem extends Subsystem {

private WPI_TalonSRX leftElevator, rightElevator;
	
	public ElevatorSubsystem() {
		//Creates an elevator motor object connected to its spark
	    leftElevator = new WPI_TalonSRX(RobotMap.LEFT_ELEVATOR_TALON);
		rightElevator = new WPI_TalonSRX(RobotMap.RIGHT_ELEVATOR_TALON);
		
		//Because of the way it was wired, the elevator motors will run in reverse
		leftElevator.setInverted(true);
		rightElevator.setInverted(true);
	}

	//Moves the elevator up
	public void moveElevatorUp() {
	    leftElevator.set(RobotMap.ELEVATOR_UP_SPEED);
	    rightElevator.set(RobotMap.ELEVATOR_UP_SPEED);
	}
	
	//Moves the elevator down
	public void moveElevatorDown() {
	    leftElevator.set(RobotMap.ELEVATOR_DOWN_SPEED);
	    rightElevator.set(RobotMap.ELEVATOR_DOWN_SPEED);
	}
	
	//Tells the elevator to stop
	public void stopElevator() {
	    leftElevator.set(RobotMap.ELEVATOR_STOP_SPEED);
	    rightElevator.set(RobotMap.ELEVATOR_STOP_SPEED);
	}
	
    public void initDefaultCommand() {
    }
}

