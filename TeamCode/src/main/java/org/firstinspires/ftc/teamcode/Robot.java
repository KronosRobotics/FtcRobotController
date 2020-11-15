package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Robot {
    public DcMotor l1 = null;
    public DcMotor l2 = null;
    public DcMotor r1 = null;
    public DcMotor r2 = null;
    //2 left motors 2 right motors
    public Servo arm = null;
    public Servo lift = null;
    public HardwareMap hwMap = null;
    public void init(HardwareMap hardwareMap){
        //encoder measures the distance we are going

        hwMap = hardwareMap;
        l1 = hwMap.get(DcMotor.class, "l1");
        l2 = hwMap.get(DcMotor.class, "l2");
        r1 = hwMap.get(DcMotor.class, "r1");
        r2 = hwMap.get(DcMotor.class, "r2");
        arm = hwMap.get(Servo.class, "arm");
        l1.setDirection(DcMotor.Direction.FORWARD);
        l2.setDirection(DcMotor.Direction.FORWARD);
        r1.setDirection(DcMotor.Direction.REVERSE);
        r2.setDirection(DcMotor.Direction.REVERSE);
        arm.setDirection(Servo.Direction.REVERSE);
        //use the encoders for the motors
        //helps us us the encoders for the motors
        l1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        r1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        l2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        r2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //encoder measures how much the motor moves
        //motorname.setpower(power val(double in the range of 0 - 1 inclusive));
        l1.setPower(0);
        l2.setPower(0);
        r1.setPower(0);
        r2.setPower(0);
        arm.setPosition(0.5);
    }

    public void move(double power, double turn){
        r1.setPower(power + turn);
        r2.setPower(power + turn);
        l1.setPower(power - turn);
        l2.setPower(power - turn);
        //power has to be in the range [-1, 1]
        //setpower(2) => setpower(1)
    }

    public void moveArm(double p){
        arm.setPosition(p);
    }

    public void moveDis(double power, int dis){
        r1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        r2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        l1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        l2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        r1.setTargetPosition(dis);
        r2.setTargetPosition(dis);
        l1.setTargetPosition(-dis);
        l2.setTargetPosition(-dis);
        r1.setPower(power);
        r2.setPower(power);
        l2.setPower(power);
        l1.setPower(power);
        r1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        r2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        l1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        l2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //comment
    }
}
