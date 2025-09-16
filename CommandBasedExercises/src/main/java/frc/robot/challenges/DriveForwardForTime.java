package frc.robot.challenges;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.Drivetrain;

/**
 * Challenge 1: Drive Forward for Time
 * 
 * Goal: Make a robot drive forward at a fixed speed for 3 seconds, then stop.
 * 
 * Skills/Concepts Introduced:
 * - Creating a command
 * - Using execute() method
 * - Using isFinished() method
 * - Basic simulation
 * - Working with timers
 * 
 * Instructions:
 * 1. In the start() method, reset and start the timer
 * 2. In the execute() method, make the robot drive forward at 0.5 m/s
 * 3. In the isFinished() method, return true when 3 seconds have passed
 * 4. In the end() method, stop the robot
 */
public class DriveForwardForTime implements Challenge {
    private Timer timer = new Timer();
    private static final double DRIVE_TIME_SECONDS = 3.0;
    private static final double DRIVE_SPEED = 0.5; // meters per second

    @Override
    public void start(Drivetrain drivetrain) {
        // TODO: Reset and start the timer
        // Hint: Use timer.restart()
        
    }

    @Override
    public void execute(Drivetrain drivetrain) {
        // TODO: Make the robot drive forward
        // Hint: Use drivetrain.drive(speed, rotation)
        // For driving straight forward, rotation should be 0
        
    }

    @Override
    public void end(Drivetrain drivetrain) {
        // TODO: Stop the robot
        // Hint: Use drivetrain.drive(0, 0) to stop
        
    }

    @Override
    public boolean isFinished(Drivetrain drivetrain) {
        // TODO: Return true when enough time has passed
        // Hint: Use timer.get() to get elapsed time in seconds
        // Compare it to DRIVE_TIME_SECONDS
        return false;
    }
}
