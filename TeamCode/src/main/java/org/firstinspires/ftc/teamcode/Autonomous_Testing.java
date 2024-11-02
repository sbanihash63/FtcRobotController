package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Autonomous_Testing", group="Autonomous")

public class Autonomous_Testing extends LinearOpMode {
    /* Declare OpMode members. */
    HardwareMap_imintoodeep robot = new HardwareMap_imintoodeep();
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {


        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        robot.leftMotorfront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightMotorfront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.leftMotorback.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightMotorback.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        robot.leftMotorfront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightMotorfront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.leftMotorback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightMotorback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.SliderRotate.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.RSlider.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.LSlider.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.ExtendingIntake.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.leftMotorfront.setDirection(DcMotor.Direction.FORWARD);
        robot.leftMotorback.setDirection(DcMotor.Direction.FORWARD);
        robot.rightMotorfront.setDirection(DcMotor.Direction.REVERSE);
        robot.rightMotorback.setDirection(DcMotor.Direction.REVERSE);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");
        telemetry.update();

        int wheel_position = 0;
        int wheel_speed = 2000;

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

//              Robot Doesnt Move
                robot.leftMotorback.setTargetPosition(wheel_position);
                robot.leftMotorfront.setTargetPosition(wheel_position);
                robot.rightMotorback.setTargetPosition(wheel_position);
                robot.rightMotorfront.setTargetPosition(wheel_position);
                robot.leftMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.leftMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.rightMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.rightMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.leftMotorback.setPower(1);
                robot.leftMotorfront.setPower(1);
                robot.rightMotorback.setPower(1);
                robot.rightMotorfront.setPower(1);

//              Robot Moves Forward
                wheel_position += wheel_speed;
                robot.leftMotorback.setTargetPosition(wheel_position);
                robot.leftMotorfront.setTargetPosition(wheel_position);
                robot.rightMotorback.setTargetPosition(wheel_position);
                robot.rightMotorfront.setTargetPosition(wheel_position);
                robot.leftMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.leftMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.rightMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.rightMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.leftMotorback.setPower(1);
                robot.leftMotorfront.setPower(1);
                robot.rightMotorback.setPower(1);
                robot.rightMotorfront.setPower(1);

            sleep(2500);

//              Robot Moves Forward
                wheel_position -= wheel_speed;
                robot.leftMotorback.setTargetPosition(wheel_position);
                robot.leftMotorfront.setTargetPosition(wheel_position);
                robot.rightMotorback.setTargetPosition(wheel_position);
                robot.rightMotorfront.setTargetPosition(wheel_position);
                robot.leftMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.leftMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.rightMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.rightMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.leftMotorback.setPower(1);
                robot.leftMotorfront.setPower(1);
                robot.rightMotorback.setPower(1);
                robot.rightMotorfront.setPower(1);

            sleep(2500);

            telemetry.addData("Say", "RMF running at"+ robot.rightMotorfront.getPower());
            telemetry.addData("Say", "RMB running at"+ robot.rightMotorback.getPower());
            telemetry.addData("Say", "LMF running at"+ robot.leftMotorfront.getPower());
            telemetry.addData("Say", "LMB running at"+ robot.leftMotorback.getPower());
            telemetry.update();

            // Pace this loop so jaw action is reasonable 0.5.
            sleep(500);


    }
}
