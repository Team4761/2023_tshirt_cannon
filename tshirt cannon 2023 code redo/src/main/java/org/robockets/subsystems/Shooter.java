package org.robockets.subsystems;


import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.robockets.RobotMap;
import org.robockets.zDirection;

public class Shooter extends SubsystemBase {

    // With eager singleton initialization, any static variables/fields used in the 
    // constructor must appear before the "INSTANCE" variable so that they are initialized 
    // before the constructor is called when the "INSTANCE" variable initializes.

    /**
     * The Singleton instance of this Shooter. Code should use
     * the {@link #getInstance()} method to get the single instance (rather
     * than trying to construct an instance of this class.)
     */
    private final static Shooter INSTANCE = new Shooter();

    /**
     * Returns the Singleton instance of this Shooter. This static method
     * should be used, rather than the constructor, to get the single instance
     * of this class. For example: {@code Shooter.getInstance();}
     */
    @SuppressWarnings("WeakerAccess")
    public static Shooter getInstance() {
        return INSTANCE;
    }

    /**
     * Creates a new instance of this Shooter. This constructor
     * is private since this class is a Singleton. Code should use
     * the {@link #getInstance()} method to get the singleton instance.
     */
    public Shooter() {
        // TODO: Set the default command, if any, for this subsystem by calling setDefaultCommand(command)
        //       in the constructor or in the robot coordination class, such as RobotContainer.
        //       Also, you can call addChild(name, sendableChild) to associate sendables with the subsystem
        //       such as SpeedControllers, Encoders, DigitalInputs, etc.
    }

    public void shoot(Solenoid solenoid){
        solenoid.set(true);
        System.out.println("Shot method called...");
    }

    public void changeAngle(zDirection direction){
        if(direction == zDirection.UP){
            System.out.println("UP!");
            RobotMap.barrelAngleMotor.set(0.5);
        }else if(direction == zDirection.DOWN){
            System.out.println("DOWN!");
            RobotMap.barrelAngleMotor.set(-0.5);
        }else{
            System.out.println("running");
            RobotMap.barrelAngleMotor.set(0);
        }
    }

    public void stop(Solenoid solenoid){
        solenoid.set(false);
        System.out.println("Solenoid closed...");
        //RobotMap.barrelAngleMotor.set(0);
    }
}

