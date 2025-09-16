package frc.robot.challenges;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Drivetrain;

/**
 * Challenge 7: PID Turn to Angle
 * 
 * Goal: Use a PID controller to turn to 180 degrees with smooth, accurate control.
 * 
 * Skills/Concepts Introduced:
 * - PID controllers (Proportional, Integral, Derivative)
 * - Tuning PID gains
 * - Smooth, accurate control vs simple proportional control
 * - Understanding overshoot and oscillation
 * 
 * Instructions:
 * 1. Create and configure a PID controller
 * 2. In execute(), use the PID controller to calculate turn speed
 * 3. Feed the PID output to the drivetrain
 * 4. Experiment with different PID gains to see their effects
 * 
 * PID Tuning Tips:
 * - Start with P only, increase until it oscillates, then back off
 * - Add D to reduce oscillation
 * - Add I only if there's steady-state error (rarely needed for turning)
 */
public class PIDTurnToAngle extends Command {
    private static final double TARGET_ANGLE = 180.0; // degrees
    private static final double ANGLE_TOLERANCE = 1.0; // degrees
    private static final double MAX_TURN_SPEED = 2.0; // radians per second

    private final Drivetrain drivetrain;
    private final PIDController pidController;

    public PIDTurnToAngle(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
        
        // TODO: Create PID controller with initial gains
        // Try starting with: kP = 0.05, kI = 0.0, kD = 0.01
        // Hint: new PIDController(kP, kI, kD)
        this.pidController = new PIDController(0.0, 0.0, 0.0); // TODO: Set real gains
        
        // Configure PID controller
        pidController.setTolerance(ANGLE_TOLERANCE);
        pidController.enableContinuousInput(-180, 180); // Handle angle wraparound
    }

    @Override
    public void initialize() {
        // TODO: Reset gyro and set PID setpoint
        // Hint: Use drivetrain.resetGyro() and pidController.setSetpoint(TARGET_ANGLE)
        
        System.out.println("PID Turn to Angle started - turning to " + TARGET_ANGLE + " degrees");
    }

    @Override
    public void execute() {
        // TODO: Get current angle and calculate PID output
        double currentAngle = 0; // TODO: Get from drivetrain.getAngle()
        double pidOutput = 0; // TODO: Use pidController.calculate(currentAngle)
        
    
        
        // TODO: Apply the PID output to the drivetrain
        // Hint: Use drivetrain.drive(0, pidOutput)
        
        // Debug output
        System.out.println("Current: " + String.format("%.1f", currentAngle) + "°, " +
                          "Error: " + String.format("%.1f", TARGET_ANGLE - currentAngle) + "°, " +
                          "Output: " + String.format("%.3f", pidOutput));
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.drive(0, 0);
        double finalAngle = drivetrain.getAngle();
        double finalError = Math.abs(TARGET_ANGLE - finalAngle);
        System.out.println("PID Turn completed! Final angle: " + String.format("%.1f", finalAngle) + 
                          "°, Error: " + String.format("%.1f", finalError) + "°");
    }

    @Override
    public boolean isFinished() {
        // TODO: Use PID controller's atSetpoint() method
        // Hint: return pidController.atSetpoint();
        return false;
    }
}
