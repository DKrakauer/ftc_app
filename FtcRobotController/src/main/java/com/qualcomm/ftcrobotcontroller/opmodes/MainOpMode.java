package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by davidkrakauer on 3/17/16.
 */
public class MainOpMode extends OpMode {


    DcMotor FRight,FLeft,BRight,BLeft;

    public MainOpMode(){

    }

    @Override
    public void init(){
        FRight = hardwareMap.dcMotor.get("FrontRightMotor");
        FLeft = hardwareMap.dcMotor.get("FrontLeftMotor");
        BRight = hardwareMap.dcMotor.get("BackRightMotor");
        BLeft = hardwareMap.dcMotor.get("BackLeftMotor");

        FLeft.setDirection(DcMotor.Direction.REVERSE);
        BLeft.setDirection(DcMotor.Direction.REVERSE);

    }

    public void loop(){

        if (gamepad2.left_stick_y > 0.0) {
            if (gamepad2.right_stick_x > 0.0) {
                FLeft.setPower(gamepad2.left_stick_y - gamepad2.right_stick_x);
                FRight.setPower(Math.max(gamepad2.left_stick_y, gamepad2.right_stick_x));

                BLeft.setPower(gamepad2.left_stick_y - gamepad2.right_stick_x);
                BRight.setPower(Math.max(gamepad2.left_stick_y, gamepad2.right_stick_x));
            } else {
                FLeft.setPower(Math.max(gamepad2.left_stick_y, -gamepad2.right_stick_x));
                FRight.setPower(gamepad2.left_stick_y + gamepad2.right_stick_x);

                BLeft.setPower(Math.max(gamepad2.left_stick_y, -gamepad2.right_stick_x));
                BRight.setPower(gamepad2.left_stick_y + gamepad2.right_stick_x);
            }
        } else {
            if (gamepad2.right_stick_x > 0.0) {
                FLeft.setPower(-Math.max(-gamepad2.left_stick_y, gamepad2.right_stick_x));
                FRight.setPower(gamepad2.left_stick_y + gamepad2.right_stick_x);

                BLeft.setPower(-Math.max(-gamepad2.left_stick_y, gamepad2.right_stick_x));
                BRight.setPower(gamepad2.left_stick_y + gamepad2.right_stick_x);
            } else {
                FLeft.setPower(gamepad2.left_stick_y - gamepad2.right_stick_x);
                FRight.setPower(-Math.max(-gamepad2.left_stick_y, -gamepad2.right_stick_x));

                BLeft.setPower(gamepad2.left_stick_y - gamepad2.right_stick_x);
                BRight.setPower(-Math.max(-gamepad2.left_stick_y, -gamepad2.right_stick_x));
            }
        }




        //other loop
    }
}
