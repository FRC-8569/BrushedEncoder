//install url
//https://software-metadata.revrobotics.com/REVLib-2023.json

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
  private Joystick m_stick;
  private CANSparkMax m_motor1;
  private CANSparkMax m_motor2;
  private RelativeEncoder m_encoder1;
  private RelativeEncoder m_encoder2;

  @Override
  public void robotInit() {
    m_motor1 = new CANSparkMax(1, MotorType.kBrushless);
    m_motor1.restoreFactoryDefaults();
    m_encoder1 = m_motor1.getEncoder();
    m_encoder1.setPosition(0);

    m_motor2 = new CANSparkMax(2, MotorType.kBrushed);
    m_motor2.restoreFactoryDefaults();
    m_encoder2 = m_motor2.getEncoder(SparkMaxRelativeEncoder.Type.kQuadrature, 8192);
    m_encoder2.setPosition(0);

    m_stick = new Joystick(0);
  }

  @Override
  public void teleopPeriodic() {
    double motorPos1 = m_encoder1.getPosition();
    double motorSpd1 = m_encoder1.getVelocity();
    double motorPos2 = m_encoder2.getPosition();
    double motorSpd2 = m_encoder2.getVelocity();

    m_motor1.set(m_stick.getRawAxis(0) * 0.3);
    m_motor2.set(m_stick.getRawAxis(0) * 0.3);

    SmartDashboard.putNumber("motorPos1", motorPos1);
    SmartDashboard.putNumber("motorSpd1", motorSpd1);
    SmartDashboard.putNumber("motorPos2", motorPos2);
    SmartDashboard.putNumber("motorSpd2", motorSpd2);
  }
}