package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Robot extends TimedRobot {
  private Joystick m_stick;
  private CANSparkMax m_motor;
  private RelativeEncoder m_encoder;

  @Override
  public void robotInit() {
    m_motor = new CANSparkMax(4, MotorType.kBrushless);
    m_motor.restoreFactoryDefaults();
    m_encoder = m_motor.getEncoder();
    m_stick = new Joystick(0);

    m_motor.getEncoder().setPosition(0);
  }

  @Override
  public void teleopPeriodic() {
    m_motor.set(m_stick.getRawAxis(0) * 0.3);

    double speed = Math.round(m_encoder.getVelocity() * 1.0) / 1.0;


    System.out.print(m_stick.getRawAxis(0) + ",   ");
    System.out.print(m_encoder.getPosition() + ",   ");
    System.out.println(speed);
  }
}