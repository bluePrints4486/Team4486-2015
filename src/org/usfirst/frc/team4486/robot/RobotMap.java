//Author Brandon Geronimo  & Troy Sullivan
 
package org.usfirst.frc.team4486.robot;

import edu.wpi.first.wpilibj.Joystick;


/**
 * The RobotMap is a mapping from the ports  sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//CANTalon creation
	//Entity ID's of Controlled
	public static int SRX_1 = 1;
	public static int SRX_2 = 2;
	public static int SRX_3 = 3;
	public static int SRX_4 = 4;
	
	//Talon SR
	//PWM Ports on RoboRio
	public static int SR_0 = 0;
	public static int SR_2 = 2;
	
	//Pneumatics/Festos/Solenoids
	public static final int ClampOpen = 5;
	public static final int ClampClose = 4;
	public static final int pickUp_1 = 2;
	public static final int pickUp_2 = 3;    
	
	//Pneumatic Shifters
	public static final int Shifter_High = 6;
	public static final int Shifter_Low = 7;
	
	//Joystick Controller setup
	public static final Joystick Joy_1 = new Joystick(1);
	public static final Joystick Joy_2 = new Joystick(2);

	//Auto
	public static final double speed = 0.5;
	public static final double time = 1.0;	
}