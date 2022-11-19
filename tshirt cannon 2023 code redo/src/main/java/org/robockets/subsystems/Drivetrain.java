package org.robockets.subsystems;


import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.robockets.RobotMap;

public class Drivetrain extends SubsystemBase {

    public static final double DEFAULT_SPEED = 0.75;

    // With eager singleton initialization, any static variables/fields used in the 
    // constructor must appear before the "INSTANCE" variable so that they are initialized 
    // before the constructor is called when the "INSTANCE" variable initializes.

    /**
     * The Singleton instance of this Drivetrain. Code should use
     * the {@link #getInstance()} method to get the single instance (rather
     * than trying to construct an instance of this class.)
     */
    private final static Drivetrain INSTANCE = new Drivetrain();

    /**
     * Returns the Singleton instance of this Drivetrain. This static method
     * should be used, rather than the constructor, to get the single instance
     * of this class. For example: {@code Drivetrain.getInstance();}
     */
    @SuppressWarnings("WeakerAccess")
    public static Drivetrain getInstance() {
        return INSTANCE;
    }

    /**
     * Creates a new instance of this Drivetrain. This constructor
     * is private since this class is a Singleton. Code should use
     * the {@link #getInstance()} method to get the singleton instance.
     */
    public Drivetrain() {
        // TODO: Set the default command, if any, for this subsystem by calling setDefaultCommand(command)
        //       in the constructor or in the robot coordination class, such as RobotContainer.
        //       Also, you can call addChild(name, sendableChild) to associate sendables with the subsystem
        //       such as SpeedControllers, Encoders, DigitalInputs, etc.
    }

    public void driveMecanum(double trans, double rot, double strafe){
        //double speedMultiplier = SmartDashboard.getNumber("Driving Speed", DEFAULT_SPEED);
        double speedMultiplier = 0.5;
        RobotMap.robotDrive.driveCartesian(trans * speedMultiplier, rot * speedMultiplier, strafe * speedMultiplier);
    }

    public void stop(){
        RobotMap.robotDrive.driveCartesian(0,0,0);
    }

   /* public void driveTank(double left, double right){
        //double speedMultiplier = SmartDashboard.getNumber("Driving Speed", DEFAULT_SPEED);
        double speedMultiplier = 0.5;
        RobotMap.robotDrive.tankDrive(left * speedMultiplier, right * speedMultiplier);
    }

    */
}

