package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="TELEOP___GAME1", group="Team Code")
//@Disabled

public class TELEOP_GAME1 extends LinearOpMode {

    /* Declare OpMode members. */
    HardwareMap_imintoodeep robot = new HardwareMap_imintoodeep();
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {


        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        robot.leftMotorfront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.rightMotorfront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.leftMotorback.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.rightMotorback.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        robot.SliderRotate.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.RSlider.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.LSlider.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.ExtendingIntake.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        int S_distance = 0;  // Slider distance
        int S_distance_max = 1000;  // Slider distance max
        int S_speed = 100;
        int EI_distance = 0;  // EI distance00
        int EI_distance_max = 1500;
        int EI_speed = 100;
        int SR_distance = 0;  // SliderRotate distance
        int SR_distance_max = 1550;  // SliderRotate distance max
        int SR_speed = 50;
        int distance_min = 0;


        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Run wheels in POV mode (note: The joystick goes negative when pushed forwards, so negate it)
            // In this mode the Left stick moves the robot fwd and back, the Right stick turns left and right.
            // This way it's also easy to just drive straight, or just turn.

//            int SS_distance = sliderspin.getCurrentPosition();

            if (gamepad1.dpad_left) {
                robot.leftMotorfront.setPower(-.7);
                robot.leftMotorback.setPower(.7);
                robot.rightMotorfront.setPower(.7);
                robot.rightMotorback.setPower(-.7);
                telemetry.addData("Say", "Robot is moving left");
            }
            else if (gamepad1.dpad_right) {
                robot.leftMotorfront.setPower(.7);
                robot.leftMotorback.setPower(-.7);
                robot.rightMotorfront.setPower(-.7);
                robot.rightMotorback.setPower(.7);
                telemetry.addData("Say", "Robot is moving right");
            }
            else if(gamepad1.dpad_up) {
                robot.leftMotorback.setPower(.7);
                robot.rightMotorfront.setPower(.7);
                robot.rightMotorback.setPower(.7);
                robot.leftMotorfront.setPower(.7);
                telemetry.addData("Say", "Robot is moving up");
            }
            else if(gamepad1.dpad_down) {
                robot.leftMotorback.setPower(-.7);
                robot.rightMotorfront.setPower(-.7);
                robot.rightMotorback.setPower(-.7);
                robot.leftMotorfront.setPower(-.7);
                telemetry.addData("Say", "Robot is moving down");
            }
            else if (gamepad1.right_bumper) {
                robot.leftMotorfront.setPower(0.3);
                robot.leftMotorback.setPower(0.3);
                robot.rightMotorfront.setPower(-0.3);
                robot.rightMotorback.setPower(-0.3);
                telemetry.addData("Say", "Robot is rotating right");
            }
            else if (gamepad1.left_bumper) {
                robot.leftMotorfront.setPower(-0.3);
                robot.leftMotorback.setPower(-0.3);
                robot.rightMotorfront.setPower(0.3);
                robot.rightMotorback.setPower(0.3   );
                telemetry.addData("Say", "Robot is rotating left");
            }
            else {
                robot.leftMotorback.setPower(0);
                robot.rightMotorfront.setPower(0);
                robot.rightMotorback.setPower(0);
                robot.leftMotorfront.setPower(0);
                telemetry.addData("Say", "Robot is stationary");
            }

//            Sliders

            if (gamepad1.y && S_distance < S_distance_max) {
                S_distance += S_speed;
                robot.RSlider.setTargetPosition(S_distance);
                robot.LSlider.setTargetPosition(S_distance);
                robot.RSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.LSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.RSlider.setPower(1);
                robot.LSlider.setPower(1);
            }
            if (gamepad1.a && S_distance > distance_min) {
                S_distance -= S_speed;
                robot.RSlider.setTargetPosition(S_distance);
                robot.LSlider.setTargetPosition(S_distance);
                robot.RSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.LSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.RSlider.setPower(1);
                robot.LSlider.setPower(1);
            }

            //            Extending Intake
            if (gamepad2.right_trigger == 1) {
                EI_distance = 1300;
                robot.ExtendingIntake.setTargetPosition(EI_distance);
                robot.ExtendingIntake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.ExtendingIntake.setPower(1);
                robot.Spintake.setPower(1);
            }
            if (gamepad2.left_trigger == 1) {
                EI_distance = 0;
                robot.ExtendingIntake.setTargetPosition(EI_distance);
                robot.ExtendingIntake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.ExtendingIntake.setPower(1);
                robot.Spangle.setPosition(0);
                robot.Spintake.setPower(0.25);
            }
            if (gamepad2.y && EI_distance < EI_distance_max) {
                EI_distance += EI_speed;
                robot.ExtendingIntake.setTargetPosition(EI_distance);
                robot.ExtendingIntake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.ExtendingIntake.setPower(1);
                robot.Spintake.setPower(0.25);
            }
            if (gamepad2.a && EI_distance > distance_min) {
                EI_distance -= EI_speed;
                robot.ExtendingIntake.setTargetPosition(EI_distance);
                robot.ExtendingIntake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.ExtendingIntake.setPower(1);
                robot.Spintake.setPower(0.25);
            }

            if (gamepad1.x) {
                SR_distance = SR_distance_max;
                robot.SliderRotate.setTargetPosition(SR_distance);
                robot.SliderRotate.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.SliderRotate.setPower(0.25);
            }
            if (gamepad1.b) {
                SR_distance = distance_min;
                robot.SliderRotate.setTargetPosition(SR_distance);
                robot.SliderRotate.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.SliderRotate.setPower(0.25);
            }

//            Slider Rotate
            if (gamepad2.x) {
                robot.Spintake.setPower(0);
            }
            if (gamepad2.b) {
                robot.Spangle.setPosition(0.2);
                sleep(100);
                robot.Spintake.setPower(-1);
            }
            if (gamepad2.right_bumper) {
                robot.Spangle.setPosition(0.8);
            }
            if (gamepad2.left_bumper) {
                robot.Spangle.setPosition(0);
            }


            telemetry.addData("EI Position", "EI position is "+ EI_distance);
            telemetry.addData("Slider Position", "Slider position is "+ S_distance);
            telemetry.addData("Rotate Position", "rotate position is "+ SR_distance);
            telemetry.addData("Say", "RMF running at"+ robot.rightMotorfront.getPower());
            telemetry.addData("Say", "RMB running at"+ robot.rightMotorback.getPower());
            telemetry.addData("Say", "LMF running at"+ robot.leftMotorfront.getPower());
            telemetry.addData("Say", "LMB running at"+ robot.leftMotorback.getPower());
            telemetry.update();

            // Pace this loop so jaw action is reasonable 0.5.
            sleep(50);

        }
    }
}