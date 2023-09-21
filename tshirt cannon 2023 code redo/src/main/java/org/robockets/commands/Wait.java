package org.robockets.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;


public class Wait extends CommandBase {

    public Wait() {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements();
    }

    @Override
    public void initialize() {
        //try {
            //wait(100); //DEPRECATED
            new WaitCommand(0.1);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
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
