package frc.robot.challenges;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Drivetrain;

/**
 * Challenge 5: Drive Distance
 * 
 * Goal: Drive forward exactly 2 meters using encoder feedback, then stop.
 * 
 * Skills/Concepts Introduced:
 * - Reading encoder values
 * - Distance-based control instead of time-based
 * - Using sensor feedback for precise movement
 * - Understanding odometry
 * 
 * Instructions:
 * 1. In initialize(), reset the robot's odometry to start from (0,0)
 * 2. In execute(), drive forward at a constant speed
 * 3. In isFinished(), check if the robot has traveled 2 meters
 * 4. In end(), stop the robot
 * 
 * Hint: Use drivetrain.getPose().getX() to get the X position
 */
public class DriveDistance extends Command {

    private final Drivetrain drivetrain;

    public DriveDistance(Drivetrain drivetrain) {
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
    
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
