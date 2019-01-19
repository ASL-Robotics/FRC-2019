/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DrivetrainVelocityDrive;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {

  private TalonSRX left, right;
  

  public Drivetrain() {
    left = RobotMap.DRIVETRAIN_LEFT1;
    right = RobotMap.DRIVETRAIN_RIGHT1;
  }

  public void velocityDrive(double x, double z) {

    double leftVelocity = (x + z) * RobotMap.MAX_VELOCITY;
    double rightVelocity = (x - z) * RobotMap.MAX_VELOCITY;

    left.set(ControlMode.Velocity, leftVelocity);
    right.set(ControlMode.Velocity, rightVelocity);

    System.out
        .println(left.getSelectedSensorVelocity() + "\t" + right.getSelectedSensorVelocity());

  }

  public void percentDrive(double x, double z) {

    left.set(ControlMode.PercentOutput, x + z);
    right.set(ControlMode.PercentOutput, x - z);
    
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DrivetrainVelocityDrive());
  }
}