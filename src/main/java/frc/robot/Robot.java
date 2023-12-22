//install url
//https://software-metadata.revrobotics.com/REVLib-2023.json

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
  private double position;
  private double speed;

  @Override
  public void robotInit() {
    m_motor = new CANSparkMax(4, MotorType.kBrushless);
    m_stick = new Joystick(0);
    m_motor.restoreFactoryDefaults();
    m_encoder = m_motor.getEncoder();
    m_encoder.setPosition(0);
  }

  @Override
  public void teleopPeriodic() {
    m_motor.set(m_stick.getRawAxis(0) * 0.3);

    position = Math.round(m_encoder.getPosition() * 1000) / 1000;
    speed = Math.round(m_encoder.getVelocity() * 1000) / 1000;

    System.out.println("position: " + position + ", speed: " + speed);
  }
}