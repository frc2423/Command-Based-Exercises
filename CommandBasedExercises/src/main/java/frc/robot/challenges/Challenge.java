package frc.robot.challenges;

import frc.robot.Drivetrain;

/**
 * Interface for command-based programming challenges.
 * Each challenge implements this interface to provide a self-contained
 * learning exercise that can be run in simulation.
 */
public interface Challenge {
    /**
     * Called once when the challenge begins.
     * Use this method to initialize any variables or set up the challenge.
     * 
     * @param drivetrain The robot's drivetrain subsystem
     */
    void start(Drivetrain drivetrain);
    
    /**
     * Called repeatedly (about 50 times per second) while the challenge is active.
     * This is where the main challenge logic should be implemented.
     * 
     * @param drivetrain The robot's drivetrain subsystem
     */
    void execute(Drivetrain drivetrain);
    
    /**
     * Called once when the challenge ends.
     * Use this method to clean up resources or stop motors.
     * 
     * @param drivetrain The robot's drivetrain subsystem
     */
    void end(Drivetrain drivetrain);
    
    /**
     * Returns true when the challenge should finish.
     * For timed challenges, this might check if enough time has passed.
     * For distance challenges, this might check if the robot has moved far enough.
     * For continuous challenges (like teleop), this might always return false.
     * 
     * @param drivetrain The robot's drivetrain subsystem
     * @return true if the challenge is finished, false otherwise
     */
    boolean isFinished(Drivetrain drivetrain);
}
