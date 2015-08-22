package org.chinpon.util;

public class Dice {
	public static long getNumber() {
		return getNumber(6);
	}

	public static long getNumber(int numberOfSides) {
		return Math.max(1, Math.round((Math.random() * 10) %
				numberOfSides));
	}
}
