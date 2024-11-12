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
        int SR_distance_max = 1600;  // SliderRotate distance max
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

        //move forward

        rwheel += 950;
        lwheel += 950;
        rbwheel += 950;
        lbwheel += 950;
        robot.leftMotorback.setTargetPosition(lbwheel);
        robot.leftMotorfront.setTargetPosition(lwheel);
        robot.rightMotorback.setTargetPosition(rbwheel);
        robot.rightMotorfront.setTargetPosition(rwheel);
        robot.leftMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorback.setPower(.9);
        robot.leftMotorfront.setPower(.9);
        robot.rightMotorback.setPower(.9);
        robot.rightMotorfront.setPower(.9);

        sleep(1000);

        //turn towards basket

        rwheel += 470;
        lwheel -= 470;
        rbwheel += 470;
        lbwheel -= 470;
        robot.leftMotorback.setTargetPosition(lbwheel);
        robot.leftMotorfront.setTargetPosition(lwheel);
        robot.rightMotorback.setTargetPosition(rbwheel);
        robot.rightMotorfront.setTargetPosition(rwheel);
        robot.leftMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorback.setPower(0.5);
        robot.leftMotorfront.setPower(0.5);
        robot.rightMotorback.setPower(0.5);
        robot.rightMotorfront.setPower(0.5);


        //set to high basket position

        SR_distance = SR_distance_max;
        robot.SliderRotate.setTargetPosition(SR_distance);
        robot.SliderRotate.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.SliderRotate.setPower(0.75);
        robot.Spintake.setPower(0.25);
        robot.Spangle.setPosition(0.275);

        sleep(900);

        EI_distance = 1400;
        S_distance = 1000;
        robot.RSlider.setTargetPosition(S_distance);
        robot.RSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.LSlider.setTargetPosition(S_distance);
        robot.LSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.ExtendingIntake.setTargetPosition(EI_distance);
        robot.ExtendingIntake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.RSlider.setPower(0.75);
        robot.LSlider.setPower(0.75);
        robot.ExtendingIntake.setPower(1);

        sleep(500);

        //move towards basket

        rwheel -= 725;
        lwheel -= 725;
        rbwheel -= 725;
        lbwheel -= 725;
        robot.leftMotorback.setTargetPosition(lbwheel);
        robot.leftMotorfront.setTargetPosition(lwheel);
        robot.rightMotorback.setTargetPosition(rbwheel);
        robot.rightMotorfront.setTargetPosition(rwheel);
        robot.leftMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorback.setPower(0.3);
        robot.leftMotorfront.setPower(0.3);
        robot.rightMotorback.setPower(0.3);
        robot.rightMotorfront.setPower(0.3);

        sleep(1000);

        //score sample

        robot.Spintake.setPower(-1);

        sleep(250);
        //prevent outtake from getting stuck

        robot.Spangle.setPosition(0.8);
        robot.Spintake.setPower(0);

        //Move away from basket

        sleep(250);
        rwheel += 50;
        lwheel += 50;
        rbwheel += 50;
        lbwheel += 50;
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

        rwheel -= 550;
        lwheel += 550;
        rbwheel -= 550;
        lbwheel += 550;
        robot.leftMotorback.setTargetPosition(lbwheel);
        robot.leftMotorfront.setTargetPosition(lwheel);
        robot.rightMotorback.setTargetPosition(rbwheel);
        robot.rightMotorfront.setTargetPosition(rwheel);
        robot.leftMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorback.setPower(0.4);
        robot.leftMotorfront.setPower(0.4);
        robot.rightMotorback.setPower(0.4);
        robot.rightMotorfront.setPower(0.4);

        sleep(1200);

        //Extend

        EI_distance = 1550;
        robot.ExtendingIntake.setTargetPosition(EI_distance);
        robot.ExtendingIntake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.ExtendingIntake.setPower(1);
        robot.Spintake.setPower(1);
        robot.Spangle.setPosition(0.8);

        sleep(1200);

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
        robot.leftMotorback.setPower(0.05);
        robot.leftMotorfront.setPower(0.05);
        robot.rightMotorback.setPower(0.05);
        robot.rightMotorfront.setPower(0.05);

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

        rwheel += 100;
        lwheel -= 100;
        rbwheel += 100;
        lbwheel -= 100;
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

        sleep(250);

        //set to high basket position

        SR_distance = SR_distance_max;
        robot.SliderRotate.setTargetPosition(SR_distance);
        robot.SliderRotate.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.SliderRotate.setPower(0.75);
        robot.Spintake.setPower(0.25);
        robot.Spangle.setPosition(0.275);

        sleep(1000);

        EI_distance = 1400;
        S_distance = 1000;
        robot.ExtendingIntake.setTargetPosition(EI_distance);
        robot.ExtendingIntake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.RSlider.setTargetPosition(S_distance);
        robot.RSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.LSlider.setTargetPosition(S_distance);
        robot.LSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.RSlider.setPower(0.75);
        robot.LSlider.setPower(0.75);
        robot.ExtendingIntake.setPower(1);

        sleep(750);

        //Move towards basket for second sample

        rwheel -= 50;
        lwheel -= 50;
        rbwheel -= 50;
        lbwheel -= 50;
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

        sleep(900);

        //score sample

        robot.Spintake.setPower(-1);

        sleep(250);

        //prevent outtake from getting stuck

        robot.Spangle.setPosition(0.8);
        robot.Spintake.setPower(0);

        //Move away from basket

        rwheel += 200;
        lwheel += 200;
        rbwheel += 200;
        lbwheel += 200;
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

        //turn to become 115 degrees

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
        robot.leftMotorback.setPower(0.5);
        robot.leftMotorfront.setPower(0.5);
        robot.rightMotorback.setPower(0.5);
        robot.rightMotorfront.setPower(0.5);

        sleep(1000);

        //Extend

        EI_distance = 1550;
        robot.ExtendingIntake.setTargetPosition(EI_distance);
        robot.ExtendingIntake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.ExtendingIntake.setPower(1);
        robot.Spintake.setPower(1);
        robot.Spangle.setPosition(0.8);

        sleep(1000);

        //turn to pickup

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
        robot.leftMotorback.setPower(0.1);
        robot.leftMotorfront.setPower(0.1);
        robot.rightMotorback.setPower(0.1);
        robot.rightMotorfront.setPower(0.1);

        sleep(1500);

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
        robot.RSlider.setPower(0.5);
        robot.LSlider.setPower(0.5);
        robot.SliderRotate.setPower(0.5);
        robot.ExtendingIntake.setPower(1);
        robot.Spintake.setPower(0);

        sleep(500);

        //turn to become 45 degrees (aligned with basket)

        rwheel += 1150;
        lwheel -= 1150;
        rbwheel += 1150;
        lbwheel -= 1150;
        robot.leftMotorback.setTargetPosition(lbwheel);
        robot.leftMotorfront.setTargetPosition(lwheel);
        robot.rightMotorback.setTargetPosition(rbwheel);
        robot.rightMotorfront.setTargetPosition(rwheel);
        robot.leftMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftMotorback.setPower(0.5);
        robot.leftMotorfront.setPower(0.5);
        robot.rightMotorback.setPower(0.5);
        robot.rightMotorfront.setPower(0.5);

        //set to high basket position

        SR_distance = SR_distance_max;
        robot.SliderRotate.setTargetPosition(SR_distance);
        robot.SliderRotate.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.SliderRotate.setPower(0.75);
        robot.Spintake.setPower(0.25);
        robot.Spangle.setPosition(0.275);

        sleep(1500);

        EI_distance = 1400;
        S_distance = 1000;
        robot.ExtendingIntake.setTargetPosition(EI_distance);
        robot.ExtendingIntake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.RSlider.setTargetPosition(S_distance);
        robot.RSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.LSlider.setTargetPosition(S_distance);
        robot.LSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.RSlider.setPower(0.75);
        robot.LSlider.setPower(0.75);
        robot.ExtendingIntake.setPower(1);

        sleep(750);

        //Move towards basket for second sample

        rwheel -= 400;
        lwheel -= 400;
        rbwheel -= 400;
        lbwheel -= 400;
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

        sleep(500);

        //score sample

        robot.Spintake.setPower(-1);

        sleep(250);

        //prevent outtake from getting stuck

        robot.Spangle.setPosition(0.8);
        robot.Spintake.setPower(0);

        //Move away from basket

        rwheel += 350;
        lwheel += 350;
        rbwheel += 350;
        lbwheel += 350;
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

    }
}
