//Author Karl
package org.usfirst.frc.team4486.robot.commands;

import org.usfirst.frc.team4486.robot.Robot;
import org.usfirst.frc.team4486.robot.subsystems.Winch;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class WinchStop extends Command {
    public WinchStop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.winch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.winch.setSpeed(Winch.WINCH_STOP_SPEED);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
 
    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}