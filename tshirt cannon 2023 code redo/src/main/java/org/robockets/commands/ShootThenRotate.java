package org.robockets.commands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import org.robockets.xDirection;

public class ShootThenRotate extends SequentialCommandGroup {
    public ShootThenRotate() {
        // TODO: Add your sequential commands in the super() call, e.g.
        //           super(new FooCommand(), new BarCommand());
        super(new Shoot(), new Wait(), new RotateBarrel(xDirection.LEFT));
    }
}