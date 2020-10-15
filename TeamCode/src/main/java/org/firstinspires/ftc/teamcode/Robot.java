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
        hwMap = hardwareMap;
        l1 = hwMap.get(DcMotor.class, "l1");
        l2 = hwMap.get(DcMotor.class, "l2");
        r1 = hwMap.get(DcMotor.class, "r1");
        r2 = hwMap.get(DcMotor.class, "r2");
        l1.setDirection(DcMotor.Direction.FORWARD);
        l2.setDirection(DcMotor.Direction.FORWARD);
        r1.setDirection(DcMotor.Direction.REVERSE);
        r2.setDirection(DcMotor.Direction.REVERSE);
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


}
