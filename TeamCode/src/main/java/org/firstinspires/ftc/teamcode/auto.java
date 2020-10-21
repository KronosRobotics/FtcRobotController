package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Basic: Linear OpMode", group="Linear Opmode")
public class auto extends LinearOpMode {
    Robot bot = new Robot();
    @Override
    public void runOpMode() {
        bot.init(hardwareMap);
        waitForStart();
        //power = [-1, 1]
        bot.moveDis(0.5, 3000);
    }
}

