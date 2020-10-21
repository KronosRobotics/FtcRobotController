package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class Robot {
    public DcMotor l1 = null;
    public DcMotor l2 = null;
    public DcMotor r1 = null;
    public DcMotor r2 = null;
    //2 left motors 2 right motors
    public HardwareMap hwMap = null;
    public void init(HardwareMap hardwareMap){
        //encoder measures the distance we are going

        hwMap = hardwareMap;
        l1 = hwMap.get(DcMotor.class, "l1");
        l2 = hwMap.get(DcMotor.class, "l2");
        r1 = hwMap.get(DcMotor.class, "r1");
        r2 = hwMap.get(DcMotor.class, "r2");
        l1.setDirection(DcMotor.Direction.FORWARD);
        l2.setDirection(DcMotor.Direction.FORWARD);
        r1.setDirection(DcMotor.Direction.REVERSE);
        r2.setDirection(DcMotor.Direction.REVERSE);
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
    }

    public void move(double power, double turn){
        r1.setPower(power + turn);
        r2.setPower(power + turn);
        l1.setPower(power - turn);
        l2.setPower(power - turn);
    }

    public void moveDis(double power, int dis){
        r1.setTargetPosition(dis);
        r2.setTargetPosition(dis);
        r1.setPower(1);
        r1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        r2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while(r1.isBusy()){}
        r1.setPower(0);
        r2.setPower(0);
        r1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        r2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
}
