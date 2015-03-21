//Author Brandon Geronimo 
package org.usfirst.frc.team4486.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4486.robot.Robot;
import org.usfirst.frc.team4486.robot.subsystems.Deployer;

/**
 *
 */

public class DeployOut extends Command {
    public DeployOut() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.Deployer);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Deployer.DeployOut();    	
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