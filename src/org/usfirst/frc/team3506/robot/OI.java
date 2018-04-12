/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3506.robot;

import org.usfirst.frc.team3506.robot.commands.DriveTrainHighShift;
import org.usfirst.frc.team3506.robot.commands.DriveTrainLowShift;
import org.usfirst.frc.team3506.robot.commands.FlywheelIntakeCommand;
import org.usfirst.frc.team3506.robot.commands.FlywheelOuttakeCommand;
import org.usfirst.frc.team3506.robot.commands.LowerElevatorCommand;
import org.usfirst.frc.team3506.robot.commands.RaiseElevatorCommand;
import org.usfirst.frc.team3506.robot.commands.ToggleCubeClamp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick leftJoy, rightJoy, secondaryJoy; //what is joyful about robots...
	
	public OI() {
		//Creates joystick objects for use
		leftJoy = new Joystick(RobotMap.LEFT_JOYSTICK);
		rightJoy = new Joystick(RobotMap.RIGHT_JOYSTICK);
		secondaryJoy = new Joystick(RobotMap.SECONDARY_JOYSTICK);
		
		//Sets each task to a button
		setJoystickButtonWhilePressedCommand(secondaryJoy, 5, new RaiseElevatorCommand());
		setJoystickButtonWhilePressedCommand(secondaryJoy, 3, new LowerElevatorCommand());
		setJoystickButtonWhilePressedCommand(secondaryJoy, 1, new FlywheelIntakeCommand());
		setJoystickButtonWhilePressedCommand(secondaryJoy, 2, new FlywheelOuttakeCommand());
		setJoystickButtonWhenPressedCommand(leftJoy, 1, new DriveTrainLowShift());
		setJoystickButtonWhenPressedCommand(rightJoy, 1, new DriveTrainHighShift());
		setJoystickButtonWhenPressedCommand(secondaryJoy, 4, new ToggleCubeClamp());
	}
	
	//Gets the Y direction of the left drive joystick
	public double getLeftY() {
		return leftJoy.getY();
	}
	
	//Gets the Y direction of the right drive joystick
	public double getRightY() {
		return rightJoy.getY();
	}
	
	//Gets the Y direction of the secondary joystick
	public double getSecondaryY() {
		return secondaryJoy.getY();
	}
	
	private void setJoystickButtonWhenPressedCommand(Joystick joystick, int button, Command command) {
		new JoystickButton(joystick, button).whenPressed(command);
	}

	private void setJoystickButtonWhilePressedCommand(Joystick joystick, int button, Command command) {
		new JoystickButton(joystick, button).whileHeld(command);
	}
}
