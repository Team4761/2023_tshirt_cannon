package org.robockets.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import org.robockets.Robot;
import org.robockets.RobotMap;


public class Shoot extends CommandBase {

    public Shoot() {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements();
    }

    @Override
    public void initialize() {
        Robot.shooter.shoot(RobotMap.solenoid);
        new Wait();
        //TODO ?? does this need to be here or not?
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return true;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.shooter.stop(RobotMap.solenoid);
    }
}
