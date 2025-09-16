package frc.robot.challenges;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Drivetrain;

/**
 * Challenge 2: Joystick-Teleop Driving
 *
 * Goal: Use a joystick or controller to teleop-drive the robot (arcade drive).
 *
 * Skills/Concepts Introduced:
 * - Subsystems and default commands
 * - Mapping operator input via controller
 * - Continuous operation (never finishes)
 * - Arcade drive control
 *
 * Instructions:
 * 1. In the initialize() method, you don't need to do anything special
 * 2. In the execute() method, read joystick inputs and drive the robot
 * 3. Use the left Y axis for forward/backward speed
 * 4. Use the right X axis for turning
 * 5. The isFinished() method should return false (this runs continuously)
 * 6. In the end() method, stop the robot
 *
 * Note: This challenge demonstrates a "default command" - it runs continuously
 * until another challenge is started.
 */
public class JoystickTeleopDriving extends Command {
    private final Drivetrain drivetrain;
    private XboxController controller = new XboxController(0);

    public JoystickTeleopDriving(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
    }

    @Override
    public void initialize() {
        // Nothing special needed for teleop driving
        System.out.println("Teleop driving started - use controller to drive!");
    }

    @Override
    public void execute() {
        // TODO: Read controller inputs and drive the robot
        // Hint: Use controller.getLeftY() for forward/backward speed
        // Hint: Use controller.getRightX() for turning
        // Hint: You may need to negate one or both values depending on controller orientation
        // Hint: Scale the inputs by Drivetrain.kMaxSpeed and Drivetrain.kMaxAngularSpeed

        double xSpeed = 0; // TODO: Get forward/backward speed from controller
        double rotation = 0; // TODO: Get turning speed from controller

        drivetrain.drive(xSpeed, rotation);
    }

    @Override
    public void end(boolean interrupted) {
        // TODO: Stop the robot
        drivetrain.drive(0, 0);
        System.out.println("Teleop driving stopped");
    }

    @Override
    public boolean isFinished() {
        // TODO: This challenge should run continuously until stopped
        // Return false so it never finishes on its own
        return false;
    }
}
