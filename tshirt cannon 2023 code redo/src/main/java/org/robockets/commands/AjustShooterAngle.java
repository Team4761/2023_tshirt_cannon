package org.robockets.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import org.robockets.Robot;
import org.robockets.RobotMap;
import org.robockets.zDirection;


public class AjustShooterAngle extends CommandBase {

    private zDirection direction;

    public AjustShooterAngle(zDirection direction) {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements();
        this.direction = direction;
    }

    @Override
    public void initialize() {
        Robot.shooter.changeAngle(direction);
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
        
    }
}
