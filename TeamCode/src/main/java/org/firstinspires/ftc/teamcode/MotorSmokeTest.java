package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * 01 Motor Smoke Test - Rookie Drivetrain Verification
 * Safety Rule: Keep the robot elevated on a box or blocks so the wheels
 * are completely off the floor during this test!
 */
@TeleOp(name = "01 Motor Smoke Test", group = "Learning")
public class MotorSmokeTest extends LinearOpMode {

    @Override
    public void runOpMode() {
        // 1. Hardware Mapping: Names must match your Driver Station config exactly!
        DcMotor leftMotor = hardwareMap.get(DcMotor.class, "leftDrive");
        DcMotor rightMotor = hardwareMap.get(DcMotor.class, "rightDrive");

        // 2. Set Brake Mode so wheels stop promptly rather than coasting
        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // 3. Pre-Start Safety Telemetry (shown on Driver Station screen)
        telemetry.addLine("==========================================");
        telemetry.addLine("STATUS: READY FOR MOTOR SMOKE TEST");
        telemetry.addLine("SAFETY: Ensure robot wheels are OFF THE GROUND!");
        telemetry.addLine("Press PLAY to begin the 1-second pulse test.");
        telemetry.addLine("==========================================");
        telemetry.update();

        // Wait until driver touches the triangular PLAY button on Driver Station
        waitForStart();

        if (opModeIsActive()) {
            // --- TEST 1: Left Motor Pulse ---
            telemetry.addLine("TESTING: Left Motor spinning forward (0.20 power)...");
            telemetry.update();
            leftMotor.setPower(0.20);
            sleep(1000); // Run for 1.0 second
            leftMotor.setPower(0.0);

            // 1-second safety pause between tests
            telemetry.addLine("PAUSE: Checking Left Motor stop...");
            telemetry.update();
            sleep(1000);

            // --- TEST 2: Right Motor Pulse ---
            telemetry.addLine("TESTING: Right Motor spinning forward (0.20 power)...");
            telemetry.update();
            rightMotor.setPower(0.20);
            sleep(1000); // Run for 1.0 second
            rightMotor.setPower(0.0);

            // --- Test Complete ---
            telemetry.addLine("==========================================");
            telemetry.addLine("SUCCESS: Both motors completed pulse test!");
            telemetry.addLine("Press STOP on Driver Station.");
            telemetry.addLine("==========================================");
            telemetry.update();

            // Keep status message visible until driver presses STOP
            while (opModeIsActive()) {
                idle();
            }
        }
    }
}
