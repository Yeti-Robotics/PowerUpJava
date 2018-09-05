package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.MoveWristCommand;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WristSubsystem extends Subsystem {
	
	private WPI_TalonSRX wrist;
	
	public WristSubsystem() {
		//Creates a wrist motor object
		wrist = new WPI_TalonSRX(RobotMap.WRIST_TALON);
		
		wrist.setNeutralMode(NeutralMode.Brake);
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

