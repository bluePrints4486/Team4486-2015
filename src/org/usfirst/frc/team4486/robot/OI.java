//Author Brandon Geronimo & Troy Sullivan
//BRANDON THE THE 1ST BUOUSS
// TROY IS A  MEGA BUOUSS
package org.usfirst.frc.team4486.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4486.robot.commands.*;

public class OI {

	//Controls
	
	//Driver
	public static JoystickButton shift_High = new JoystickButton(RobotMap.Joy_1,1);
	
	//Manipulator
	public static JoystickButton clamp_Open = new JoystickButton(RobotMap.Joy_2,1);
	public static JoystickButton clamp_Close = new JoystickButton (RobotMap.Joy_2,2);
	public static JoystickButton winch_Up = new JoystickButton(RobotMap.Joy_2, 10);
	public static JoystickButton winch_down = new JoystickButton(RobotMap.Joy_2,12);
	public static JoystickButton rake_In = new JoystickButton(RobotMap.Joy_2,6);
	public static JoystickButton rake_Out = new JoystickButton(RobotMap.Joy_2,4);
	public static JoystickButton deploy_Out = new JoystickButton(RobotMap.Joy_2,5);
	public static JoystickButton deploy_In = new JoystickButton(RobotMap.Joy_2, 3);
    OI() {
    	
    	
    	// Driver
    	shift_High.whenReleased(new ShiftLow());
    	shift_High.whenPressed(new ShiftHigh());
    	
    	//Mulipulator
    	clamp_Open.whenPressed(new ClampOpen());
    	clamp_Close.whenReleased(new ClampClose());
    	rake_In.whileHeld(new SweepForward());
    	rake_Out.whileHeld(new SweepReverse());
    	winch_down.whileHeld(new WinchDown());
    	winch_Up.whileHeld(new WinchUp());
    	deploy_In.whenPressed(new DeployIn());
    	deploy_Out.whenPressed(new DeployOut());
    }
}