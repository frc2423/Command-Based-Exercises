package frc.robot.challenges;

import java.util.HashMap;
import frc.robot.Drivetrain;

/**
 * Controller that manages and runs command-based programming challenges.
 * Similar to the LED controller, this allows switching between different
 * challenges and manages their lifecycle.
 */
public class ChallengeController {
    private HashMap<String, Challenge> challenges = new HashMap<String, Challenge>();
    private String currentChallenge;
    private Drivetrain drivetrain;
    private boolean challengeActive = false;

    /**
     * Creates a new ChallengeController.
     * 
     * @param drivetrain The robot's drivetrain subsystem
     */
    public ChallengeController(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
    }

    /**
     * Adds a challenge to the controller.
     * 
     * @param name The name of the challenge
     * @param challenge The challenge implementation
     */
    public void add(String name, Challenge challenge) {
        challenges.put(name, challenge);
    }

    /**
     * Starts a specific challenge.
     * If another challenge is currently running, it will be stopped first.
     * 
     * @param name The name of the challenge to start
     */
    public void startChallenge(String name) {
        if (!challenges.containsKey(name)) {
            System.out.println("Challenge not found: " + name);
            return;
        }
        
        // Stop current challenge if one is running
        if (currentChallenge != null && challengeActive) {
            stopCurrentChallenge();
        }
        
        // Start new challenge
        currentChallenge = name;
        challengeActive = true;
        challenges.get(name).start(drivetrain);
        System.out.println("Started challenge: " + name);
    }

    /**
     * Stops the currently running challenge.
     */
    public void stopCurrentChallenge() {
        if (currentChallenge != null && challengeActive) {
            challenges.get(currentChallenge).end(drivetrain);
            System.out.println("Stopped challenge: " + currentChallenge);
            challengeActive = false;
        }
    }

    /**
     * Runs the current challenge.
     * This should be called periodically (e.g., in teleopPeriodic or autonomousPeriodic).
     */
    public void run() {
        if (currentChallenge != null && challengeActive && challenges.containsKey(currentChallenge)) {
            Challenge challenge = challenges.get(currentChallenge);
            
            // Execute the challenge
            challenge.execute(drivetrain);
            
            // Check if the challenge is finished
            if (challenge.isFinished(drivetrain)) {
                stopCurrentChallenge();
            }
        }
    }

    /**
     * Returns the name of the currently active challenge.
     * 
     * @return The name of the current challenge, or null if none is active
     */
    public String getCurrentChallenge() {
        return challengeActive ? currentChallenge : null;
    }

    /**
     * Returns whether a challenge is currently active.
     * 
     * @return true if a challenge is running, false otherwise
     */
    public boolean isChallengeActive() {
        return challengeActive;
    }
}
