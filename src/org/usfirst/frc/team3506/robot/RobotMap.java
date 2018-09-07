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
	public static final double WHEEL_DIAMETER = 5.875 / 12.0; // inches
	public static final double PULSES_PER_REVOLUTION = 2048;
	public static final double DISTANCE_PER_PULSE = Math.PI * WHEEL_DIAMETER / PULSES_PER_REVOLUTION;

	// Joysticks
	public static final int LEFT_JOYSTICK = 0;
	public static final int RIGHT_JOYSTICK = 1;
	public static final int SECONDARY_JOYSTICK = 2;

	// Drive train sparks
	public static final int LEFT_1_SPARK = 0;
	public static final int LEFT_2_SPARK = 1;
	public static final int LEFT_3_SPARK = 2;
	public static final int RIGHT_1_SPARK = 3;
	public static final int RIGHT_2_SPARK = 4;
	public static final int RIGHT_3_SPARK = 5;

	// Gyro port
	public static final int GYRO_PORT = 0;

	public static final double DRIVE_P = .8;
	public static final double DRIVE_I = .05;
	public static final double DRIVE_D = .01;

	// Elevator talons
	public static final int LEFT_ELEVATOR_TALON = 5;
	public static final int RIGHT_ELEVATOR_TALON = 6;

	// Elevator Speeds
	public static final double ELEVATOR_UP_SPEED = 1;
	public static final double ELEVATOR_DOWN_SPEED = -.75;
	public static final double ELEVATOR_STOP_SPEED = 0;

	// Flywheel talons
	public static final int LEFT_FLYWHEEL_TALON = 3;
	public static final int RIGHT_FLYWHEEL_TALON = 4;

	// Flywheel speeds
	public static final double FLYWHEEL_INTAKE_SPEED = 1;
	public static final double FLYWHEEL_OUTTAKE_SPEED = -.75;
	public static final double FLYWHEEL_STOP_SPEED = 0;
	public static final int CONTINUOUS_CURRENT_LIMIT= 20; // Amps
	public static final int PEAK_CURRENT_LIMIT= 35; // Amps
	public static final int PEAK_CURRENT_DURATION= 200; // ms

	// Wrist talon
	public static final int WRIST_TALON = 2;

	// Drive train solenoid
	public static final int[] DRIVE_TRAIN_SHIFT = { 6, 7 };

	// Clamp cube solenoid
	public static final int[] CLAMP_CUBE = { 0, 1 };

	// Encoders
	public static final int[] DRIVE_LEFT_ENCODER = { 1, 0 };
	public static final int[] DRIVE_RIGHT_ENCODER = { 2, 3 };
	public static final int[] WRIST_ENCODER = { 6, 7 };
	public static final int[] LIFT_ENCODER = { 4, 5 };

	// Pathfinder constants (inches)
	public static final double LOOP_TIME = .02;
	public static final double MAX_VELOCITY = 84;
	public static final double MAX_ACCELERATION = 96;
	public static final double MAX_JERK = 60;
	public static final double TRACK_WIDTH = 24;
	public static final double VELOCITY_TO_POWER_MOD = 1 / MAX_VELOCITY;
	public static final double ACCELERATION_GAIN = 0;
}
