package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

public class HardwareMap_imintoodeep {

    // Local OpMode members
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    // Public OpMode members
    public DcMotor leftMotorfront    = null;
    public DcMotor rightMotorfront   = null;
    public DcMotor rightMotorback    = null;
    public DcMotor leftMotorback     = null;
    public DcMotor SliderRotate     = null;
//    public Servo Claw                = null;
//    public Servo ClawSpin            = null;
//    public Servo Lintake             = null;
//    public Servo Rintake             = null;
    public CRServo Spintake              = null;
    public Servo Spangle              = null;
//    public Servo Ramp2               = null;
//    public Servo Ramp3               = null;
//    public Servo Roller              = null;
//    public Servo DroneLauncher              = null;
    public DcMotor LSlider        = null;
    public DcMotor RSlider       = null;
    public DcMotor ExtendingIntake   = null;
//
//    public final static double Claw_Home       =  0 ;
//    public final static double Claw_MIN_RANGE    =  0 ;
//    public final static double Claw_MAX_RANGE  = 0.1 ;
    //public final static double ClawSpin_Home       =   ;
    //public final static double ClawSpin_MIN_RANGE    =   ;
    //public final static double ClawSpin_MAX_RANGE  =  ;

    /* Constructor */
    public HardwareMap_imintoodeep() {

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap hardwareMap) {
        // Save reference to Hardware map
        hwMap = hardwareMap;

        // Define and Initialize Motors
        leftMotorfront  = hwMap.get(DcMotor.class, "LMF");
        leftMotorback  = hwMap.get(DcMotor.class, "LMB");
        rightMotorfront = hwMap.get(DcMotor.class, "RMF");
        rightMotorback = hwMap.get(DcMotor.class, "RMB");
        SliderRotate = hwMap.get(DcMotor.class, "SR");
        LSlider = hwMap.get(DcMotor.class, "LS");
        RSlider = hwMap.get(DcMotor.class, "RS");
        ExtendingIntake = hwMap.get(DcMotor.class, "EI");

        // Set all motors to zero power
        leftMotorfront.setPower(0);
        leftMotorback.setPower(0);
        rightMotorfront.setPower(0);
        rightMotorback.setPower(0);
        SliderRotate.setPower(0);
        LSlider.setPower(0);
        RSlider.setPower(0);
        ExtendingIntake.setPower(0);

        // Set all motors to run with encoders
        SliderRotate.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LSlider.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RSlider.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ExtendingIntake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftMotorfront.setDirection(DcMotor.Direction.REVERSE);
        leftMotorback.setDirection(DcMotor.Direction.REVERSE);
        rightMotorfront.setDirection(DcMotor.Direction.FORWARD);
        rightMotorback.setDirection(DcMotor.Direction.FORWARD);
        SliderRotate.setDirection(DcMotor.Direction.REVERSE);
        RSlider.setDirection(DcMotor.Direction.FORWARD);
        LSlider.setDirection(DcMotor.Direction.REVERSE);
        ExtendingIntake.setDirection(DcMotor.Direction.REVERSE);


        // Define and initialize ALL installed servos.
//        Claw = hwMap.servo.get("Claw"); //set equal to name or the servomotor in the phone
//        Claw.setPosition(Claw_Home); //setPosition actually sets the servo's position and moves it
//        ClawSpin = hwMap.servo.get("Clawspin"); //set equal to name or the servomotor in the phone
//        ClawSpin.setPosition(Claw_Home); //setPosition actually sets the servo's position and moves it
//        Lintake = hwMap.servo.get("LIW"); //set equal to name or the servomotor in the phone
//        Rintake = hwMap.servo.get("RIW"); //set equal to name or the servomotor in the phone
//        Roller = hwMap.servo.get("R"); //set equal to name or the servomotor in the phone
        Spintake = hwMap.crservo.get("ST"); //set equal to name or the servomotor in the phone
        Spangle = hwMap.servo.get("SA"); //set equal to name or the servomotor in the phone
//        Ramp2 = hwMap.servo.get("R2"); //set equal to name or the servomotor in the phone
//        Ramp3 = hwMap.servo.get("R3"); //set equal to name or the servomotor in the phone
//        DroneLauncher = hwMap.servo.get("D"); //set equal to name or the servomotor in the phone
    }
}
