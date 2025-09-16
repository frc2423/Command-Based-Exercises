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
        Command command = new DriveForwardForTime(drivetrain);
        command.addRequirements(this);
        return command;
    }

    /**
     * Command for Challenge 2: Joystick Teleop Driving
     */
    public Command joystickTeleopDriving() {
        Command command = new JoystickTeleopDriving(drivetrain);
        command.addRequirements(this);
        return command;
    }

    /**
     * Command for Challenge 3: Simple Button Command
     */
    public Command simpleButtonCommand() {
        Command command = new SimpleButtonCommand(drivetrain);
        command.addRequirements(this);
        return command;
    }

    /**
     * Command for Challenge 4: Turn to Angle
     */
    public Command turnToAngle() {
        Command command = new TurnToAngle(drivetrain);
        command.addRequirements(this);
        return command;
        
    }

    public Command spin() {
        Command command = new Spin(drivetrain);
        command.addRequirements(this);
        return command;
    }

    /**
     * Command for Challenge 5: Drive Distance
     */
    public Command driveDistance() {
        Command command = new DriveDistance(drivetrain);
        command.addRequirements(this);
        return command;
    }

    /**
     * Command for Challenge 6: Square Path
     */
    public Command squarePath() {
        Command command = new SquarePath(drivetrain);
        command.addRequirements(this);
        return command;
    }

    /**
     * Command for Challenge 7: PID Turn to Angle
     */
    public Command pidTurnToAngle() {
        Command command = new PIDTurnToAngle(drivetrain);
        command.addRequirements(this);
        return command;
    }

    /**
     * Command for Challenge 8: Drive to Position
     */
    public Command driveToPosition() {
        Command command = new DriveToPosition(drivetrain);
        command.addRequirements(this);
        return command;
    }

    /**
     * Command to stop the robot (default command)
     */
    public Command stopRobot() {
        Command command = run(() -> drivetrain.drive(0, 0)).withName("Stop Robot");
        command.addRequirements(this);
        return command;
    }
}
