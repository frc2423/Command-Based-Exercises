package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
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

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        configureBindings();

        // Add challenge commands to SmartDashboard
        SmartDashboard.putData(challengeManager.stopRobot());
        SmartDashboard.putData(challengeManager.driveForwardForTime());
        SmartDashboard.putData(challengeManager.joystickTeleopDriving());
        SmartDashboard.putData(challengeManager.simpleButtonCommand());
        SmartDashboard.putData(challengeManager.turnToAngle());

        SmartDashboard.putData("Challenges", challengeManager);
    }

    /**
     * Use this method to define your button->command mappings.
     */
    private void configureBindings() {
        // No button bindings needed - challenges are started via SmartDashboard
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // For now, return a command that does nothing
        // Students can modify this later for autonomous challenges
        return Commands.none();
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
