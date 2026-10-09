package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Jeremy", group="Base");
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

    
    public void runOpMode() {
        while (opModeIsActive()) {
            // Drive (gamepad1)
            float y = -gamepad1.LeftStickY;
            float x = gamepad1.LeftStickX;
            float rx = gamepad1.RightStickY;
            
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
                } else {
                    isIntakeOn = true;
                    IntakeMotor.speed(0);
                }
            }
        }
    }
}
