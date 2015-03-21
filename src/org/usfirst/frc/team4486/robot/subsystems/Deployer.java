//Author Brandon Geronimo 
package org.usfirst.frc.team4486.robot.subsystems;

import org.usfirst.frc.team4486.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
/**
 *
 */

public class Deployer extends Subsystem {
    
	static DoubleSolenoid Deployer = new DoubleSolenoid(RobotMap.pickUp_1, RobotMap.pickUp_2); 
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static void DeployOut(){
		
		Deployer.set(DoubleSolenoid.Value.kForward);
	}

	public static void DeployIn(){
		
		Deployer.set(DoubleSolenoid.Value.kReverse);		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}