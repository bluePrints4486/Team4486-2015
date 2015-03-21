//Author Brandon Geronimo 
package org.usfirst.frc.team4486.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4486.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;


public class Shifters extends Subsystem {
    
	static DoubleSolenoid shifter = new DoubleSolenoid(RobotMap.Shifter_High,RobotMap.Shifter_Low);

	
	public static void ShiftHigh(){
			
			shifter.set(DoubleSolenoid.Value.kForward);
			
		}
	public static void ShiftLow(){
	
			
			shifter.set(DoubleSolenoid.Value.kReverse);
	}
		
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new ShiftLow());
    }
}