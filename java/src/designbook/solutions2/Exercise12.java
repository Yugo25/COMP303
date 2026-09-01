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
package designbook.solutions2;

import java.util.Arrays;
import java.util.StringJoiner;

public class Exercise12 {

	public static void main(String[] args) {
		IO.println(TwelveDaysWithEnums.poem());
	}
}

class TwelveDaysWithEnums {

	enum Day {
		FIRST("a partridge in a pear tree"), 
		SECOND("two turtle doves"), 
		THIRD("three French Hens"),
		FOURTH("four Calling Birds"), 
		FIFTH("five Golden Rings"), 
		SIXTH("six Geese a Laying"),
		SEVENTH("seven Swans a Swimming"), 
		EIGHT("eight Maids a Milking"), 
		NINTH("nine Ladies Dancing"),
		TENTH("ten Lords a Leaping"), 
		ELEVENTH("eleven Pipers Piping"), 
		TWELFTH("twelve Drummers Drumming");

		private final String aGift;

		Day(String pGift) {
			aGift = pGift;
		}

		public String asString() {
			return name().toLowerCase();
		}

		public String gift() {
			return aGift;
		}

		/**
		 * @return The object representing the previous day 
		 * in the sequence.
		 * @pre this != FIRST
		 */
		public Day previous() {
			assert this != FIRST;
			return Day.values()[ordinal() - 1];
		}

		/**
		 * @return All days except the first, in sequence.
		 */
		public static Day[] allButFirst() {
			return Arrays.copyOfRange(values(), 1, values().length);
		}
	}

	/*
	 * Returns the first line in the verse for a given day.
	 */
	static String firstLine(Day pDay) {
		return "On the " + pDay.asString() + " day of Christmas my true love sent to me:\n";
	}

	/*
	 * Returns a string that lists all the gifts received on a given day.
	 */
	static String allGifts(Day pDay) {
		if (pDay == Day.FIRST) {
			return "and " + pDay.gift();
		} else {
			return pDay.gift() + "\n" + allGifts(pDay.previous());
		}
	}

	/*
	 * Returns the text of the entire poem.
	 */
	static String poem() {
		StringJoiner poem = new StringJoiner("\n\n");
		poem.add(firstLine(Day.FIRST) + Day.FIRST.gift());
		for (Day day : Day.allButFirst()) {
			poem.add(firstLine(day) + allGifts(day));
		}
		return poem.toString();
	}
}