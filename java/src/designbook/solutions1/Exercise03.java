/*******************************************************************************
 * Java code samples on the essentials of Java programming.
 * https://codesample.info
 *
 * Copyright (C) 2022 by Martin Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package designbook.solutions1;

/**
 * Outputs the text of the poem "The Twelve Days of Christmas" to the console.
 * The code leverages the natural recursion in the structure of the poem. This
 * version allows users to display days using digits by passing in the
 * command-line argument "digits" and the gifts in lowercase by passing in the 
 * command-line argument "lower".
 */
public class Exercise03 {
	
	private static final String FEATURE_DIGITS = "digits";
	private static final String FEATURE_LOWERCASE = "lower";
	
	private static boolean asDigits = false;
	private static boolean lowerCase = false;
	
	public static void main(String[] args) {
		asDigits = detectFeature(args, FEATURE_DIGITS);
		lowerCase = detectFeature(args, FEATURE_LOWERCASE);
		System.out.println(poem());
	}
	
	/* Detects whether a certain string is contained in the input array */
	static boolean detectFeature(String[] args, String pFeature) {
		if (args == null || pFeature == null) {
			return false;
		}
		for (String input : args) {
			if (pFeature.equals(input)) {
				return true;
			}
		}
		return false;
	}
	
	static String[] DAYS = {"first", "second", "third", "fourth",
							"fifth", "sixth", "seventh", "eighth",
							"ninth", "tenth", "eleventh", "twelfth"};
	
	static String[] DAYS_DIGITS = {"1st", "2nd", "3rd", "4th",
			"5th", "6th", "7th", "8th",
			"9th", "10th", "11th", "12th"};
	
	static String day(int day) {
		if (asDigits) {
			return DAYS_DIGITS[day];
		}
		else {
			return DAYS[day];
		}
	}
	
	static String gift(int day) {
		String gift = GIFTS[day];
		if (lowerCase) {
			gift = gift.toLowerCase();
		}
		return gift;
	}
	
	static String[] GIFTS = {
			"a Partridge in a Pear Tree",
			"two Turtle Doves",
			"three French Hens",
			"four Calling Birds",
			"five Golden Rings",
			"six Geese a Laying",
			"seven Swans a Swimming",
			"eight Maids a Milking",
			"nine Ladies Dancing",
			"ten Lords a Leaping",
			"eleven Pipers Piping",
			"twelve Drummers Drumming"
	};
	
	static String firstLine(int day) {
		return "On the " + day(day) + " day of Christmas my true love sent to me:\n";
	}
	
	/*
	 * Returns a string that lists all the gifts received on a given day.
	 */
	static String allGifts(int day) {
		if (day == 0) {
			return "and " + gift(0);
		}
		else {
			return gift(day) + "\n" + allGifts(day - 1);
		}
	}
	
	/*
	 * Returns the text of the entire poem. 
	 */
	static String poem() {
		String poem = firstLine(0) + gift(0) + "\n\n";
		for (int day = 1; day < 12; day++) {
			poem += firstLine(day) + allGifts(day) + "\n\n";
		}
		return poem;
	}
}