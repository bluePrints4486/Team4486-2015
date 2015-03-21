//Author Brandon Geronimo & Troy Sullivan 
  
package org.usfirst.frc.team4486.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4486.robot.commands.AutoDrive;
import org.usfirst.frc.team4486.robot.commands.AutoDefault;
import org.usfirst.frc.team4486.robot.commands.AutoPick;
import org.usfirst.frc.team4486.robot.commands.AutoSequence;
import org.usfirst.frc.team4486.robot.commands.WinchAuto;
import org.usfirst.frc.team4486.robot.subsystems.Deployer;
import org.usfirst.frc.team4486.robot.subsystems.Shifters;
import org.usfirst.frc.team4486.robot.subsystems.DriveSystem;
import org.usfirst.frc.team4486.robot.subsystems.Rake;
import org.usfirst.frc.team4486.robot.subsystems.Winch;
import org.usfirst.frc.team4486.robot.subsystems.Clamp;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	
	public static final DriveSystem driveSystem = new DriveSystem();
	public static final Winch winch = new Winch();
	public static final Shifters shifters = new Shifters();
	public static final Rake Rake = new Rake();	
	public static final Clamp clamp = new Clamp();
	public static final Deployer Deployer = new Deployer();
	public static OI oi;


    Command autonomousCommand;
    Command autoDefault;
    Command autoDrive;
    Command autoPick;
    Command AutoSequence;
    SendableChooser autoChooser;
    
    int session;
    Image frame;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
       // autonomousCommand = new ExampleCommand();
        autoDefault = new AutoDefault();
        autoDrive = new AutoSequence();
        autoPick = new AutoPick();
        
           
        frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
        

        //the camera name (ex "cam0") can be found through the roborio web interface
        session = NIVision.IMAQdxOpenCamera("cam1",
        NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(session);
        
        
        autoChooser = new SendableChooser();
    	autoChooser.addDefault("None", new AutoDefault());
    	autoChooser.addObject("Drive", new AutoDrive(RobotMap.time,RobotMap.speed));
        autoChooser.addObject("AutoPickUp", new WinchAuto());
    	SmartDashboard.putData("Autonomous mode chooser", autoChooser);
    	
    	
    }
	
	public void disabledPeriodic() {
		runCamera();
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	
        if (autonomousCommand != null) 
       	autonomousCommand.start();
        autonomousCommand = (Command) autoChooser.getSelected();
        autonomousCommand.start();
        autoDrive.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    
    public void autonomousPeriodic() {
    	
    	runCamera();
    	Scheduler.getInstance().run();
    }

    public void teleopInit() {
		
    	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        
    	if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    
    public void teleopPeriodic() {
      	
      runCamera();
      Scheduler.getInstance().run();
      }
    
    /**
     * This function is called periodically during test mode
     */
    
    public void testPeriodic() {
        LiveWindow.run();
    }
    
   public void runCamera(){
	   NIVision.IMAQdxStartAcquisition(session);
	   NIVision.IMAQdxGrab(session, frame, 1);
	   CameraServer.getInstance().setImage(frame);	
    } 
  }