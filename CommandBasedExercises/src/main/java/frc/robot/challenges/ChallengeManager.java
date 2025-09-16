package frc.robot.challenges;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Drivetrain;

/**
 * Subsystem that manages command-based programming challenges.
 * This follows the same pattern as the LED exercises.
 */
public class ChallengeManager extends SubsystemBase {
    private final Drivetrain drivetrain;

    public ChallengeManager(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;

        // Set default command to do nothing (stop robot)
        setDefaultCommand(stopRobot());
    }

    /**
     * Command for Challenge 1: Drive Forward for Time
     */
    public Command driveForwardForTime() {
        return new DriveForwardForTime(drivetrain);
    }

    /**
     * Command for Challenge 2: Joystick Teleop Driving
     */
    public Command joystickTeleopDriving() {
        return new JoystickTeleopDriving(drivetrain);
    }

    /**
     * Command for Challenge 3: Simple Button Command
     */
    public Command simpleButtonCommand() {
        return new SimpleButtonCommand(drivetrain);
    }

    /**
     * Command for Challenge 4: Turn to Angle
     */
    public Command turnToAngle() {
        return new TurnToAngle(drivetrain);
    }

    /**
     * Command to stop the robot (default command)
     */
    public Command stopRobot() {
        return run(() -> drivetrain.drive(0, 0)).withName("Stop Robot");
    }
}
