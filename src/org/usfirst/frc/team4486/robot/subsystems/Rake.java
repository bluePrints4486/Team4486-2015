//Author Troy Sullivan {NUUB TEACHER -bRaNdOn GeRoNiMo}
package org.usfirst.frc.team4486.robot.subsystems;

import org.usfirst.frc.team4486.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;

/**
 *
 */

public class Rake extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public static Talon SweeperMotor = new Talon (RobotMap.SR_2);
	
	public void setSpeed(double s) {
		SweeperMotor.set(s);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}