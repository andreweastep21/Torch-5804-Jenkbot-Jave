/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//Hardware imports:
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.playingwithfusion.TimeOfFlight;
import com.playingwithfusion.TimeOfFlight.RangingMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

//Other imports:
import edu.wpi.first.wpilibj.Timer;

import frc.robot.JoystickButtons;

import edu.wpi.first.wpilibj.TimedRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  
  WPI_TalonSRX driveTalonLeft = new WPI_TalonSRX(1);
  WPI_TalonSRX driveTalonLeftFollow = new WPI_TalonSRX(2);
  WPI_TalonSRX driveTalonLeftFollow2 = new WPI_TalonSRX(3);
  WPI_TalonSRX driveTalonRight = new WPI_TalonSRX(4);
  WPI_TalonSRX driveTalonRightFollow = new WPI_TalonSRX(5);
  WPI_TalonSRX driveTalonRightFollow2 = new WPI_TalonSRX(6);
  //idk how to instantiate SpeedController, SpeedController constructor doesn't exist
  SpeedControllerGroup leftMotors = new SpeedControllerGroup(driveTalonLeft, driveTalonLeftFollow);
  SpeedControllerGroup rightMotors = new SpeedControllerGroup(driveTalonRight, driveTalonRightFollow);

  RobotDrive twoMotorDrive = new RobotDrive(leftMotors, rightMotors);



  //Joystick:
  Joystick leftStick = new Joystick(0);
  Joystick rightStick = new Joystick(1);
  
  //Solenoid:
  Solenoid coolSolenoid = new Solenoid(0);

  //Compressor:
  Compressor compressor = new Compressor(0);
  
 
  //button variables:

  boolean leftTrigger = leftStick.getRawButton(0);
  boolean rightTrigger = rightStick.getRawButton(0);

  boolean leftThumbMain = leftStick.getRawButton(1);
  boolean rightThumbMain = rightStick.getRawButton(1);

  boolean leftThumbLeft = leftStick.getRawButton(2);
  boolean rightThumbLeft = rightStick.getRawButton(2);

  boolean leftThumbRight = leftStick.getRawButton(3);
  boolean rightThumbRight = rightStick.getRawButton(3);

  boolean leftRightArrayTR = leftStick.getRawButton(4);
  boolean rightRightArrayTR = rightStick.getRawButton(4);

  boolean leftRightArrayTM = leftStick.getRawButton(5);
  boolean rightRightArrayTM = rightStick.getRawButton(5);

  boolean leftRightArrayTL = leftStick.getRawButton(6);
  boolean rightRightArrayTL = rightStick.getRawButton(6);

  boolean leftRightArrayBL = leftStick.getRawButton(7);
  boolean rightRightArrayBL = rightStick.getRawButton(7);

  boolean leftRightArrayBM = leftStick.getRawButton(8);
  boolean rightRightArrayBM = rightStick.getRawButton(8);

  boolean leftRightArrayBR = leftStick.getRawButton(9);
  boolean rightRightArrayBR = rightStick.getRawButton(9);

  boolean leftLeftArrayTL = leftStick.getRawButton(10);
  boolean rightLeftArrayTL = rightStick.getRawButton(10);

  boolean leftLeftArrayTM = leftStick.getRawButton(11);
  boolean rightLeftArrayTM = rightStick.getRawButton(11);

  boolean leftLeftArrayTR = leftStick.getRawButton(12);
  boolean rightLeftArrayTR = rightStick.getRawButton(12);

  boolean leftLeftArrayBR = leftStick.getRawButton(13);
  boolean rightLeftArrayBR = rightStick.getRawButton(13);

  boolean leftLeftArrayBM = leftStick.getRawButton(14);
  boolean rightLeftArrayBM = rightStick.getRawButton(14);

  boolean leftLeftArrayBL = leftStick.getRawButton(15);
  boolean rightLeftArrayBL = rightStick.getRawButton(15);

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
  //Talon Drive Setup
  
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    driveTalonLeftFollow.follow(driveTalonLeft);
    driveTalonLeftFollow2.follow(driveTalonLeft);
    driveTalonRightFollow.follow(driveTalonRight);
    driveTalonRightFollow2.follow(driveTalonRight);
  }

  @Override
  public void teleopPeriodic() {
    if (leftThumbRight){
      driveTalonLeft.set(ControlMode.PercentOutput, 0.5);
      driveTalonRight.set(ControlMode.PercentOutput, 0.5);
    }
      else {
        driveTalonLeft.set(ControlMode.PercentOutput,0);
        driveTalonRight.set(ControlMode.PercentOutput,0);
      }
    
  

  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
