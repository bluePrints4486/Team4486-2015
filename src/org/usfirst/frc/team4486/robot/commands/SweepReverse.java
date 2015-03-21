//Author Troy SUllivan & Brandon Geronimo
package org.usfirst.frc.team4486.robot.commands;
import org.usfirst.frc.team4486.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SweepReverse extends Command {
    public SweepReverse() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (Robot.Rake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.Rake.setSpeed(-1.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.Rake.setSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}