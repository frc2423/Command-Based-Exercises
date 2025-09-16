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

1. In the simulation GUI, look for the SmartDashboard section
2. You'll see buttons for each challenge:
   - **Drive Forward for Time**: Makes the robot drive forward for 3 seconds
   - **Joystick Teleop Driving**: Allows controller-based driving
   - **Simple Button Command**: Spin robot when A button is held
   - **Turn to Angle**: Turn robot to 90 degrees using gyro
   - **Stop Robot**: Stops all robot movement
3. Click any button to start that challenge
4. Watch the robot move on the field visualization
5. Use the "Field2d" widget to see the robot's position and orientation

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

**What you'll learn**:
- How commands work (start, execute, end, isFinished)
- Using WPILib Timer class
- Basic drivetrain control
- Command lifecycle management

**Hints**:
- The first parameter of `drive()` is forward speed, second is rotation
- Use positive values to drive forward
- The timer measures elapsed time in seconds

### Challenge 2: Joystick-Teleop Driving
**File**: `src/main/java/frc/robot/challenges/JoystickTeleopDriving.java`

**Goal**: Use a joystick or controller to teleop-drive the robot (arcade drive).

**Concepts**: Continuous commands, controller input, arcade drive

**What you'll learn**:
- Reading controller inputs
- Arcade drive control (forward/backward + turning)
- Continuous commands that never finish
- Input scaling and inversion

**Hints**:
- Xbox controllers return negative values when pushing forward
- You may need to negate one or both inputs: `-controller.getLeftY()`
- This command runs until another challenge is started

### Challenge 3: Simple Button Command
**File**: `src/main/java/frc/robot/challenges/SimpleButtonCommand.java`

**Goal**: While holding the A button, spin the robot in place (simulating an intake motor).

**Concepts**: Button state checking, conditional execution

**What you'll learn**:
- Checking button states in commands
- Conditional robot behavior

**Hints**:
- `getAButton()` returns true when the button is currently pressed
- Use `drivetrain.drive(0, rotation)` to spin in place
- Positive rotation values spin counterclockwise

### Challenge 4: Turn to Angle
**File**: `src/main/java/frc/robot/challenges/TurnToAngle.java`

**Goal**: Use the gyro to turn the robot to exactly 90 degrees.

**Concepts**: Sensor feedback, proportional control, closed-loop systems


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

## Intermediate Challenges

These challenges introduce more advanced concepts while still focusing on drivetrain control.

### Challenge 5: Drive Distance
**File**: `src/main/java/frc/robot/challenges/DriveDistance.java`
**Goal**: Drive forward exactly 2 meters using encoder feedback, then stop.
**Concepts**: Encoder readings, distance-based control, odometry
**SmartDashboard Button**: "Drive Distance"

**What you'll learn**:
- Reading encoder values for precise movement
- Using odometry for position tracking
- Distance-based control vs time-based control
- Understanding coordinate systems

**Instructions**:
1. In `initialize()`: Reset odometry using `drivetrain.resetOdometry(new Pose2d())`
2. In `execute()`: Drive forward at constant speed
3. In `isFinished()`: Check if `drivetrain.getPose().getX() >= TARGET_DISTANCE`
4. In `end()`: Stop the robot

### Challenge 6: Square Path
**File**: `src/main/java/frc/robot/challenges/SquarePath.java`
**Goal**: Drive in a 1m x 1m square pattern using command compositions.
**Concepts**: SequentialCommandGroup, command building blocks, command compositions
**SmartDashboard Button**: "Square Path"

**What you'll learn**:
- Command compositions and SequentialCommandGroup
- Creating reusable command building blocks
- How complex autonomous routines are built from simple commands
- Command scheduling and lifecycle management

**Instructions**:
1. Complete the `driveDistance()` helper method to drive forward a specific distance
2. Complete the `turnAngle()` helper method to turn a specific angle
3. In the constructor, use `addCommands()` to build the sequence:
   ```java
   addCommands(
       driveDistance(SIDE_LENGTH),
       turnAngle(TURN_ANGLE),
       driveDistance(SIDE_LENGTH),
       turnAngle(TURN_ANGLE),
       // ... continue for all 4 sides
   );
   ```

**Key Concepts**:
- This demonstrates the power of command-based programming
- Complex behaviors built from simple, reusable components
- Each command handles its own lifecycle (initialize, execute, end, isFinished)
- SequentialCommandGroup automatically manages the sequence

### Challenge 7: PID Turn to Angle
**File**: `src/main/java/frc/robot/challenges/PIDTurnToAngle.java`
**Goal**: Use a PID controller to turn to 180 degrees with smooth, accurate control.
**Concepts**: PID controllers, tuning gains, smooth control
**SmartDashboard Button**: "PID Turn to Angle"

**What you'll learn**:
- PID controller theory and implementation
- Tuning P, I, and D gains
- Difference between PID and simple proportional control
- Handling overshoot and oscillation

**Instructions**:
1. Create PID controller with gains (try P=0.05, I=0.0, D=0.01)
2. In `initialize()`: Reset gyro and set PID setpoint
3. In `execute()`: Use `pidController.calculate(currentAngle)` for turn speed
4. In `isFinished()`: Use `pidController.atSetpoint()`

**PID Tuning Tips**:
- Start with P only, increase until oscillation, then reduce
- Add D to reduce oscillation
- Add I only if there's steady-state error

### Challenge 8: Drive to Position
**File**: `src/main/java/frc/robot/challenges/DriveToPosition.java`
**Goal**: Drive to a specific X,Y coordinate (3, 2) using simple proportional control.
**Concepts**: 2D navigation, proportional control, coordinated movement
**SmartDashboard Button**: "Drive to Position"

**What you'll learn**:
- 2D coordinate navigation and positioning
- Calculating distance and angle to targets
- Coordinated driving and turning simultaneously
- Simple proportional control for both axes

**Instructions**:
1. Calculate distance to target: `Math.sqrt(deltaX*deltaX + deltaY*deltaY)`
2. Calculate angle to target: `Math.atan2(deltaY, deltaX)`
3. Use proportional control:
   - Drive speed = `distanceToTarget * DRIVE_KP`
   - Turn speed = `angleError * TURN_KP`
4. Apply both outputs simultaneously: `drivetrain.drive(driveOutput, turnOutput)`

**Key Concepts**:
- This is like a simple "drive to point" autonomous routine
- Robot drives and turns at the same time to reach the target
- Proportional control makes the robot slow down as it approaches
- Real robots use similar techniques for field navigation

## Understanding the Code Structure

Each challenge implements the `Challenge` interface with one method:
- `getCommand(Drivetrain)`: Returns a Command that implements the challenge logic

The returned Command has four key methods:
- `initialize()`: Called once when the command begins
- `execute()`: Called repeatedly (~50 times/second) while active
- `end(boolean interrupted)`: Called once when the command stops
- `isFinished()`: Returns true when the command should end

The `ChallengeManager` subsystem manages all challenges and integrates with the command-based framework. SmartDashboard buttons in the simulation GUI allow you to start different challenges.

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
- Make sure the simulation GUI is running and connected
