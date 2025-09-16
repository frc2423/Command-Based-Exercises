package frc.robot.challenges;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Drivetrain;

/**
 * Challenge 6: Square Path
 *
 * Goal: Drive in a 1m x 1m square pattern using command compositions.
 *
 * Skills/Concepts Introduced:
 * - Command compositions and SequentialCommandGroup
 * - Creating reusable command building blocks
 * - Combining commands to create complex behaviors
 * - Understanding command scheduling and lifecycle
 *
 * Instructions:
 * 1. Create helper methods that return commands for driving and turning
 * 2. Use SequentialCommandGroup to chain commands together
 * 3. Build the sequence: Drive -> Turn -> Drive -> Turn -> Drive -> Turn -> Drive
 * 4. Each drive should be 1 meter, each turn should be 90 degrees
 *
 * This demonstrates how complex autonomous routines are built from simple building blocks!
 */
public class SquarePath extends SequentialCommandGroup {
    private static final double SIDE_LENGTH = 1.0; // meters
    private static final double DRIVE_SPEED = 0.8; // meters per second
    private static final double TURN_ANGLE = 90.0; // degrees

    private final Drivetrain drivetrain;

    public SquarePath(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;

        // TODO: Build the square path using addCommands()
        // You need to create a sequence of drive and turn commands
        // Pattern: Drive -> Turn -> Drive -> Turn -> Drive -> Turn -> Drive

        addCommands(
            // TODO: Add commands to drive in a square
            // Hint: Use driveDistance(SIDE_LENGTH) and turnAngle(TURN_ANGLE)
            // Example: driveDistance(SIDE_LENGTH), turnAngle(TURN_ANGLE), ...
        );
    }

    /**
     * Helper method to create a command that drives forward a specific distance.
     * This demonstrates how to create reusable command building blocks.
     */
    private Command driveDistance(double distance) {
        return new Command() {
            private Pose2d startPose;

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
        };
    }

    /**
     * Helper method to create a command that turns a specific angle.
     * This demonstrates creating parameterized commands.
     */
    private Command turnAngle(double degrees) {
        return new Command() {
            private double startAngle;
            private double targetAngle;

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
        };
    }

    @Override
    public void initialize() {
        drivetrain.resetOdometry(new Pose2d());
        System.out.println("Square Path started - driving in 1m x 1m square using command composition");
        super.initialize();
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.drive(0, 0);
        System.out.println("Square Path completed!");
        super.end(interrupted);
    }
}
