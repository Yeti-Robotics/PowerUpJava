/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3506.robot;

import org.usfirst.frc.team3506.robot.autoRoutines.CenterSwitchLeftAutonomous;
import org.usfirst.frc.team3506.robot.autoRoutines.CenterSwitchRightAutonomous;
import org.usfirst.frc.team3506.robot.autoRoutines.DriveForwardAutonomous;
import org.usfirst.frc.team3506.robot.autoRoutines.LeftSideLeftScaleAutonomous;
import org.usfirst.frc.team3506.robot.autoRoutines.LeftSideRightScaleAutonomous;
import org.usfirst.frc.team3506.robot.autoRoutines.RightSideLeftScaleAutonomous;
import org.usfirst.frc.team3506.robot.autoRoutines.RightSideRightScaleAutonomous;
import org.usfirst.frc.team3506.robot.subsystems.ClampCubeSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.ElevatorSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.FlywheelSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.LeftDrivetrainSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.RightDrivetrainSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.ShiftGearsSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.WristSubsystem;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This program goes out to Daddy Dean and Daddy Andy from AndyMark ez mani $$$
 * also cheezy poofs 435
 */
public class Robot extends TimedRobot {
	public static OI oi;

	// Instantiates the subsystems
	public static LeftDrivetrainSubsystem leftDrivetrainSubsystem;
	public static RightDrivetrainSubsystem rightDrivetrainSubsystem;
	public static DrivetrainSubsystem drivetrainSubsystem;
	public static ElevatorSubsystem elevatorSubsystem;
	public static FlywheelSubsystem flywheelSubsystem;
	public static WristSubsystem wristSubsystem;
	public static ShiftGearsSubsystem shiftGearsSubsystem;
	public static ClampCubeSubsystem clampCubeSubsystem;

	public SendableChooser autoChooser;

	public static enum AutoModes {
		DRIVE_FORWARD, CENTER_SWITCH, LEFT_SCALE, RIGHT_SCALE
	};

	// TODO: Auto
	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		leftDrivetrainSubsystem = new LeftDrivetrainSubsystem();
		rightDrivetrainSubsystem = new RightDrivetrainSubsystem();
		drivetrainSubsystem = new DrivetrainSubsystem();
		elevatorSubsystem = new ElevatorSubsystem();
		flywheelSubsystem = new FlywheelSubsystem();
		wristSubsystem = new WristSubsystem();
		shiftGearsSubsystem = new ShiftGearsSubsystem();
		clampCubeSubsystem = new ClampCubeSubsystem();
		oi = new OI();
		autoChooser = new SendableChooser();
		// chooser.addObject("My Auto", new MyAutoCommand());
		autoChooser.addDefault("Drive forward", AutoModes.DRIVE_FORWARD);
		autoChooser.addObject("Center switch", AutoModes.CENTER_SWITCH);
		autoChooser.addObject("Left side scale auto", AutoModes.LEFT_SCALE);
		autoChooser.addObject("Right side scale auto", AutoModes.RIGHT_SCALE);
		SmartDashboard.putData("Auto Chooser", autoChooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString code to get the
	 * auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons to
	 * the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage(); //gets game data
		
		switch ((AutoModes) autoChooser.getSelected()) {
		case CENTER_SWITCH:
			if (gameData.charAt(0) == 'L') {
				autonomousCommand = new CenterSwitchLeftAutonomous();
			}
			else {
				autonomousCommand = new CenterSwitchRightAutonomous(); //TODO: Create this auto
			}
			break;
		case LEFT_SCALE:
			if (gameData.charAt(1) == 'L') {
				autonomousCommand = new LeftSideLeftScaleAutonomous(); //TODO: Create this auto
			}
			else {
				autonomousCommand = new LeftSideRightScaleAutonomous(); //TODO: Create this auto
			}
			break;
		case RIGHT_SCALE:
			if (gameData.charAt(1) == 'L') {
				autonomousCommand = new RightSideLeftScaleAutonomous(); //TODO: Create this auto
			}
			else {
				autonomousCommand = new RightSideRightScaleAutonomous(); //TODO: Create this auto
			}
			break;
		default:
			autonomousCommand = new DriveForwardAutonomous();
		}

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		 * switch(autoSelected) { case "My Auto": autonomousCommand = new
		 * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
		 * ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		drivetrainSubsystem.printEncoders();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		drivetrainSubsystem.printEncoders();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
