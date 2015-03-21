//Author Brandon Geronimo Troy Sullivan & Karl Lone
package org.usfirst.frc.team4486.robot.subsystems;

import org.usfirst.frc.team4486.robot.RobotMap;
import org.usfirst.frc.team4486.robot.commands.Drive;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team4486.robot.subsystems.DriveSystem;

/**
 *
 */

public class DriveSystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.	
	public static CANTalon SRX_1 = new CANTalon(RobotMap.SRX_1);
	public static CANTalon SRX_2 = new CANTalon(RobotMap.SRX_2);
	public static CANTalon SRX_3 = new CANTalon(RobotMap.SRX_3);
	public static CANTalon SRX_4 = new CANTalon(RobotMap.SRX_4);
	public static Timer driveTimer = new Timer();
	boolean init = true;
	public static RobotDrive roboDrive = new RobotDrive(SRX_3, SRX_4, SRX_1, SRX_2);
	public static void drive(){
		roboDrive.setMaxOutput(1);
		roboDrive.arcadeDrive(-RobotMap.Joy_1.getY(), -RobotMap.Joy_1.getTwist());	
	}
	
	public boolean autoDrive(double time,double speed,double curve){
        // this will run only once in the beginning
        if(init){
            driveTimer.start();
            driveTimer.reset();
            init = false;
        }
        // Drive
        roboDrive.drive(speed, curve);
        //If Out Of Time
        if(driveTimer.get()>time){
            init= true;
            roboDrive.drive(0, 0);
            return true;
        }
        
        return false;
    }
	
	public static void autoSwag(double time, double speed, double curve){
		
		roboDrive.drive(.5, -.5);
		Timer.delay(.5);
		roboDrive.drive(-.5, .5);
		Timer.delay(1);
		roboDrive.drive(.5, -.5);
		Timer.delay(.5);
		roboDrive.drive(-.5, .5);
		Timer.delay(1);
		roboDrive.drive(.5, -.5);
		Timer.delay(.5);
		roboDrive.drive(-.5, .5);
		Timer.delay(1);
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand())
		setDefaultCommand(new Drive());
    }
}