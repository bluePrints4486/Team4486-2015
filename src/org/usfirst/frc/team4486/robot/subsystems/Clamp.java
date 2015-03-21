//Author Brandon Geronimo & Troy SUllivan
package org.usfirst.frc.team4486.robot.subsystems;

import org.usfirst.frc.team4486.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
/**
 *
 */

public class Clamp extends Subsystem {
	static DoubleSolenoid Clamp = new DoubleSolenoid(RobotMap.ClampOpen, RobotMap.ClampClose); 
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static void clampClose(){
		
		Clamp.set(DoubleSolenoid.Value.kForward);
	}

	public static void clampOpen(){
		
		Clamp.set(DoubleSolenoid.Value.kReverse);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}