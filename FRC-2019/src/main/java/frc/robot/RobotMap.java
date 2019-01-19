/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  public static TalonSRX DRIVETRAIN_LEFT1, DRIVETRAIN_LEFT2, DRIVETRAIN_RIGHT1, DRIVETRAIN_RIGHT2;
  public final static double MAX_VELOCITY = 1700;

  public static void init() {
    DRIVETRAIN_LEFT1 = new TalonSRX(0);
    DRIVETRAIN_LEFT1.setInverted(true);
    DRIVETRAIN_LEFT1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    DRIVETRAIN_LEFT1.setSensorPhase(true);
    DRIVETRAIN_LEFT1.config_kF(0, 1023 / MAX_VELOCITY);

    DRIVETRAIN_LEFT2 = new TalonSRX(1);
    DRIVETRAIN_LEFT2.setInverted(true);
    DRIVETRAIN_LEFT2.follow(DRIVETRAIN_LEFT1);

    DRIVETRAIN_RIGHT1 = new TalonSRX(2);
    DRIVETRAIN_RIGHT1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    DRIVETRAIN_RIGHT1.setSensorPhase(true);
    DRIVETRAIN_RIGHT1.config_kF(0, 1023 / MAX_VELOCITY);

    DRIVETRAIN_RIGHT2 = new TalonSRX(3);
    DRIVETRAIN_RIGHT2.follow(DRIVETRAIN_RIGHT1);
  }

  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
