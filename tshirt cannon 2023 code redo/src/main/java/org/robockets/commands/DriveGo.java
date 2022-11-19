package org.robockets.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import org.robockets.OI;
import org.robockets.Robot;


public class DriveGo extends CommandBase {


    double trans;
    double rot;
    double strafe;

    public DriveGo() {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements();
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        trans = OI.joystick.getRawAxis(1);
        rot = OI.joystick.getRawAxis(4);
        strafe = OI.joystick.getRawAxis(0);

        Robot.drivetrain.driveMecanum(trans, rot, strafe);
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.drivetrain.stop();
    }
}
