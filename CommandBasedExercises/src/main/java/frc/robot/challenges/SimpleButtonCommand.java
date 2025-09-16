package frc.robot.challenges;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Drivetrain;

/**
 * Challenge 3: Simple Button Command
 * 
 * Goal: On pressing a button, run a command that spins the robot (simulating "intake") 
 * while the button is held, and stops when released.
 * 
 * Skills/Concepts Introduced:
 * - Trigger binding
 * - Commands that require subsystems
 * - "While held" button semantics
 * - Button state checking
 * 
 * Instructions:
 * 1. In the execute() method, check if the A button is pressed
 * 2. If the button is pressed, make the robot spin in place at a slow speed
 * 3. If the button is not pressed, stop the robot
 * 4. This challenge runs continuously (never finishes) like teleop
 * 5. The spinning simulates running an intake motor while a button is held
 * 
 * Note: In a real command-based robot, you would use button bindings in RobotContainer,
 * but for this exercise we'll check the button state directly in execute().
 */
public class SimpleButtonCommand implements Challenge {
    private XboxController controller = new XboxController(0);
    private static final double SPIN_SPEED = 1.0; // radians per second

    @Override
    public void start(Drivetrain drivetrain) {
        System.out.println("Simple Button Command started - hold A button to spin!");
    }

    @Override
    public void execute(Drivetrain drivetrain) {
        // TODO: Check if the A button is pressed and control the robot accordingly
        // Hint: Use controller.getAButton() to check if A button is pressed
        // Hint: If pressed, use drivetrain.drive(0, SPIN_SPEED) to spin in place
        // Hint: If not pressed, use drivetrain.drive(0, 0) to stop
        
        if (false) { // TODO: Replace 'false' with button check
            // TODO: Make robot spin in place
            
        } else {
            // TODO: Stop the robot
            
        }
    }

    @Override
    public void end(Drivetrain drivetrain) {
        // TODO: Stop the robot
        drivetrain.drive(0, 0);
        System.out.println("Simple Button Command stopped");
    }

    @Override
    public boolean isFinished(Drivetrain drivetrain) {
        // TODO: This challenge should run continuously until stopped
        // Return false so it never finishes on its own
        return false;
    }
}
