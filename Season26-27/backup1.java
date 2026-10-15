package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

public class JeremySenior {
    // Drive Motors
    private DcMotor FrontLeft;
    private DcMotor FrontRight;
    private DcMotor BackLeft;
    private DcMotor Backright;
    double Multiplier = 1.0;

    // Intake Motor
    private DcMotor IntakeMotor;
    double IntakeSpeed = 1.0; // May be the wrong indentation, if needs be change to into opModeIsActive()

    // Outtake Motor/Servo (Change if Servo)
    private DcMotor OuttakeMotor;
    double OuttakeSpeed = 0.5; // May be the wrong indentation, if needs be change to into opModeIsActive()

    
    public void runOpMode() {
        // Drive (gamepad1)
        double y = -gamepad1.LeftStickY;
        double x = gamepad1.LeftStickX;
        double rx = gamepad1.RightStickY;
           
        frontLeft.power(((y+x)+rx)*Multiplier);
        backLeft.power(((y-x)+rx)*Multiplier);
        frontRight.power(((y-x)-rx)*Multiplier);
        backRight.power(((y+x)-rx)*Multiplier);

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

        // One-Time Outtake Press
        // Click once to make it launch
        // Have to launch again by pressing button again
        if (gamepad2.x) { // Our Square button - Held down NOT toggled like IntakeMotor
            // Assuming the OuttakeMotor object is a motor, may need to be changed if a servo is needed
            OuttakeMotor.power(OuttakeSpeed);
        } else {
            OuttakeMotor.power(0);
        }

        // Acts as a handbrake for sudden stopping.
        if (gamepad1.right_trigger) {
            Multiplier = 0;
        } else {
            Multiplier = 1.0;
        }

        // Overall Stopping Control (secret command shhhh!)
        // May need work
        if (gamepad1.start || gamepad2.start) {
                Multiplier = 0;
                IntakeSpeed = 0;
                OuttakeSpeed = 0;
        }
    }
}
