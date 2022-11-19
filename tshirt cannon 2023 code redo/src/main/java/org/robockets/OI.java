package org.robockets;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import org.robockets.commands.AjustShooterAngle;
import org.robockets.commands.RotateBarrel;
import org.robockets.commands.Shoot;
import org.robockets.commands.ShootThenRotate;

public class OI {

    public static Joystick joystick = new Joystick(0);

    JoystickButton a = new JoystickButton(joystick, 1);
    JoystickButton b = new JoystickButton(joystick, 2);
    JoystickButton x = new JoystickButton(joystick, 3);
    JoystickButton y = new JoystickButton(joystick, 4);
    JoystickButton lBumper = new JoystickButton(joystick, 5);
    JoystickButton rBumper = new JoystickButton(joystick, 6);
    JoystickButton select = new JoystickButton(joystick, 7);
    JoystickButton start = new JoystickButton(joystick, 8);

    public OI(){
        //TODO map buttons to actions
        lBumper.whenPressed(new Shoot());
        rBumper.whenPressed(new ShootThenRotate());
        x.whenPressed(new RotateBarrel(xDirection.LEFT));
        b.whenPressed(new RotateBarrel(xDirection.RIGHT));
        a.whenActive(new AjustShooterAngle(zDirection.DOWN));
        b.whenActive(new AjustShooterAngle(zDirection.UP));

        
    }

    


}
