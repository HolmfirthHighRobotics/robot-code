package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="JeremySenior", group="Base");
public class JeremySenior extends LinearOpMode {
    // Drive Motors
    private DcMotor FrontLeft;
    private DcMotor FrontRight;
    private DcMotor BackLeft;
    private DcMotor Backright;

    // Intake Motor
    private DcMotor IntakeMotor;
    double IntakeSpeed = 1.0; // May be the wrong indentation, if needs be change to into opModeIsActive()

    // Outtake Motor/Servo (Change if Servo)
    private DcMotor OuttakeMotor;
    double OuttakeSpeed = 0.5; // May be the wrong indentation, if needs be change to into opModeIsActive()

    
    public void runOpMode() {
        while (opModeIsActive()) {
            // Drive (gamepad1)
            double y = -gamepad1.LeftStickY;
            double x = gamepad1.LeftStickX;
            double rx = gamepad1.RightStickY;
            
            frontLeft.power((y+x)+rx);
            backLeft.power((y-x)+rx);
            frontRight.power((y-x)-rx);
            backRight.power((y+x)-rx);

            // Toggle Intake (gamepad2)
            bool isIntakeOn = true;
            if (gamepad2.left_bumper) {
                if (isIntakeOn) {
                    isIntakeOn = false;
                    IntakeMotor.speed(IntakeSpeed);
                    telemetry.addLine("Intake Off!");
                } else {
                    isIntakeOn = true;
                    IntakeMotor.speed(0);
                    telemetry.addLine("Intake Off!");
                }
            }

            // One-Time Outtake Press
            // Click once to make it launch
            // Have to launch again by pressing button again
            if (gamepad2.x) { // Our Square button - Held down NOT toggled like IntakeMotor
                // Assuming the OuttakeMotor object is a motor, may need to be changed if a servo is needed
                OuttakeMotor.power(OuttakeSpeed);
                
                telemetry.addLine("Outtake Button Pressed!");
            } else {
                OuttakeMotor.power(0);
            }

            telemetry.update();
        }
    }
}
