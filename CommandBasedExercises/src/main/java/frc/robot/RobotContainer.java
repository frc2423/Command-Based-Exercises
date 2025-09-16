package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.challenges.ChallengeManager;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems
    private final Drivetrain drivetrain = new Drivetrain();
    private final ChallengeManager challengeManager = new ChallengeManager(drivetrain);

    // The driver's controller
    private final XboxController driverController = new XboxController(0);

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        // Challenge button bindings
        // X button - Drive Forward for Time
        new JoystickButton(driverController, XboxController.Button.kX.value)
            .onTrue(challengeManager.startDriveForwardForTime());

        // Y button - Turn to Angle
        new JoystickButton(driverController, XboxController.Button.kY.value)
            .onTrue(challengeManager.startTurnToAngle());

        // B button - Simple Button Command
        new JoystickButton(driverController, XboxController.Button.kB.value)
            .onTrue(challengeManager.startSimpleButtonCommand());

        // Left Bumper - Joystick Teleop Driving
        new JoystickButton(driverController, XboxController.Button.kLeftBumper.value)
            .onTrue(challengeManager.startJoystickTeleopDriving());

        // Right Bumper - Stop All Challenges
        new JoystickButton(driverController, XboxController.Button.kRightBumper.value)
            .onTrue(challengeManager.stopAllChallenges());
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public void getAutonomousCommand() {
        // For now, we'll just stop all challenges in autonomous
        // Students can modify this later for autonomous challenges
        challengeManager.stopAllChallenges().schedule();
    }

    /**
     * Get the drivetrain subsystem for use in Robot.java
     */
    public Drivetrain getDrivetrain() {
        return drivetrain;
    }

    /**
     * Get the challenge manager for use in Robot.java
     */
    public ChallengeManager getChallengeManager() {
        return challengeManager;
    }
}
