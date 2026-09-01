/*******************************************************************************
 * Java code samples on the essentials of Java programming.
 * https://codesample.info
 *
 * Copyright (C) 2026 by Martin Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package designbook.solutions6;

import java.util.EnumMap;

public class Exercise13 {
	public static void main(String[] args) {
		IO.println(new Program());
	}
}

/**
 * Class responsible for managing a program that consists of various shows
 * presented on different days of one week. Each day of the week must be
 * associated with exactly one Show object. If there is not show on a given day,
 * a special object of type show is used to represent a "non-show".
 */
class Program {
	
	public enum Day {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
	}
	
	private static final Show NULL_SHOW = createNullShow();
	
	private static Show createNullShow() {
		return new Show() {
			public String description() { return ""; }
			public int runningTime() { return 0; }
			public Show copy() { return createNullShow(); }
			public int hashCode() { return 0; }
			public boolean equals(Object pObject) {
				return pObject != null && pObject.getClass() == this.getClass(); }
		};
	}

	private final EnumMap<Day, Show> aShows = new EnumMap<>(Day.class);

	public Program() {
		clear();
	}

	/**
	 * Clear the program by removing all existing shows.
	 */
	public void clear() {
		for (Day day : Day.values()) {
			aShows.put(day, NULL_SHOW);
		}
	}

	/**
	 * Adds a new show to the program. Overrides any existing show on that day.
	 * 
	 * @param pShow The show to add.
	 * @param pDay  The day when the show takes place.
	 */
	public void add(Show pShow, Day pDay) {
		assert pShow != null && pDay != null;
		aShows.put(pDay, pShow);
	}

	/**
	 * Removes a show from the program.
	 * 
	 * @param pDay The day when we want to zap the show.
	 */
	public void remove(Day pDay) {
		assert pDay != null;
		aShows.put(pDay, NULL_SHOW);
	}

	/**
	 * @param pDay The day of the requested show.
	 * @return A copy of the show on a given day.
	 */
	public Show get(Day pDay) {
		assert pDay != null;
		return aShows.get(pDay);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Day day : aShows.keySet()) {
			if (aShows.containsKey(day)) {
				result
					.append(String.format("%9s", day.name()))
					.append(": ")
					.append(aShows.get(day).description())
					.append("\n");
			}
		}
		return result.toString();
	}
}