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

import designbook.solutions6.Program2.Day;

public class Exercise14 {
	public static void main(String[] args) {
		Program2 program = new Program2();
		program.createAddCommand(new Movie("Movie 1", 2000, 120), Day.MONDAY).execute();
		program.createAddCommand(new Movie("Movie 2", 2010, 90), Day.WEDNESDAY).execute();
		IO.println(program);
		program.createRemoveCommand(Day.MONDAY).execute();
		IO.println(program);
		program.createClearCommand().execute();
	}
}

interface Command {
	void execute();
}

class Program2 {
	
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
			public boolean equals(Object pObject) 
	        { return pObject != null && pObject.getClass() == this.getClass(); }
		};
	}

	private final EnumMap<Day, Show> aShows = new EnumMap<>(Day.class);

	public Program2() {
		clear();
	}
	
	public Command createAddCommand(Show pShow, Day pDay) {
	   return new Command() {
	      public void execute() {
	         add(pShow, pDay);				
	      }
	   };
	}
		
	public Command createRemoveCommand(Day pDay) {
	   return new Command() {
	      public void execute() {
	         remove(pDay);				
	      }
	   };
	}
		
	public Command createClearCommand() {
	   return new Command() {
	      public void execute() {
	         clear();				
	      }
	   };
	}

	private void clear() {
		for (Day day : Day.values()) {
			aShows.put(day, NULL_SHOW);
		}
	}

	private void add(Show pShow, Day pDay) {
		assert pShow != null && pDay != null;
		aShows.put(pDay, pShow);
	}

	private void remove(Day pDay) {
		assert pDay != null;
		aShows.put(pDay, NULL_SHOW);
	}

	private Show get(Day pDay) {
		assert pDay != null;
		return aShows.get(pDay);
	}

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