package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.MoveWristCommand;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WristSubsystem extends Subsystem {
	
	private Spark wrist;
	
	public WristSubsystem() {
		//Creates a wrist motor object
		wrist = new Spark(RobotMap.WRIST_SPARK);
	}
	
	//Allows variable movement using a joystick
	public void joystickControl(double power) {
		wrist.set(power);
	}
	
	//Always keeps this running
    public void initDefaultCommand() {
    	setDefaultCommand(new MoveWristCommand());
    }
}

