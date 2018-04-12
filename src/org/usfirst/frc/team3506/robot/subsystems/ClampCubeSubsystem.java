package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClampCubeSubsystem extends Subsystem {

private DoubleSolenoid shifter;
	
	public ClampCubeSubsystem() {
		//Creates a shifter object connected to the respective solenoid
		shifter = new DoubleSolenoid(RobotMap.CLAMP_CUBE[0], RobotMap.CLAMP_CUBE[1]);
	}
	
	//Clamps the pistons
	public void clampPistons() {
		shifter.set(Value.kForward);
	}
	
	//Unclamps the pistons
	public void unclampPistons() {
		shifter.set(Value.kReverse);
	}
	
	//Finds out what position the solenoid is in
	public Value getPistonPosition() {
		return shifter.get();
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

