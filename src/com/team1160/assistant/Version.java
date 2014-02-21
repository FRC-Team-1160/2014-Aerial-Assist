package com.team1160.assistant;

import java.util.Random;


/*
 * -TODO-
 * 
 * Priority   ||| --- Task
 * ---------------------------
 * 
 *    0 ---/-/-|-\-\--- Switches for pickup
 *    1 ---/-/-|-\-\--- Shooter PID Implementation
 *    2 ---/-/-|-\-\--- Vision stop fix
 *    3 ---/-/-|-\-\--- More vision debugging
 * 
 */
public class Version {

    public static final String[] RANDOM_MESSAGES =
            new String[]{
        "Heh...",
        "Gabriel and Orangutan are red COUCHES.",
        "Zach is a god.",
        "I like trains.",
        "Desmond the moon bear!",
        "Hey! Did you know that carrots are good for your eyesight?",
        "YOU LIED TO ME.",
        "That's a dick move.",
        "Don't break shit please.",
        "Look out! He's got a nose!! -add gunshots here-",
        "When I grow up, I want to go to the moon. WHY WAIT? -KICK-",
        "SARAH FLASHER STATUS",
        "ERROR 404: NO VERSION MESSAGE FOUND",
        "ERROR -2147483647: GET REK'D",
        "OHHH LAWDY REEKRIS BE WITH YOU OH LAWDY",
        "MOTHER FUCKIN BOOTLEGGED FIRETWERKS",
        "NISPY - SAY IT 5 TIMES FAST",
        "ETHAN MOTHER FUCKING ROOKE that was pretty good",
        "Ethan.. remember that time when- oh.. nevermind.. we don't talk about that.."
    };
    final double version = 0.2;
    public static Version instance = null;

    public static Version getInstance() {
        if (instance == null) {
            instance = new Version();
        }
        return instance;
    }

    private Version() {
        System.out.println("Successful deploy. Currently: v"
                + version
                + " Random message: "
                + RANDOM_MESSAGES[new Random().nextInt(RANDOM_MESSAGES.length)]);
    }
}