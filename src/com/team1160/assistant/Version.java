package com.team1160.assistant;

import java.util.Random;

public class Version {
	public static String[] RANDOM_MESSAGES = new String[] { "Heh...",
			"Gabriel and Orangutan are red COUCHES.", "Zach is a god.",
			"That's a dick move." };
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
				+ "Random message: "
				+ RANDOM_MESSAGES[new Random()
						.nextInt(RANDOM_MESSAGES.length)]);
	}
}