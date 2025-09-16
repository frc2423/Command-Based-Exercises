package frc.robot.challenges;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Drivetrain;

public class Spin extends Command {

    private final Drivetrain drivetrain;

    public Spin(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        drivetrain.drive(0, .5);

    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.drive(0, 0);

    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
