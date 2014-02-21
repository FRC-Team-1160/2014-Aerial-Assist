package com.team1160.assistant;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public interface RobotMap {
    // ---NUMBER CONSTANTS---
    public static final double AUTO_TIME = 2.3;
    public static final double RAISE_ARM = -0.8;
    public static final double LOWER_ARM = 0.6;
    public static final double SHOOT_LENGTH = 0.5;
    public static final double RESET_LENGTH = 1;
    // ---JOYSTICKS---
    public static final int JOY_PORT = 1;
    public static final int SHOOT_STICK = 2;
    public static final int FIRE_BUT = 1;
    public static final int RELOAD_BUT = 2;
    public static final int PICKUP_RAISE_BUT = 4;
    public static final int PICKUP_LOWER_BUT = 5;
    public static final int MAN_PICKUP_U = 4;
    public static final int MAN_PICKUP_D = 5;
    public static final int AUTO_BUT = 9;
    // ---MOTORS---
    public static final int LEFT_TAL_MOTOR = 1;
    public static final int RIGHT_TAL_MOTOR = 2;
    public static final int PICKUP_TAL_MOTOR = 3;
    public static final int SHOOT_MOTOR_A = 4;
    public static final int SHOOT_MOTOR_B = 5;

    // -- DIGITAL INPUT --
    public static final int ENC_DT_RIGHT_A = 1;
    public static final int ENC_DT_RIGHT_B = 2;
    public static final int ENC_DT_LEFT_A = 3;
    public static final int ENC_DT_LEFT_B = 4;
    public static final int LIMIT_SHOOTER_L = 8;
    public static final int LIMIT_PICKUP_L = 11;
    public static final int LIMIT_PICKUP_H = 10;
    /*--------------------------
     * --------WARNING----------
     * ---THE FOLLOWING LINES---
     * ---CONTAIN VISION CODE---
     * ---YOU HAVE BEEN WARNED--
     *-------------------------*/
    public static final int Y_IMAGE_RES = 240;
    public static final double VIEW_ANGLE = 41.7; // Axis 206 camera
    // Score limits used for target identification
    public static final int RECTANGULARITY_LIMIT = 40;
    public static final int ASPECT_RATIO_LIMIT = 55;
    // Score limits used for hot target determination
    public static final int TAPE_WIDTH_LIMIT = 50;
    public static final int VERTICAL_SCORE_LIMIT = 50;
    public static final int LR_SCORE_LIMIT = 50;
    // Minimum area of particles to be considered
    public static final int AREA_MINIMUM = 150;
    // Maximum number of particles to process
    public static final int MAX_PARTICLES = 8;
}
