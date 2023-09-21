package org.robockets.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import org.robockets.Robot;
import org.robockets.RobotMap;


public class Shoot extends CommandBase {

    public Shoot() {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements();
    }

    private long endTime = 0;
    @Override
    public void initialize() {
        Robot.shooter.shoot(RobotMap.solenoid);
        endTime = System.currentTimeMillis() + 100; // Go for 100 milliseconds
        //TODO ?? does this need to be here or not?
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        //new WaitCommand(0.1);
        if (endTime <= System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("shot finished.");
        Robot.shooter.stop(RobotMap.solenoid);
    }
}
