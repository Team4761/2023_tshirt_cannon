package org.robockets.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.robockets.RobotMap;
import org.robockets.xDirection;

public class Barrel extends SubsystemBase {

    // With eager singleton initialization, any static variables/fields used in the 
    // constructor must appear before the "INSTANCE" variable so that they are initialized 
    // before the constructor is called when the "INSTANCE" variable initializes.

    /**
     * The Singleton instance of this Barrel. Code should use
     * the {@link #getInstance()} method to get the single instance (rather
     * than trying to construct an instance of this class.)
     */
    private final static Barrel INSTANCE = new Barrel();

    /**
     * Returns the Singleton instance of this Barrel. This static method
     * should be used, rather than the constructor, to get the single instance
     * of this class. For example: {@code Barrel.getInstance();}
     */
    @SuppressWarnings("WeakerAccess")
    public static Barrel getInstance() {
        return INSTANCE;
    }

    /**
     * Creates a new instance of this Barrel. This constructor
     * is private since this class is a Singleton. Code should use
     * the {@link #getInstance()} method to get the singleton instance.
     */
    public Barrel() {
        // TODO: Set the default command, if any, for this subsystem by calling setDefaultCommand(command)
        //       in the constructor or in the robot coordination class, such as RobotContainer.
        //       Also, you can call addChild(name, sendableChild) to associate sendables with the subsystem
        //       such as SpeedControllers, Encoders, DigitalInputs, etc.
    }

    public static void rotate(xDirection direction){
        if(direction == xDirection.LEFT){
            RobotMap.barrelRotationMotor.set(0.7);
        }else if (direction == xDirection.RIGHT){
            RobotMap.barrelRotationMotor.set(-0.7);
        }else{
            RobotMap.barrelRotationMotor.set(0);
        }
    }

    public static void stop(){
        RobotMap.barrelRotationMotor.set(0);
    }
}

