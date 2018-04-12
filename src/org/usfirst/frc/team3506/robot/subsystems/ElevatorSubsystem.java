package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElevatorSubsystem extends Subsystem {

private Spark elevator;
	
	public ElevatorSubsystem() {
		//Creates an elevator motor object connected to its spark
		elevator = new Spark(RobotMap.ELEVATOR_SPARK);
		
		//Because of the way it was wired, the elevator motors will run in reverse
		elevator.setInverted(true);
	}

	//Moves the elevator up
	public void moveElevatorUp() {
		elevator.set(RobotMap.ELEVATOR_UP_SPEED);
	}
	
	//Moves the elevator down
	public void moveElevatorDown() {
		elevator.set(RobotMap.ELEVATOR_DOWN_SPEED);
	}
	
	//Tells the elevator to stop
	public void stopElevator() {
		elevator.set(RobotMap.ELEVATOR_STOP_SPEED);
	}
	
    public void initDefaultCommand() {
    }
}

