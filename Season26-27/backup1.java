package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "MecanumBase", group = "Base")
public class MecanumBase extends LinearOpMode {

    private DcMotor leftFront, rightFront, leftRear, rightRear;

    @Override
    public void runOpMode() throws InterruptedException {

        leftFront  = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        leftRear   = hardwareMap.get(DcMotor.class, "leftRear");
        rightRear  = hardwareMap.get(DcMotor.class, "rightRear");

        // Reverse left side (most drivetrains need this)
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftRear.setDirection(DcMotor.Direction.REVERSE);

        // Brake for tighter control
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addLine("Ready");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {

            double y = -gamepad1.left_stick_y;  // forward/back
            double x =  gamepad1.left_stick_x;  // strafe
            double r =  gamepad1.right_stick_x; // rotate

            double lf = y + x + r;
            double rf = y - x - r;
            double lr = y - x + r;
            double rr = y + x - r;

            double max = Math.max(Math.max(Math.abs(lf), Math.abs(rf)),
                                  Math.max(Math.abs(lr), Math.abs(rr)));

            if (max > 1.0) {
                lf /= max;
                rf /= max;
                lr /= max;
                rr /= max;
            }

            leftFront.setPower(lf);
            rightFront.setPower(rf);
            leftRear.setPower(lr);
            rightRear.setPower(rr);

            telemetry.addData("LF", lf);
            telemetry.addData("RF", rf);
            telemetry.addData("LR", lr);
            telemetry.addData("RR", rr);
            telemetry.update();
        }
    }
}
