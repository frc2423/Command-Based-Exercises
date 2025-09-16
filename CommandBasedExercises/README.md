# links

Command Based docs: https://docs.wpilib.org/en/stable/docs/software/commandbased/index.html

WPILib simulation docs: https://docs.wpilib.org/en/stable/docs/software/wpilib-tools/robot-simulation/simulation-gui.html

# Command-Based Exercises

Here’s a progression of challenge ideas to help students learn the WPILib *command-based* framework + robot simulation. They are ordered from easiest to more advanced. You can adapt them (hardware, sensors, motors) to match what the students already know or have available in simulation. If you like, I can flesh these out into worksheet/solution forms too.

---

## Basic / Entry Level

These first few build foundational skills: subsystems, commands, scheduling, default commands, triggers.

| Challenge                      | Goal                                                                                                 | Skills/Concepts Introduced                                                                                      |
| ------------------------------ | ---------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------- |
| **1. Drive Forward for Time**  | Make a robot drive forward at a fixed speed for *X* seconds, then stop.                              | Creating a command, `execute()`, `isFinished()`, default subsystems, basic simulation.                          |
| **2. Joystick-Teleop Driving** | Use a joystick or controller to teleop-drive the robot (tank drive or arcade).                       | Subsystems, default command, mapping operator input via `RobotContainer`, command binding to joystick axis.     |
| **3. Simple Button Command**   | On pressing a button, run a command that turns on a motor (e.g. simulating “intake”) until released. | Trigger binding, commands that require subsystems, “on true / while held / when released” semantics.            |
| **4. Turn to Angle**           | Use a gyro (simulated) to turn the robot to a specified heading (e.g. 90°) upon command.             | Reading sensors, closed-loop condition in `isFinished()`, maybe simple proportional control, command lifecycle. |

---

## Intermediate

These deepen understanding: combinators, command groups, parallelism, default vs non-default, sensors, some PID.

| Challenge                                  | Goal                                                                                                                                                          | Skills/Concepts Introduced                                                                                           |
| ------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------- |
| **5. Autonomous Sequence**                 | Construct a sequence of commands to (for example) drive forward, turn, drive forward again.                                                                   | `SequentialCommandGroup`, command composition, ensuring proper subsystem usage, simulation of odometry if available. |
| **6. Parallel Actions**                    | While driving forward, simultaneously run another mechanism (e.g. spin a wheel, raise an arm).                                                                | `ParallelCommandGroup`, resource conflicts, how default commands or interrupting commands work.                      |
| **7. PID Controller for Shooter/Arm**      | Control an “arm” joint or flywheel speed using a PID loop: e.g. move arm to set positions, maintain flywheel RPM.                                             | Using WPILib’s PIDSubsystem or implementing your own PID, tuning, reading encoder feedback, handling overshoot etc.  |
| **8. Use of Simulation Physics & Widgets** | Use built-in physics simulation (e.g. `ElevatorSim`, `DifferentialDrivetrainSim`) and field widgets (Field2d) to visualize robot pose, or robot trajectories. | Understanding simulationPeriodic, sim devices, how to simulate sensors, visualizing in sim, debugging.               |

---

## Advanced / More Realistic

These are more challenging: trajectory following, state-based/autonomous logic, combining multi-mechanism coordination, error handling, scheduling at different rates, etc.

| Challenge                              | Goal                                                                                                                                  | Skills/Concepts Introduced                                                                                                                                                 |
| -------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **9. Trajectory Following**            | Given waypoints, generate and follow a trajectory (e.g. drive through several path points) with constraints.                          | WPILib trajectory classes, kinematics/odometry, motion profiling, pure pursuit or Ramsete, following paths in simulation.                                                  |
| **10. State Machine for Mode Changes** | Implement a subsystem that has multiple modes (e.g. intake, shoot, idle), switching based on operator input or autonomous conditions. | State machine (could be a command that changes behavior or several commands), scheduling, cancellation of commands, coordination.                                          |
| **11. Vision / Sensor Interaction**    | Simulate (or mock) a vision target: robot must move toward a target when one is “seen” (e.g. turn toward it or align).                | Sensor input, conditionals within commands or triggers, combining sensor feedback + motion. If vision simulation is hard, use a mock sensor or a simulated gyro + encoder. |
| **12. Full Match Simulation**          | Combine everything: autonomous period (trajectory, timed actions), then teleop control, plus perhaps “endgame” action (e.g. climb).   | Complex command scheduling, safety (making sure motors stop), combining default & instantiated commands, recovering from error states, designing for competition flow.     |

---

## Extensions / Optional-Extras

To push students further or for capstone kinds of challenges.

* **Tuning under load**: Introduce simulated disturbances (added weight, slippage) and have them tune PID parameters accordingly, observe how the robot behaves.
* **Fault handling / safety**: What happens when a sensor fails (zero reading, or stuck)? Have students build in timeouts or fallback strategies.
* **Multithreaded or periodic schedules**: Use commands or subsystems that run at different rates, e.g. one that sends telemetry every 100 ms, another that works at higher rate.
* **Resource management**: Multiple commands that require the same subsystem, show what happens when two commands conflict.
* **Scheduler vs event-based triggers**: Use WPILib’s `Trigger` classes to do conditional scheduling (e.g. “when X happens, do Y”).

