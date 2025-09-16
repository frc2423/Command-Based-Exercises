package frc.robot.challenges;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Drivetrain;

/**
 * Subsystem that manages command-based programming challenges.
 * This integrates the challenge system with the WPILib command-based framework.
 */
public class ChallengeManager extends SubsystemBase {
    private final ChallengeController challengeController;
    private final Drivetrain drivetrain;

    public ChallengeManager(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
        this.challengeController = new ChallengeController(drivetrain);
        
        // Add all challenges
        challengeController.add("DriveForwardForTime", new DriveForwardForTime());
        challengeController.add("JoystickTeleopDriving", new JoystickTeleopDriving());
        challengeController.add("SimpleButtonCommand", new SimpleButtonCommand());
        challengeController.add("TurnToAngle", new TurnToAngle());
        
        // Set default command to stop all challenges
        setDefaultCommand(stopAllChallenges());
    }

    /**
     * Command to start the Drive Forward for Time challenge.
     */
    public Command startDriveForwardForTime() {
        return run(() -> challengeController.startChallenge("DriveForwardForTime"))
            .withName("Drive Forward for Time");
    }

    /**
     * Command to start the Joystick Teleop Driving challenge.
     */
    public Command startJoystickTeleopDriving() {
        return run(() -> challengeController.startChallenge("JoystickTeleopDriving"))
            .withName("Joystick Teleop Driving");
    }

    /**
     * Command to start the Simple Button Command challenge.
     */
    public Command startSimpleButtonCommand() {
        return run(() -> challengeController.startChallenge("SimpleButtonCommand"))
            .withName("Simple Button Command");
    }

    /**
     * Command to start the Turn to Angle challenge.
     */
    public Command startTurnToAngle() {
        return run(() -> challengeController.startChallenge("TurnToAngle"))
            .withName("Turn to Angle");
    }

    /**
     * Command to stop all challenges.
     */
    public Command stopAllChallenges() {
        return run(() -> challengeController.stopCurrentChallenge())
            .withName("Stop All Challenges");
    }

    @Override
    public void periodic() {
        // Run the current challenge
        challengeController.run();
    }

    /**
     * Get the name of the currently active challenge.
     */
    public String getCurrentChallenge() {
        return challengeController.getCurrentChallenge();
    }

    /**
     * Check if a challenge is currently active.
     */
    public boolean isChallengeActive() {
        return challengeController.isChallengeActive();
    }
}
