package com.team1160.feathers.api;

public class FrameMath {
	/**
     * @param k2 s the height of the first pyramid rung above floor and the
     * higher pyramid rungs above the middle of the next lower rung
     */
    protected double k2 = 30.75;
    /**
     * @param k1 is the height of the bottom of the side pulleys above frame
     */
    protected double k1 = 1.125;
    /**
     * @param k3 is horizontal distance between rungs
     */
    protected double k3 = 12.1;
    /**
     * @param floorbreakfree tapelength at which the robot climbing from the
     * floor breaks free
     */
    protected double floorbreakfree = 10.5;
    /**
     * @param bumperTouchAngle frame angle at which the rear bumper touches the
     * floor when climbing first rung
     */
    protected double bumperTouchAngle = 25;
    // 
    /**
     * @param rungbreakfreeangle the frame angle condition at which robot breaks
     *  free while climbing between rungs
     */
    protected double rungbreakfreeangle = 52;
    /**
     * @param rungbreakfree tapelength condition at which robot breaks free 
     * while climbing between rungs
     */
    protected double rungbreakfree = 13;
    /**
     * The following parameters are intermediate values along the way
     * to calculate the expected tape angle at different positions while
     * climbing. These calculations are lengthy, involving lots of trig and a
     * quadratic equation. Intermediate steps improve help debugging.
     *
     * @param m2 intermediate value in long quadratic trig equation for method
     * getClimbTapeAngle. the calculated tape angle to horizontal
     */
    protected double m2;
    /**
     * @param k4 intermediate value in long quadratic trig equation for method
     * getClimbTapeAngle
     */
    protected double k4;
    /**
     * @param k5 intermediate value in long quadratic trig equation for method
     * getClimbTapeAngle
     */
    protected double k5;
    /**
     * @param a intermediate value in long quadratic trig equation for method
     * getClimbTapeAngle (related to quadratic equation ax^2+bx+c)
     */
    protected double a;
    /**
     * @param b intermediate value in long quadratic trig equation for method
     * getClimbTapeAngle (related to quadratic equation ax^2+bx+c)
     */
    protected double b;
    /**
     * @param c intermediate value in long quadratic trig equation for method
     * getClimbTapeAngle (related to quadratic equation ax^2+bx+c)
     */
    protected double c;
    /**
     * @param x2 intermediate value in long quadratic trig equation for method
     * getClimbTapeAngle
     */
    protected double x2;
    /**
     * @param j3 intermediate value in trig equation for method
     * calcServoFromAngle
     */
    protected double j2;
    /**
     * @param j2 intermediate value in trig equation for method
     * calcServoFromAngle
     */
    protected double j3;
    /**
     * @param j4 intermediate value in trig equation for method
     * calcServoFromAngle
     */
    protected double j4;
    /**
     * @param j5 intermediate value in trig equation for method
     * calcServoFromAngle
     */
    protected double j5;
    /**
     * @param j6 intermediate value in trig equation for method
     * calcServoFromAngle
     */
    protected double j6;
    /**
     * @param j7 intermediate value in trig equation for method
     * calcServoFromAngle
     */
    protected double j7;
    /**
     * @param dTapeAngle  angle of tape to frame in degrees while climging
     * returned by getClimbTapeAngle
     */
    protected double dTapeAngle;
    /**
     * @param dMaxDeflec maximum deflection of tape at 0 angle and full
     * extension
     */
    protected double dMaxDeflec = 10;
    /**
     * @param servoDistanceAbovePulleyBottom in inches for side servo
     */
    protected double servoDistanceAbovePulleyBottom = 4.5;
    /**
     * @param servoDistanceBehindPulleyBottom in inches for side servos
     */
    protected double servoDistanceBehindPulleyBottom = 2.5; // Based on the following

    public FrameMath(){
    	
    }
    
}
