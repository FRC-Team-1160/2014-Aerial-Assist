package com.team1160.assistant;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public interface RobotMap {
    // ---MOTORS---
    // -DRIVE-

    public static final int LEFT_TAL_MOTOR_SLOT = 1;
    public static final int LEFT_TAL_MOTOR_CHAN = 1;
    public static final int RIGHT_TAL_MOTOR_SLOT = 1;
    public static final int RIGHT_TAL_MOTOR_CHAN = 2;
    // -SHOOT-
    public static final int SHOOT_MOTOR_SLOT = 1;
    public static final int SHOOT_MOTOR_CHAN = 3;
    // -PICKUP-
    public static final int PICKUP_TAL_MOTOR_SLOT = 1;
    public static final int PICKUP_TAL_MOTOR_CHAN = 4;
    public static final double PICKUP_HARDSTOP_H = 0;
    public static final double PICKUP_HARDSTOP_L = 0;
    public static final double PICKUP_STALL = 0;
    // ---JOYSTICKS---
    public static final int JOY_PORT = 1;
    // ---ENCODERS---
    public static final int ENC_PICKUP_A = 1;
    public static final int ENC_PICKUP_B = 2;
    public static final int ENC_DT_LEFT_A = 3;
    public static final int ENC_DT_LEFT_B = 4;
    public static final int ENC_DT_RIGHT_A = 5;
    public static final int ENC_DT_RIGHT_B = 6;
    public static final int ENC_SHOOT_A = 7;
    public static final int ENC_SHOOT_B = 8;
    // ---SPEED VALUES---
    public static final double LET_GO = 0;
    public static final double ADD_TENSION = 0;
    public static final double RELEASE_TENSION = 0;
    public static final double RAISE_ARM = 0.4;
    public static final double LOWER_ARM = -0.4;
    public static final double P = 0.1;
    public static final double I = 0.001;
    public static final double D = 0;
    public static final double ABSOLUTE = 0;
    
    // ---JOYSTICK BUTTONS---
    public static final int VISION_TRACK_BUT = 2;
    public static final int STOP_VISION_TRACK_BUT = 3;
    public static final int PICKUP_RAISE_BUT = 4;
    public static final int PICKUP_LOWER_BUT = 5;
    public static final int RELEASE_TENSION_BUT = 8;
    public static final int ADD_TENSION_BUT = 9;
    public static final int LET_GO_BUT = 1;
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
