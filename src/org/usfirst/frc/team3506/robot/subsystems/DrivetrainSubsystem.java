package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.UserDriveCommand;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DrivetrainSubsystem extends Subsystem {

	private Spark left1, left2, right1, right2;
	private Encoder leftEnc, rightEnc;
	public double leftMaxRate = 0;
	public double rightMaxRate = 0;
	AnalogGyro gyro;

	public DrivetrainSubsystem() {
		// Creates motor objects connected to their corresponding sparks
		left1 = new Spark(RobotMap.LEFT_1_SPARK);
		left2 = new Spark(RobotMap.LEFT_2_SPARK);
		right1 = new Spark(RobotMap.RIGHT_1_SPARK);
		right2 = new Spark(RobotMap.RIGHT_2_SPARK);
		
		gyro = new AnalogGyro(RobotMap.GYRO_PORT);
		gyro.calibrate();

		// Creates encoder objects connected to their respective DIO ports
		leftEnc = new Encoder(RobotMap.DRIVE_LEFT_ENCODER[0], RobotMap.DRIVE_LEFT_ENCODER[1], true, EncodingType.k4X);
		rightEnc = new Encoder(RobotMap.DRIVE_RIGHT_ENCODER[0], RobotMap.DRIVE_RIGHT_ENCODER[1], true,
				EncodingType.k4X);

		leftEnc.setDistancePerPulse(RobotMap.DISTANCE_PER_PULSE);
		leftEnc.setPIDSourceType(PIDSourceType.kDisplacement);
		rightEnc.setDistancePerPulse(RobotMap.DISTANCE_PER_PULSE);
		rightEnc.setPIDSourceType(PIDSourceType.kDisplacement);

		left2.setInverted(true);
		right1.setInverted(true);
	}

	// Resets the encoder values
	public void resetEncoders() {
		rightEnc.reset();
		leftEnc.reset();
	}

	// Prints drive encoder values to the console
	public void printEncoders() {
		SmartDashboard.putNumber("Right drive distance", getRightEncoderDistance());
		SmartDashboard.putNumber("Left drive distance", getLeftEncoderDistance());
		SmartDashboard.putNumber("Right drive velocity", getRightEncoderRate());
		SmartDashboard.putNumber("Left drive velocity", getLeftEncoderRate());
	}

	public double getRightEncoderDistance() {
		return rightEnc.getDistance();
	}

	public double getLeftEncoderDistance() {
		return leftEnc.getDistance();
	}
	
	public double getLeftEncoderRate() {
		return leftEnc.getRate();
	}
	
	public double getRightEncoderRate() {
		return rightEnc.getRate();
	}

	// Controls the right side of the drive train
	public void moveDriveTrainRight(double power) {
		right1.set(power);
		right2.set(power);
	}

	// Controls the left side of the drive train
	public void moveDriveTrainLeft(double power) {
		left1.set(power);
		left2.set(power);
	}

	public void tankDrive(double left, double right) {
		moveDriveTrainLeft(left);
		moveDriveTrainRight(right);
	}
	
	public double getHeading() {
		return gyro.getAngle();
	}

	public void initDefaultCommand() {
		setDefaultCommand(new UserDriveCommand());
	}
}
