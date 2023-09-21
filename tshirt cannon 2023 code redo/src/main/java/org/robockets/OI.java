package org.robockets;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import org.robockets.commands.AjustShooterAngle;
import org.robockets.commands.RotateBarrel;
import org.robockets.commands.Shoot;
import org.robockets.commands.ShootThenRotate;

public class OI {

    public static Joystick joystick = new Joystick(0);

    public static JoystickButton a = new JoystickButton(joystick, 1);
    public static JoystickButton b = new JoystickButton(joystick, 2);
    public static JoystickButton x = new JoystickButton(joystick, 3);
    public static JoystickButton y = new JoystickButton(joystick, 4);
    JoystickButton lBumper = new JoystickButton(joystick, 5);
    JoystickButton rBumper = new JoystickButton(joystick, 6);
    JoystickButton select = new JoystickButton(joystick, 7);
    JoystickButton start = new JoystickButton(joystick, 8);

    public OI(){
        //TODO map buttons to actions
        lBumper.whenPressed(new Shoot());
        rBumper.whenPressed(new ShootThenRotate());
        b.whenPressed(new RotateBarrel(xDirection.LEFT));   // LEFT is actually the right button
        //x.whenPressed(new RotateBarrel(xDirection.RIGHT));  // RIGHT is actually the left button
        //a.whenActive(new AjustShooterAngle(zDirection.DOWN));
        //y.whenActive(new AjustShooterAngle(zDirection.UP));

        
    }

    


}
