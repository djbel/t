package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "FoundationAuto",group = "Linear Opmode" )

public class FoundationAuto extends LinearOpMode{

    private ElapsedTime runtime = new ElapsedTime();
    private double gearRatio = 1;
    private double TPR = 1120;
    private double WheelWidth = 4;
    private double Circumfrence = Math.PI * WheelWidth;
    private DcMotor motor5 = null;

    DriveTrain robot = new DriveTrain();
    Lifter arm = new Lifter(this);

    public void runOpMode() {
        robot.init(hardwareMap, this);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        motor5 = hardwareMap.get(DcMotor.class, "motor4");

        motor5.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        runtime.reset();

        robot.Straight(18);

        motor5.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motor5.setTargetPosition(500);

        motor5.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        telemetry.addData("Status","Run Time: " + runtime.toString());
        telemetry.update();

        motor5.setPower(0.5);

        while(motor5.isBusy()){
            telemetry.update();
        }
        motor5.setPower(0);

        robot.Straight(18);

    }
}