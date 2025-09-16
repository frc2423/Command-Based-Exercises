package frc.robot.challenges;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
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
public class DriveForwardForTime extends Command {

    private final Drivetrain drivetrain;
    private Timer timer = new Timer();

    public DriveForwardForTime(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
    }

    @Override
    public void initialize() {
        

    }

    @Override
    public void execute() {
    
    }

    @Override
    public void end(boolean interrupted) {
        // TODO: Stop the robot
        // Hint: Use drivetrain.drive(0, 0) to stop

    }

    @Override
    public boolean isFinished() {
        // TODO: Return true when enough time has passed
        // Hint: Use timer.get() to get elapsed time in seconds
        return false;
    }

}
