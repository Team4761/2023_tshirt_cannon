package org.robockets.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import org.robockets.RobotMap;
import org.robockets.subsystems.Barrel;
import org.robockets.xDirection;


public class RotateBarrel extends CommandBase {

    private xDirection direction;
    private boolean started;
    private boolean ended;

    public RotateBarrel(xDirection direction) {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements();
        this.direction = direction;
    }

    @Override
    public void initialize() {
        started = true;
        ended = false;
    }

    @Override
    public void execute() {
        Barrel.rotate(direction);

        if (started) {
            started = !RobotMap.barrelLimitSwitch.get();
        } else {
            ended = !RobotMap.barrelLimitSwitch.get();
        }
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return ended;
    }

    @Override
    public void end(boolean interrupted) {
        Barrel.stop();
    }
}
