package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Jeremy", group="Base")
public class JeremySenior extends LinearOpMode {
    // Drive Motors
    private DcMotor FrontLeft;
    private DcMotor FrontRight;
    private DcMotor BackLeft;
    private DcMotor Backright;

    // Intake Motor
    private DcMotor IntakeMotor;

    // Outtake Motor/Servo (Change if Servo)
    private DcMotor OuttakeMotor
    
    public void runOpMode() {
        while (opModeIsActive()) {
            // Drive
            float y = -gamepad1.LeftStickY
            float x = gamepad1.LeftStickX
            float rx = gamepad1.RightStickY
        }
    }
}
