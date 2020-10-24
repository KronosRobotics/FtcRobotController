package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Basic: Linear OpMode", group="Linear Opmode")
public class auto extends LinearOpMode {
    Robot bot = new Robot();
    @Override
    public void runOpMode() {
        bot.init(hardwareMap);
        waitForStart();
        //power = [-1, 1]
        bot.moveDis(0.5, 3000);
        bot.moveArm(-0.5);
        bot.moveArm(0.5);
        //move 3000 ticks forward and then move down the servo arm in a counter clockwise direction
    }
}

