package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShiftGearsSubsystem extends Subsystem {

	private DoubleSolenoid shifter;
	
	public ShiftGearsSubsystem() {
		//Creates a shifter object connected to its respective solenoid
		shifter = new DoubleSolenoid(RobotMap.DRIVE_TRAIN_SHIFT[0], RobotMap.DRIVE_TRAIN_SHIFT[1]);
	}
	
	//Shifts the drive train into high gear
	public void shiftUp() {
		shifter.set(Value.kForward);
	}
	
	//Shifts the drive train into low gear
	public void shiftDown() {
		shifter.set(Value.kReverse);
	}
	
	//Finds out what position the shifter is currently in
	public Value getShifterPosition() {
		return shifter.get();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

