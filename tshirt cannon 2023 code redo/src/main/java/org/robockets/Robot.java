// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.robockets;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.WaitCommand;

import org.robockets.commands.DriveGo;
import org.robockets.subsystems.Barrel;
import org.robockets.subsystems.Drivetrain;
import org.robockets.subsystems.Shooter;
import edu.wpi.first.cameraserver.*;

/**
 * The VM is configured to automatically run this class, and to call the methods corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot
{
    private static final String DEFAULT_AUTO = "Default";
    private static final String CUSTOM_AUTO = "My Auto";
    private String autoSelected;
    private final SendableChooser<String> chooser = new SendableChooser<>();

    //Command and System Init.
    public static OI oi;
    public static Shooter shooter;
    public static Barrel barrel;
    public static Drivetrain drivetrain;
    //Command drivego;  //TODO find how to initialize properly

    
    
    /**
     * This method is run when the robot is first started up and should be used for any
     * initialization code.
     */
    @Override
    public void robotInit()
    {
        chooser.setDefaultOption("Default Auto", DEFAULT_AUTO);
        chooser.addOption("My Auto", CUSTOM_AUTO);
        SmartDashboard.putData("Auto choices", chooser);

        shooter = new Shooter();
        oi = new OI();
        drivetrain = new Drivetrain();
        barrel = new Barrel();
        //drivego = new DriveGo();
        
        CameraServer.startAutomaticCapture();
    }
    
    
    /**
     * This method is called every robot packet, no matter the mode. Use this for items like
     * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
     *
     * <p>This runs after the mode specific periodic methods, but before LiveWindow and
     * SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic() {
        SmartDashboard.putBoolean("Limit Switch", RobotMap.barrelLimitSwitch.get());
        CommandScheduler.getInstance().run();
    }
    
    
    /**
     * This autonomous (along with the chooser code above) shows how to select between different
     * autonomous modes using the dashboard. The sendable chooser code works with the Java
     * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
     * uncomment the getString line to get the auto name from the text box below the Gyro
     *
     * <p>You can add additional auto modes by adding additional comparisons to the switch structure
     * below with additional strings. If using the SendableChooser make sure to add them to the
     * chooser code above as well.
     */
    @Override
    public void autonomousInit()
    {
        autoSelected = chooser.getSelected();
        // autoSelected = SmartDashboard.getString("Auto Selector", DEFAULT_AUTO);
        System.out.println("Auto selected: " + autoSelected);
    }
    
    
    /** This method is called periodically during autonomous. */
    @Override
    public void autonomousPeriodic()
    {
        switch (autoSelected)
        {
            case CUSTOM_AUTO:
                // Put custom auto code here
                break;
            case DEFAULT_AUTO:
            default:
                // Put default auto code here
                break;
        }
    }
    
    
    /** This method is called once when teleop is enabled. */
    @Override
    public void teleopInit() {
        
    }
    
    double speedMultiplier = 0.5;
    double trans;
    double rot;
    double strafe;

    /** This method is called periodically during operator control. */

    boolean aPressed;
    boolean yPressed;
    double barrelSpeed = 0.2;

    @Override
    public void teleopPeriodic() {

        if (OI.joystick.getRawButtonReleased(4)) {
            yPressed = false;
        }
        if (OI.joystick.getRawButtonReleased(1)) {
            aPressed = false;
        }
        if (OI.joystick.getRawButtonPressed(4)) {
            yPressed = true;
        }
        if (OI.joystick.getRawButtonPressed(1)) {
            aPressed = true;
        }


        if (yPressed) {
            RobotMap.barrelAngleMotor.set(barrelSpeed);
        } else if (aPressed) {
            RobotMap.barrelAngleMotor.set(-barrelSpeed);
        } else {
            RobotMap.barrelAngleMotor.set(0);
        }

        trans = OI.joystick.getRawAxis(4);
        rot = OI.joystick.getRawAxis(1);
        strafe = 0;//OI.joystick.getRawAxis(0);
        RobotMap.robotDrive.driveCartesian(trans, strafe, rot);
    }
    
    
    /** This method is called once when the robot is disabled. */
    @Override
    public void disabledInit() {
        RobotMap.robotDrive.driveCartesian(0,0,0);
    }
    
    
    /** This method is called periodically when disabled. */
    @Override
    public void disabledPeriodic() {}
    
    
    /** This method is called once when test mode is enabled. */
    @Override
    public void testInit() {}
    
    
    /** This method is called periodically during test mode. */
    @Override
    public void testPeriodic() {}
}
