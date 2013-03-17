package com.team1160.feathers;

import com.team1160.feathers.api.Constants;
import com.team1160.feathers.sensors.LengthSensor;

import edu.wpi.first.wpilibj.Gyro;

/*
 * Sensor interface, similar to the opertaor
 * interface is one place for all objects to 
 * get sensor data.
 */

public class SI {

    protected LengthSensor mid;
    protected LengthSensor left;
    protected LengthSensor right;
    protected Gyro gyro;
    protected static SI instance;

    public static SI getInstance() {
        if (instance == null) {
            instance = new SI();
        }
        return instance;
    }

    protected SI() {
        mid = new LengthSensor(Constants.MID_POT, 0, 16.1, 8.12);
        left = new LengthSensor(Constants.LEFT_POT, 0, -16.1, 66.72);
        right = new LengthSensor(Constants.RIGHT_POT, 0, 16.92, -.187);

        gyro = new Gyro(Constants.GYRO);
    }

    public LengthSensor getMid() {
        return this.mid;
    }

    public LengthSensor getLeft() {
        return this.left;
    }

    public LengthSensor getRight() {
        return this.right;
    }
    // Returns the angle of the frame in radians, because thats what we need them in most the time

    public double getAngle() {
        return Math.toRadians(gyro.getAngle());
    }

    public double getAngleDegrees() {
        return gyro.getAngle();

    }

    public void reset() {
        gyro.reset();
    }
}
