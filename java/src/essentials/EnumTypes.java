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
package essentials;

/** Represents a given day of the week. */
enum Day {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

/* A mock-up illustrating how an enumerated type is realized. */
class FakeDayEnum // extends Enum 
{
	public static final FakeDayEnum MONDAY = new FakeDayEnum();
	public static final FakeDayEnum TUESDAY = new FakeDayEnum();
	public static final FakeDayEnum WEDNESDAY = new FakeDayEnum();
	// ... and so on
	
	private FakeDayEnum() {}
}

/* Enumerated types can also store values. */
enum Month {
	JANUARY(31), FEBRUARY(28), MARCH(31), APRIL(30), MAY(31), JUNE(30), JULY(31),
		AUGUST(31), SEPTEMBER(30), OCTOBER(31), NOVEMBER(30), DECEMBER(31);
	
	// This is for illustration purposes: we don't worry about leap years
	private final int aNumberOfDays;
	
	private Month(int pNumberOfDays) {
		aNumberOfDays = pNumberOfDays;
	}	
	
	public int numberOfDays() {
		return aNumberOfDays;
	}
	
	public String asString() {
		return name().charAt(0) + name().substring(1).toLowerCase();
	}
	
	public Month next() {
		return Month.values()[(ordinal()+1) % Month.values().length];
	}
}

/* Demonstrates some common usage patterns for enumerated types. */
public class EnumTypes {
	public static void main(String[] args) {
		for (Day day : Day.values()) {
			IO.println(day);
		}
		
		// Obtain a month by string value
		Month month = Month.valueOf("APRIL");
		IO.println(String.format("%s has %d days", month.asString(), month.numberOfDays()));
		IO.println(String.format("%s follows %s", month.next().asString(), month.asString()));
	}
}