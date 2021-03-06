package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
/**
 * Created by KK on 10/17/2015.
 */
public class ServoTEST extends OpMode {
	final static double ARM_MIN_RANGE  = 0.20;
	final static double ARM_MAX_RANGE  = 0.90;
    double armPosition = 0.0;
    double armDelta = 0.1;
    Servo arm;
    public ServoTEST() {

    }

    /*
     * Code to run when the op mode is initialized goes here
     *
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#init()
     */
    @Override
    public void init() {
        arm = hardwareMap.servo.get("servo_1");
    }

    @Override
    public void loop() {
        if (gamepad1.a){
            armPosition += armDelta;
        }
        if(gamepad1.b) {
            armPosition -= armDelta;
        }
        armPosition = Range.clip(armPosition, ARM_MIN_RANGE, ARM_MAX_RANGE);
        arm.setPosition(armPosition);
    }

    /*
     * Code to run when the op mode is first disabled goes here
     *
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#stop()
     */
    @Override
    public void stop() {}
}
