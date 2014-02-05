package com.team1160.assistant;

import java.util.Random;

/* -TODO-
 * 
 * Priority ||| --- Task
 * ---------------------------
 * 1 ||| --- Encoders
 * 2 ||| --- Vision
 * 3 ||| --- Autonomous
 * 4 ||| --- Implement Pickup (motor)
 * 
 * 
 * 
 * 5 ||| --- Remove Pneumatics --- DONE */
public class Version {
	public static final String[] RANDOM_MESSAGES = new String[] { "Heh...",
			"Gabriel and Orangutan are red COUCHES.", "Zach is a god.",
			"I like trains.", "Desmond the moon bear!",
			"Hey! Did you know that carrots are good for your eyesight?",
			"YOU LIED TO ME.", "That's a dick move.",
			"Don't break shit please.",
			"Look out! He's got a nose!! -add gunshots here-",
			"When I grow up, I want to go to the moon.", "WHY WAIT? -KICK-",
			"Error 404: RANDOM MESSAGE NOT FOUND" };
	final double version = 0.1;
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
				+ RANDOM_MESSAGES[new Random()
						.nextInt(RANDOM_MESSAGES.length)]);
	}
}