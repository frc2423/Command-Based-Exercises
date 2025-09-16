package frc.robot.challenges;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Drivetrain;

/**
 * Challenge 8: Drive to Position
 *
 * Goal: Drive to a specific X,Y coordinate (3, 2) using simple proportional control.
 *
 * Skills/Concepts Introduced:
 * - 2D navigation and positioning
 * - Calculating distance and angle to target
 * - Coordinated movement (driving while turning)
 * - Simple proportional control for both axes
 *
 * Instructions:
 * 1. Calculate the distance and angle to the target position
 * 2. Use proportional control for forward speed based on distance
 * 3. Use proportional control for turn speed based on angle error
 * 4. Drive until you reach the target position within tolerance
 *
 * This is like a simple "drive to point" autonomous routine!
 */
public class DriveToPosition extends Command {

    private final Drivetrain drivetrain;

    public DriveToPosition(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
    }

    @Override
    public void initialize() {
        drivetrain.resetOdometry(new Pose2d());
        System.out.println("Drive to Position started - driving to (" + TARGET_X + ", " + TARGET_Y + ")");
    }

    @Override
    public void execute() {
        Pose2d currentPose = drivetrain.getPose();
       
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.drive(0, 0);
    }

    @Override
    public boolean isFinished() {
        // TODO: Return true when we've reached the target position within tolerance
        return false;
    }
}
