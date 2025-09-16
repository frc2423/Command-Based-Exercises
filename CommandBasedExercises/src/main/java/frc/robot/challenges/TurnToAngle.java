package frc.robot.challenges;

import frc.robot.Drivetrain;

/**
 * Challenge 4: Turn to Angle
 * 
 * Goal: Use a gyro (simulated) to turn the robot to a specified heading (90°) upon command.
 * 
 * Skills/Concepts Introduced:
 * - Reading sensors (gyro)
 * - Closed-loop condition in isFinished()
 * - Simple proportional control
 * - Command lifecycle (start, execute, end, isFinished)
 * 
 * Instructions:
 * 1. In the start() method, reset the gyro to zero
 * 2. In the execute() method, implement simple proportional control to turn toward the target
 * 3. Calculate the error (difference between target and current angle)
 * 4. Use the error to determine turn speed (proportional control)
 * 5. In the isFinished() method, return true when close enough to the target
 * 6. In the end() method, stop the robot
 * 
 * Proportional Control: The turn speed should be proportional to the error.
 * If we're far from the target, turn fast. If we're close, turn slowly.
 */
public class TurnToAngle implements Challenge {
    private static final double TARGET_ANGLE = 90.0; // degrees
    private static final double ANGLE_TOLERANCE = 2.0; // degrees
    private static final double TURN_KP = 0.02; // proportional gain (tune this value)
    private static final double MAX_TURN_SPEED = 1.0; // max radians per second

    @Override
    public void start(Drivetrain drivetrain) {
        // TODO: Reset the gyro to start from zero
        // Hint: Use drivetrain.resetGyro()
        
        System.out.println("Turn to Angle started - turning to " + TARGET_ANGLE + " degrees");
    }

    @Override
    public void execute(Drivetrain drivetrain) {
        // TODO: Implement proportional control to turn to the target angle
        
        // Step 1: Get the current angle from the gyro
        double currentAngle = 0; // TODO: Get current angle using drivetrain.getAngle()
        
        // Step 2: Calculate the error (how far we are from the target)
        double error = 0; // TODO: Calculate TARGET_ANGLE - currentAngle
        
        // Step 3: Calculate turn speed using proportional control
        double turnSpeed = 0; // TODO: Multiply error by TURN_KP
        
        // Step 4: Limit the turn speed to prevent going too fast
        if (turnSpeed > MAX_TURN_SPEED) {
            turnSpeed = MAX_TURN_SPEED;
        } else if (turnSpeed < -MAX_TURN_SPEED) {
            turnSpeed = -MAX_TURN_SPEED;
        }
        
        // Step 5: Apply the turn speed to the drivetrain
        // TODO: Use drivetrain.drive(0, turnSpeed) to turn in place
        
        // Debug output (optional)
        System.out.println("Current: " + currentAngle + "°, Error: " + error + "°, Speed: " + turnSpeed);
    }

    @Override
    public void end(Drivetrain drivetrain) {
        // TODO: Stop the robot
        drivetrain.drive(0, 0);
        System.out.println("Turn to Angle completed!");
    }

    @Override
    public boolean isFinished(Drivetrain drivetrain) {
        // TODO: Return true when we're close enough to the target angle
        // Hint: Get current angle and check if Math.abs(TARGET_ANGLE - currentAngle) < ANGLE_TOLERANCE
        
        double currentAngle = drivetrain.getAngle();
        double error = Math.abs(TARGET_ANGLE - currentAngle);
        return error < ANGLE_TOLERANCE;
    }
}
