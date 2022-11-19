package org.robockets;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Victor;

public class RobotMap {

    //Motors
    public static Victor frontLeft = new Victor(0);
    public static Victor frontRight = new Victor(1);
    public static Victor backLeft = new Victor(2);
    public static Victor backRight = new Victor(3);

    //Motor Combo's
    public static MotorControllerGroup left = new MotorControllerGroup(frontLeft, backLeft);
    public static MotorControllerGroup right = new MotorControllerGroup(frontRight, backRight);

    //Final Drivetrain
    public static MecanumDrive robotDrive = new MecanumDrive(frontLeft, backLeft,frontRight,backRight);

    //Barrel shit
    public static Victor barrelRotationMotor = new Victor(4);
    public static Victor barrelAngleMotor = new Victor(5);

    //Solenoid
    //TODO Fix! may not work i have no idea what "Module type" is
    public static Solenoid solenoid = new Solenoid(null, 0);

    //limit switch
    public static DigitalInput barrelLimitSwitch = new DigitalInput(4);



}
