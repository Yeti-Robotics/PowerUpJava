/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3506.robot;

/**
 * I would like to pray to Daddy Dean and Daddy Andy for granting us this
 * glorious opportunity I would like to thank team 435 the Robodogs for helping
 * me through this
 */
public class RobotMap {
	// Physical Constants
	public static final int WHEEL_DIAMETER = 6; // inches
	public static final double PULSES_PER_REVOLUTION = 2048;
	public static final double DISTANCE_PER_PULSE = Math.PI * WHEEL_DIAMETER / PULSES_PER_REVOLUTION;

	// Joysticks
	public static final int LEFT_JOYSTICK = 0;
	public static final int RIGHT_JOYSTICK = 1;
	public static final int SECONDARY_JOYSTICK = 2;

	// Drive train sparks
	public static final int LEFT_1_SPARK = 0;
	public static final int LEFT_2_SPARK = 7;
	public static final int RIGHT_1_SPARK = 1;
	public static final int RIGHT_2_SPARK = 9;

	// Gyro port
	public static final int GYRO_PORT = 0;

	public static final double DRIVE_P = .8;
	public static final double DRIVE_I = .05;
	public static final double DRIVE_D = .01;

	// Elevator sparks
	public static final int ELEVATOR_SPARK = 5;

	// Elevator Speeds
	public static final double ELEVATOR_UP_SPEED = 1;
	public static final double ELEVATOR_DOWN_SPEED = -.75;
	public static final double ELEVATOR_STOP_SPEED = 0;

	// Flywheel sparks
	public static final int FLYWHEEL_SPARK = 3;

	// Flywheel speeds
	public static final double FLYWHEEL_INTAKE_SPEED = 1;
	public static final double FLYWHEEL_OUTTAKE_SPEED = -.75;
	public static final double FLYWHEEL_STOP_SPEED = 0;

	// Wrist sparks
	public static final int WRIST_SPARK = 2;

	// Drive train solenoid
	public static final int[] DRIVE_TRAIN_SHIFT = { 6, 7 };

	// Clamp cube solenoid
	public static final int[] CLAMP_CUBE = { 0, 1 };

	// Encoders
	public static final int[] DRIVE_LEFT_ENCODER = { 1, 0 };
	public static final int[] DRIVE_RIGHT_ENCODER = { 2, 3 };
	public static final int[] WRIST_ENCODER = { 6, 7 };
	public static final int[] LIFT_ENCODER = { 4, 5 };

	// Pathfinder constants
	public static final double LOOP_TIME = .05;
	public static final double MAX_VELOCITY = 1.2;
	public static final double MAX_ACCELERATION = 2;
	public static final double MAX_JERK = 10;
	public static final double TRACK_WIDTH = 24;
	public static final double VELOCITY_TO_POWER_MOD = 1 / MAX_VELOCITY;
	public static final double ACCELERATION_GAIN = 0;
}
