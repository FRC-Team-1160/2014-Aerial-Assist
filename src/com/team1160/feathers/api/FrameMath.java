package com.team1160.feathers.api;

import com.sun.squawk.util.MathUtils;

public class FrameMath {
	/**
     * @param k2 s the height of the first pyramid rung above floor and the
     * higher pyramid rungs above the middle of the next lower rung
     */
    protected final double k2 = 30.75;
    /**
     * @param k1 is the height of the bottom of the pulley above frame bottome
     * 
     */
    protected double k1 = 1.125;
    /**
     * @param k3 is horizontal distance between rungs
     */
    protected final double k3 = 12.1;
    /**
     * @param floorbreakfree tapelength at which the robot climbing from the
     * floor breaks free
     */
    protected final double floorbreakfree = 10.5;
    /**
     * @param bumperTouchAngle frame angle at which the rear bumper touches the
     * floor when climbing first rung
     */
    protected final double bumperTouchAngle = 25;
    // 
    /**
     * @param rungbreakfreeangle the frame angle condition at which robot breaks
     *  free while climbing between rungs
     */
    protected final double rungbreakfreeangle = 52;
    /**
     * @param rungbreakfree tapelength condition at which robot breaks free 
     * while climbing between rungs
     */
    protected final double rungbreakfree = 13;
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
    protected final double dMaxDeflec = 10;
    /**
     * @param servoDistanceAbovePulleyBottom in inches for side servo
     */
    protected double servoDistanceAbovePulleyBottom = 4.5;
    /**
     * @param servoDistanceBehindPulleyBottom in inches for side servos
     */
    protected double servoDistanceBehindPulleyBottom; // Based on the following

    public FrameMath(boolean middle){
    	if(middle){
    		servoDistanceBehindPulleyBottom = 0;
    	}else{
    		servoDistanceBehindPulleyBottom = 2.5;
    	}
    }
    
    public double getClimbTapeAngle(boolean floor, double tapeLength, double frameAngle) {
        double dFrAng = Math.toDegrees(frameAngle);
        if (floor) {                      // are we climbing from floor
            if (tapeLength < floorbreakfree) {     // The break free condition check
                dTapeAngle = 90 - dFrAng;
                return dTapeAngle;
            } else {                                  //If you haven't broken free
                if (dFrAng <= bumperTouchAngle) {
                    dTapeAngle = Math.toDegrees(MathUtils.asin((k2 - 12.3 * Math.sin(frameAngle)) / tapeLength));// Rear wheel touching
                    return dTapeAngle;
                } else {
                    return Math.toDegrees(MathUtils.asin((k2 - 18.9 * Math.sin(frameAngle)) / tapeLength));  // rear bumper
                }
            }
        } else {   // Get here if are between rungs... not climbing from floor

            if (tapeLength < 13.1 & dFrAng < 60) { // Breaking free angle plus length condition
                dTapeAngle = 90 - dFrAng;
                return dTapeAngle;

            } else if (dFrAng < 92 && dFrAng > 88) {  //Checks for conditions near 90 degrees
                m2 = MathUtils.acos((k3 + k1) / tapeLength);
            } else if (dFrAng < 2 && dFrAng > -2) {
                if (tapeLength <= Math.sqrt(MathUtils.pow(k2 - k1, 2) + MathUtils.pow(k3 + k1, 2))) {
                    m2 = MathUtils.asin((k2 - k1) / tapeLength);
                } else {
                    m2 = MathUtils.acos((k3 + k1) / tapeLength);
                }
            } else {    //Ugly quad stuff no need to do unless frame angle not 90 or 0 
                k5 = 1 / Math.tan(frameAngle);
                a = (1 + MathUtils.pow(k5, 2));
                k4 = k1 / Math.sin(frameAngle);
                b = -2 * (k2 + k4 * k5 + k3 * k5);
                c = MathUtils.pow(k2, 2) + MathUtils.pow(k3, 2) + MathUtils.pow(k4, 2) + 2 * (k3 * k4) - MathUtils.pow(tapeLength, 2);
                x2 = (-b - Math.sqrt(((b * b) - (4 * a * c)))) / (2 * a);
            }
            dTapeAngle = Math.toDegrees(m2) - dFrAng;
            return dTapeAngle;
        }
    }

}
