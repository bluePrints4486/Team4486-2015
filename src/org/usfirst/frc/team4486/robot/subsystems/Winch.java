//Author Karl and Brandon
package org.usfirst.frc.team4486.robot.subsystems;


import org.usfirst.frc.team4486.robot.commands.WinchStop;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */

public class Winch extends Subsystem {
    
	public static Talon SR_0 = new Talon(1);
	public static final double WINCH_SPEED = .44;
	public static final double WINCH_STOP_SPEED = 0.1;
	public static final double LIMIT = 9;
	public void autoWinch(){
		SR_0.set(.5);
		Timer.delay(1);
		SR_0.set(0);
	}
	
	public void setSpeed(double speed){
		/*
		if(speed >= LIMIT){
			SR_0.set(LIMIT);
		} else if(-speed <= -LIMIT){
			SR_0.set(-LIMIT);
		} 
		else{
			SR_0.set(speed);
		}
		*/
		//System.out.println("Working");
		SR_0.set(speed);
		//RobotMap.Joy_2.getY();
	}
	
	// if (Math.abs(speed) <= LIMIT)

    public void initDefaultCommand() {
  
    	setDefaultCommand(new WinchStop());
   
    	}
}