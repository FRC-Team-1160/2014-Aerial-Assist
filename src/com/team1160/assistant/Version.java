package com.team1160.assistant;

import java.util.Random;


/*
 * -TODO-
 * 
 * Priority   ||| --- Task
 * ---------------------------
 *    1       ||| --- Encoders
 *    2       ||| --- Vision
 *    3       ||| --- Autonomous
 *    4       ||| --- Implement Pickup (motor)
 *    5       ||| --- Remove Pneumatics
 * 
 */

public class Version {

    public String s1;
    final double version = 0.1;
    
    public static Version instance = null;
    
    public static Version getInstance(){
        if(instance == null){
            instance = new Version();
        }
        return instance;
    }
    
    private Version() {

        Random rand = new Random();
        int a = rand.nextInt(3);

        if (a == 0) {
            s1 = "Heh...";
        } else if (a == 1) {
            s1 = "Gabriel and Orangutan are red COUCHES.";
        } else if (a == 2) {
            s1 = "Zach is a god.";
        } else if (a == 3) {
            s1 = "That's a dick move.";
        }
        System.out.println("Successful deploy. Currently: v" + version + " Random message: " + s1);
    }
}