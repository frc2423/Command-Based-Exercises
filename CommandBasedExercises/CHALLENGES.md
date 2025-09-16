# FRC Command-Based Programming Challenges

Welcome to the FRC Command-Based Programming Challenges! This project is designed to help new students learn the WPILib command-based framework through progressive, hands-on challenges that can be tested in simulation.

## Getting Started

### Running the Simulation

1. Open this project in VS Code with the WPILib extension installed
2. Press `Ctrl+Shift+P` (or `Cmd+Shift+P` on Mac) to open the command palette
3. Type "WPILib: Simulate Robot Code" and select it
4. Choose "Sim GUI" when prompted and press OK
5. The simulation GUI will open, showing your robot on a field

### Testing Your Challenges

1. You'll see buttons for each challenge in the simulation GUI
2. Use an Xbox controller or keyboard to interact with the challenges:
   - **X Button**: Drive Forward for Time
   - **Y Button**: Turn to Angle
   - **B Button**: Simple Button Command
   - **Left Bumper**: Joystick Teleop Driving
   - **Right Bumper**: Stop All Challenges
3. Watch the robot move on the field visualization
4. Use the "Field2d" widget to see the robot's position and orientation

## Programming Resources

Before starting the challenges, familiarize yourself with these concepts:

### Essential Java Concepts
- **Variables**: [Java Variables - W3Schools](https://www.w3schools.com/java/java_variables.asp)
- **Methods**: [Java Tutorial - Oracle](https://docs.oracle.com/javase/tutorial/java/index.html)
- **If/Else Statements**: [Java Conditions - W3Schools](https://www.w3schools.com/java/java_conditions.asp)
- **Classes and Objects**: [Java OOP - W3Schools](https://www.w3schools.com/java/java_oop.asp)

### WPILib Command-Based Framework
- [Command-Based Programming](https://docs.wpilib.org/en/stable/docs/software/commandbased/index.html) - Main framework documentation
- [WPILib Simulation GUI Guide](https://docs.wpilib.org/en/stable/docs/software/wpilib-tools/robot-simulation/simulation-gui.html)
- [Subsystems](https://docs.wpilib.org/en/stable/docs/software/commandbased/subsystems.html) - Understanding robot subsystems
- [Commands](https://docs.wpilib.org/en/stable/docs/software/commandbased/commands.html) - Creating and using commands

### Additional Resources
- [Oracle Java Tutorials](https://docs.oracle.com/javase/tutorial/java/index.html) - Comprehensive Java learning
- [WPILib Documentation](https://docs.wpilib.org/en/stable/index.html) - Complete FRC robot programming guide
- [Differential Drive Kinematics](https://docs.wpilib.org/en/stable/docs/software/kinematics-and-odometry/differential-drive-kinematics.html)

## Command-Based Programming Challenges

Complete these challenges in order. Each challenge builds on concepts from previous ones.

### Challenge 1: Drive Forward for Time
**File**: `src/main/java/frc/robot/challenges/DriveForwardForTime.java`
**Goal**: Make a robot drive forward at a fixed speed for 3 seconds, then stop.
**Concepts**: Command lifecycle, timers, basic robot movement
**Button**: X Button on controller

**What you'll learn**:
- How commands work (start, execute, end, isFinished)
- Using WPILib Timer class
- Basic drivetrain control
- Command lifecycle management

**Instructions**:
1. In `start()`: Reset and start the timer using `timer.restart()`
2. In `execute()`: Make the robot drive forward using `drivetrain.drive(DRIVE_SPEED, 0)`
3. In `isFinished()`: Return true when `timer.get() >= DRIVE_TIME_SECONDS`
4. In `end()`: Stop the robot using `drivetrain.drive(0, 0)`

**Hints**:
- The first parameter of `drive()` is forward speed, second is rotation
- Use positive values to drive forward
- The timer measures elapsed time in seconds

### Challenge 2: Joystick-Teleop Driving
**File**: `src/main/java/frc/robot/challenges/JoystickTeleopDriving.java`
**Goal**: Use a joystick or controller to teleop-drive the robot (arcade drive).
**Concepts**: Continuous commands, controller input, arcade drive
**Button**: Left Bumper on controller

**What you'll learn**:
- Reading controller inputs
- Arcade drive control (forward/backward + turning)
- Continuous commands that never finish
- Input scaling and inversion

**Instructions**:
1. In `execute()`: Read controller inputs and drive the robot
2. Use `controller.getLeftY()` for forward/backward (may need to negate)
3. Use `controller.getRightX()` for turning (may need to negate)
4. Scale inputs by `Drivetrain.kMaxSpeed` and `Drivetrain.kMaxAngularSpeed`
5. `isFinished()` should return false (runs continuously)

**Hints**:
- Xbox controllers return negative values when pushing forward
- You may need to negate one or both inputs: `-controller.getLeftY()`
- This command runs until another challenge is started

### Challenge 3: Simple Button Command
**File**: `src/main/java/frc/robot/challenges/SimpleButtonCommand.java`
**Goal**: While holding the A button, spin the robot in place (simulating an intake motor).
**Concepts**: Button state checking, conditional execution
**Button**: B Button on controller (starts the challenge, then use A button within the challenge)

**What you'll learn**:
- Checking button states in commands
- Conditional robot behavior
- Simulating subsystem control
- "While held" button semantics

**Instructions**:
1. In `execute()`: Check if A button is pressed using `controller.getAButton()`
2. If pressed: Make robot spin using `drivetrain.drive(0, SPIN_SPEED)`
3. If not pressed: Stop the robot using `drivetrain.drive(0, 0)`
4. `isFinished()` should return false (runs continuously)

**Hints**:
- `getAButton()` returns true when the button is currently pressed
- Use `drivetrain.drive(0, rotation)` to spin in place
- Positive rotation values spin counterclockwise

### Challenge 4: Turn to Angle
**File**: `src/main/java/frc/robot/challenges/TurnToAngle.java`
**Goal**: Use the gyro to turn the robot to exactly 90 degrees.
**Concepts**: Sensor feedback, proportional control, closed-loop systems
**Button**: Y Button on controller

**What you'll learn**:
- Reading sensor data (gyro)
- Proportional control algorithms
- Closed-loop feedback systems
- Error calculation and correction

**Instructions**:
1. In `start()`: Reset the gyro using `drivetrain.resetGyro()`
2. In `execute()`: Implement proportional control
   - Get current angle: `drivetrain.getAngle()`
   - Calculate error: `TARGET_ANGLE - currentAngle`
   - Calculate turn speed: `error * TURN_KP`
   - Limit speed and apply: `drivetrain.drive(0, turnSpeed)`
3. In `isFinished()`: Return true when close enough to target
4. In `end()`: Stop the robot

**Hints**:
- Proportional control: output is proportional to error
- Large errors → fast turning, small errors → slow turning
- Use `Math.abs(error) < ANGLE_TOLERANCE` to check if close enough
- Tune `TURN_KP` if the robot oscillates or responds too slowly

## Understanding the Code Structure

Each challenge implements the `Challenge` interface with four methods:
- `start(Drivetrain)`: Called once when the challenge begins
- `execute(Drivetrain)`: Called repeatedly (~50 times/second) while active
- `end(Drivetrain)`: Called once when the challenge stops
- `isFinished(Drivetrain)`: Returns true when the challenge should end

The `ChallengeManager` subsystem manages all challenges and integrates with the command-based framework. Button bindings in `RobotContainer.java` allow you to start different challenges.

## Tips for Success

1. **Start Simple**: Begin with Challenge 1 and work your way up
2. **Test Frequently**: Run the simulation after each small change
3. **Use Print Statements**: Add `System.out.println()` to debug your code
4. **Read the Documentation**: Use the WPILib docs when you're stuck
5. **Ask for Help**: Don't hesitate to ask mentors when you need assistance
6. **Experiment**: Try different values and see how they affect robot behavior

## Troubleshooting

### Common Issues
- **Robot doesn't move**: Check that you're calling `drivetrain.drive()` with non-zero values
- **Robot moves wrong direction**: Try negating the speed values
- **Challenge doesn't start**: Make sure you're pressing the correct button
- **Robot doesn't stop**: Ensure `end()` method calls `drivetrain.drive(0, 0)`

### Debugging Tips
- Use `System.out.println()` to print variable values
- Check the console output in VS Code for error messages
- Verify button mappings in `RobotContainer.java`
- Make sure the simulation GUI is running and connected

## Next Steps

Once you complete these basic challenges, you'll be ready for more advanced topics:
- Autonomous sequences with multiple commands
- PID controllers for precise movement
- Trajectory following
- State machines for complex behaviors
- Vision processing and sensor fusion

Keep practicing and experimenting with the command-based framework!