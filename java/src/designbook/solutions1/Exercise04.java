/*******************************************************************************
 * Java code samples on the essentials of Java programming.
 * https://codesample.info
 *
 * Copyright (C) 2025 by Martin Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package designbook.solutions1;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Outputs the text of the poem "The Twelve Days of Christmas" to the console.
 * This version prints the poem in French if the argument "fr" is passed in.
 */
public class Exercise04 {
	private static final String RESOURCE_BASENAME = "solutions/chapter1/resources";
	
	static ResourceBundle resources = ResourceBundle.getBundle(RESOURCE_BASENAME);
	
	public static void main(String[] args) {
		if (args != null && args.length > 0) {
			resources = ResourceBundle.getBundle(RESOURCE_BASENAME, Locale.of(args[0]));
		}
		System.out.println(poem());
	}
	
	/*
     * Returns the first line in the verse for a given day.
	 */
	static String firstLine(int day) {
	  return String.format(resources.getString("firstLine"), day(day));
	}
	
	static String day(int day) {
		return resources.getString("day" + day);
	}
	
	static String gift(int day) {
		return resources.getString("gift" + day);
	}
	
	static String and() {
		return resources.getString("and") + " ";
	}
	
	/*
     * Returns a string that lists all the gifts received on a given day.
	 */
	static String allGifts(int day) {
		if (day == 0) {
			return and() + gift(0);
		}
		else {
			return gift(day) + "\n" + allGifts(day - 1);
		}
	}
	
	/*
	 * Returns the text of the entire poem. 
	 */
	static String poem() {
		String poem = firstLine(0) + gift(0);
		for (int day = 1; day < 12; day++) {
			poem += "\n\n" + firstLine(day) + allGifts(day);
		}
		return poem;
	}
}