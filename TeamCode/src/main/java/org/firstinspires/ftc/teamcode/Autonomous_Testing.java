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

        int rwheel = 0;
        int lwheel = 0;
        int rbwheel = 0;
        int lbwheel = 0;
        int S_distance = 0;  // Slider distance
        int S_distance_max = 1500;  // Slider distance max
        int S_speed = 100;
        int EI_distance = 0;  // EI distance00
        int EI_distance_max = 1500;
        int EI_speed = 100;
        int SR_distance = 0;  // SliderRotate distance
        int SR_distance_max = 1550;  // SliderRotate distance max
        int SR_speed = 50;
        int distance_min = 0;
        double turnspeed = 0.6;
        double movementspeed = 1;

        robot.Spintake.setPower(0.25);
        robot.Spangle.setPosition(0.0);


        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        //Forward Backward Left Right, 50 = 1 inch
        //Turning, x * 10 = x degrees

////      Robot Doesnt Move
//        robot.leftMotorback.setTargetPosition(wheel_position);
//        robot.leftMotorfront.setTargetPosition(wheel_position);
//        robot.rightMotorback.setTargetPosition(wheel_position);
//        robot.rightMotorfront.setTargetPosition(wheel_position);
//        robot.leftMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        robot.leftMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        robot.rightMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        robot.rightMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        robot.leftMotorback.setPower(1);
//        robot.leftMotorfront.setPower(1);
//        robot.rightMotorback.setPower(1);
//        robot.rightMotorfront.setPower(1);

        robot.Spintake.setPower(0.25);
        robot.Spangle.setPosition(0.275);

        //strafe left

        rwheel -= 1200;
        lwheel += 1200;
        rbwheel += 1200;
        lbwheel -= 1200;
        robot.leftMotorback.setTargetPosition(lbwheel);
        robot.leftMotorfront.setTargetPosition(lwheel);
        robot.rightMotorback.setTargetPosition(rbwheel);
        robot.rightMotorfront.setTargetPosition(rwheel);
        robot.leftMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorback.setPower(0.25);
        robot.leftMotorfront.setPower(0.25);
        robot.rightMotorback.setPower(0.25);
        robot.rightMotorfront.setPower(0.25);

        sleep(2000);

        //turn towards basket

        rwheel -= 450;
        lwheel += 450;
        rbwheel -= 450;
        lbwheel += 450;
        robot.leftMotorback.setTargetPosition(lbwheel);
        robot.leftMotorfront.setTargetPosition(lwheel);
        robot.rightMotorback.setTargetPosition(rbwheel);
        robot.rightMotorfront.setTargetPosition(rwheel);
        robot.leftMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorback.setPower(0.25);
        robot.leftMotorfront.setPower(0.25);
        robot.rightMotorback.setPower(0.25);
        robot.rightMotorfront.setPower(0.25);

        sleep(1000);

        //set to high basket position

        SR_distance = SR_distance_max;
        S_distance = 900;
        robot.SliderRotate.setTargetPosition(SR_distance);
        robot.SliderRotate.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.RSlider.setTargetPosition(S_distance);
        robot.RSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.LSlider.setTargetPosition(S_distance);
        robot.LSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.SliderRotate.setPower(0.75);
        robot.RSlider.setPower(0.75);
        robot.LSlider.setPower(0.75);
        robot.Spintake.setPower(0.25);
        robot.Spangle.setPosition(0.275);

        sleep(1000);

        EI_distance = 1500;
        robot.ExtendingIntake.setTargetPosition(EI_distance);
        robot.ExtendingIntake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.ExtendingIntake.setPower(1);

        sleep(750);

        //move towards basket

        rwheel -= 775;
        lwheel -= 775;
        rbwheel -= 775;
        lbwheel -= 775;
        robot.leftMotorback.setTargetPosition(lbwheel);
        robot.leftMotorfront.setTargetPosition(lwheel);
        robot.rightMotorback.setTargetPosition(rbwheel);
        robot.rightMotorfront.setTargetPosition(rwheel);
        robot.leftMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorback.setPower(0.25);
        robot.leftMotorfront.setPower(0.25);
        robot.rightMotorback.setPower(0.25);
        robot.rightMotorfront.setPower(0.25);

        sleep(2250);

        //score sample

        robot.Spintake.setPower(-1);

        sleep(250);

        //prevent outtake from getting stuck

        robot.Spangle.setPosition(0.8);
        robot.Spintake.setPower(0);

        //Move away from basket

        rwheel += 250;
        lwheel += 250;
        rbwheel += 250;
        lbwheel += 250;
        robot.leftMotorback.setTargetPosition(lbwheel);
        robot.leftMotorfront.setTargetPosition(lwheel);
        robot.rightMotorback.setTargetPosition(rbwheel);
        robot.rightMotorfront.setTargetPosition(rwheel);
        robot.leftMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorback.setPower(0.25);
        robot.leftMotorfront.setPower(0.25);
        robot.rightMotorback.setPower(0.25);
        robot.rightMotorfront.setPower(0.25);

        sleep(900);

        //bring everything down

        robot.Spangle.setPosition(0.35);
        EI_distance = 0;
        SR_distance = 0;
        S_distance = 0;
        robot.ExtendingIntake.setTargetPosition(EI_distance);
        robot.ExtendingIntake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.SliderRotate.setTargetPosition(SR_distance);
        robot.SliderRotate.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.RSlider.setTargetPosition(S_distance);
        robot.RSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.LSlider.setTargetPosition(S_distance);
        robot.LSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.RSlider.setPower(0.25);
        robot.LSlider.setPower(0.25);
        robot.SliderRotate.setPower(0.5);
        robot.ExtendingIntake.setPower(1);
        robot.Spintake.setPower(0);

        sleep(250);

        //turn to become 110 degrees

        rwheel -= 650;
        lwheel += 650;
        rbwheel -= 650;
        lbwheel += 650;
        robot.leftMotorback.setTargetPosition(lbwheel);
        robot.leftMotorfront.setTargetPosition(lwheel);
        robot.rightMotorback.setTargetPosition(rbwheel);
        robot.rightMotorfront.setTargetPosition(rwheel);
        robot.leftMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorback.setPower(0.25);
        robot.leftMotorfront.setPower(0.25);
        robot.rightMotorback.setPower(0.25);
        robot.rightMotorfront.setPower(0.25);

        sleep(1000);

        //Extend

        EI_distance = 1300;
        robot.ExtendingIntake.setTargetPosition(EI_distance);
        robot.ExtendingIntake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.ExtendingIntake.setPower(1);
        robot.Spintake.setPower(1);
        robot.Spangle.setPosition(0.8);

        sleep(500);

        //collect right sample

        rwheel += 400;
        lwheel -= 400;
        rbwheel += 400;
        lbwheel -= 400;
        robot.leftMotorback.setTargetPosition(lbwheel);
        robot.leftMotorfront.setTargetPosition(lwheel);
        robot.rightMotorback.setTargetPosition(rbwheel);
        robot.rightMotorfront.setTargetPosition(rwheel);
        robot.leftMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorback.setPower(0.1);
        robot.leftMotorfront.setPower(0.1);
        robot.rightMotorback.setPower(0.1);
        robot.rightMotorfront.setPower(0.1);

        sleep(2000);

        //bring everything back

        robot.Spangle.setPosition(0.35);
        EI_distance = 0;
        SR_distance = 0;
        S_distance = 0;
        robot.ExtendingIntake.setTargetPosition(EI_distance);
        robot.ExtendingIntake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.SliderRotate.setTargetPosition(SR_distance);
        robot.SliderRotate.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.RSlider.setTargetPosition(S_distance);
        robot.RSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.LSlider.setTargetPosition(S_distance);
        robot.LSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.RSlider.setPower(0.25);
        robot.LSlider.setPower(0.25);
        robot.Spangle.setPosition(0.35);
        robot.SliderRotate.setPower(0.5);
        robot.ExtendingIntake.setPower(1);
        robot.Spintake.setPower(0);

        //Finish turning to align with basket

        rwheel += 250;
        lwheel -= 250;
        rbwheel += 250;
        lbwheel -= 250;
        robot.leftMotorback.setTargetPosition(lbwheel);
        robot.leftMotorfront.setTargetPosition(lwheel);
        robot.rightMotorback.setTargetPosition(rbwheel);
        robot.rightMotorfront.setTargetPosition(rwheel);
        robot.leftMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorback.setPower(0.25);
        robot.leftMotorfront.setPower(0.25);
        robot.rightMotorback.setPower(0.25);
        robot.rightMotorfront.setPower(0.25);

        sleep(500);

        //set to high basket position

        SR_distance = SR_distance_max;
        S_distance = 1000;
        robot.SliderRotate.setTargetPosition(SR_distance);
        robot.SliderRotate.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.RSlider.setTargetPosition(S_distance);
        robot.RSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.LSlider.setTargetPosition(S_distance);
        robot.LSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.SliderRotate.setPower(0.75);
        robot.RSlider.setPower(0.75);
        robot.LSlider.setPower(0.75);
        robot.Spintake.setPower(0.25);
        robot.Spangle.setPosition(0.275);

        sleep(750);

        EI_distance = 1500;
        robot.ExtendingIntake.setTargetPosition(EI_distance);
        robot.ExtendingIntake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.ExtendingIntake.setPower(1);

        sleep(750);

        //Move towards basket for second sample

        rwheel -= 200;
        lwheel -= 200;
        rbwheel -= 200;
        lbwheel -= 200;
        robot.leftMotorback.setTargetPosition(lbwheel);
        robot.leftMotorfront.setTargetPosition(lwheel);
        robot.rightMotorback.setTargetPosition(rbwheel);
        robot.rightMotorfront.setTargetPosition(rwheel);
        robot.leftMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorback.setPower(0.25);
        robot.leftMotorfront.setPower(0.25);
        robot.rightMotorback.setPower(0.25);
        robot.rightMotorfront.setPower(0.25);

        sleep(1200);

        //score sample

        robot.Spintake.setPower(-1);

        sleep(250);

        //prevent outtake from getting stuck

        robot.Spangle.setPosition(0.8);
        robot.Spintake.setPower(0);

        //Move away from basket

        rwheel += 250;
        lwheel += 250;
        rbwheel += 250;
        lbwheel += 250;
        robot.leftMotorback.setTargetPosition(lbwheel);
        robot.leftMotorfront.setTargetPosition(lwheel);
        robot.rightMotorback.setTargetPosition(rbwheel);
        robot.rightMotorfront.setTargetPosition(rwheel);
        robot.leftMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorback.setPower(0.25);
        robot.leftMotorfront.setPower(0.25);
        robot.rightMotorback.setPower(0.25);
        robot.rightMotorfront.setPower(0.25);

        sleep(750);

        //bring everything down

        robot.Spangle.setPosition(0.35);
        EI_distance = 0;
        SR_distance = 0;
        S_distance = 0;
        robot.ExtendingIntake.setTargetPosition(EI_distance);
        robot.ExtendingIntake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.SliderRotate.setTargetPosition(SR_distance);
        robot.SliderRotate.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.RSlider.setTargetPosition(S_distance);
        robot.RSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.LSlider.setTargetPosition(S_distance);
        robot.LSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.RSlider.setPower(0.5);
        robot.LSlider.setPower(0.5);
        robot.SliderRotate.setPower(0.5);
        robot.ExtendingIntake.setPower(1);
        robot.Spintake.setPower(0);

        //turn to become 105 degrees

        rwheel -= 600;
        lwheel += 600;
        rbwheel -= 600;
        lbwheel += 600;
        robot.leftMotorback.setTargetPosition(lbwheel);
        robot.leftMotorfront.setTargetPosition(lwheel);
        robot.rightMotorback.setTargetPosition(rbwheel);
        robot.rightMotorfront.setTargetPosition(rwheel);
        robot.leftMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorback.setPower(0.25);
        robot.leftMotorfront.setPower(0.25);
        robot.rightMotorback.setPower(0.25);
        robot.rightMotorfront.setPower(0.25);

        sleep(2500);

        //Extend

        EI_distance = 1300;
        robot.ExtendingIntake.setTargetPosition(EI_distance);
        robot.ExtendingIntake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.ExtendingIntake.setPower(1);
        robot.Spintake.setPower(1);
        robot.Spangle.setPosition(0.8);

        sleep(750);

        //Move away from basket

        rwheel += 100;
        lwheel += 100;
        rbwheel += 100;
        lbwheel += 100;
        robot.leftMotorback.setTargetPosition(lbwheel);
        robot.leftMotorfront.setTargetPosition(lwheel);
        robot.rightMotorback.setTargetPosition(rbwheel);
        robot.rightMotorfront.setTargetPosition(rwheel);
        robot.leftMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorback.setPower(0.15);
        robot.leftMotorfront.setPower(0.25);
        robot.rightMotorback.setPower(0.25);
        robot.rightMotorfront.setPower(0.25);

        sleep(1000);

        //turn to become 135 degrees

        rwheel -= 300;
        lwheel += 300;
        rbwheel -= 300;
        lbwheel += 300;
        robot.leftMotorback.setTargetPosition(lbwheel);
        robot.leftMotorfront.setTargetPosition(lwheel);
        robot.rightMotorback.setTargetPosition(rbwheel);
        robot.rightMotorfront.setTargetPosition(rwheel);
        robot.leftMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorback.setPower(0.15);
        robot.leftMotorfront.setPower(0.15);
        robot.rightMotorback.setPower(0.15);
        robot.rightMotorfront.setPower(0.15);

        sleep(1500);

        //bring everything down

        robot.Spangle.setPosition(0.35);
        EI_distance = 0;
        SR_distance = 0;
        S_distance = 0;
        robot.ExtendingIntake.setTargetPosition(EI_distance);
        robot.ExtendingIntake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.SliderRotate.setTargetPosition(SR_distance);
        robot.SliderRotate.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.RSlider.setTargetPosition(S_distance);
        robot.RSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.LSlider.setTargetPosition(S_distance);
        robot.LSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.RSlider.setPower(0.5);
        robot.LSlider.setPower(0.5);
        robot.SliderRotate.setPower(0.5);
        robot.ExtendingIntake.setPower(1);
        robot.Spintake.setPower(0);

        sleep(500);

        //Go back to allign
        telemetry.addData("Say", "RMF running at"+ robot.rightMotorfront.getPower());
            telemetry.addData("Say", "RMB running at"+ robot.rightMotorback.getPower());
            telemetry.addData("Say", "LMF running at"+ robot.leftMotorfront.getPower());
            telemetry.addData("Say", "LMB running at"+ robot.leftMotorback.getPower());
            telemetry.update();

            // Pace this loop so jaw action is reasonable 0.5.
            sleep(500);


    }
}
