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

import java.util.Objects;

public class Exercise02 {

	// Samples
	private static final Concert CONCERT = new Concert("Concert 1", "Artist X", 100);
	private static final Movie MOVIE1 = new Movie("Movie 1", 2017, 120);
	private static final Movie MOVIE2 = new Movie("Movie 2", 2018, 130);

	public static void main(String[] args) {
		CompositeShow exercise1 = new CompositeShow(CONCERT, new CompositeShow(MOVIE1, MOVIE2));
		IntroducedShow exercise2 = new IntroducedShow(
				"Speaker 1", 10, new CompositeShow(
						CONCERT,
						new CompositeShow(
								MOVIE1,
								new IntroducedShow("Speaker 2", 5, MOVIE2))));
		IO.println(exercise2.description());
	}
}

class IntroducedShow implements Show {

	private final Show aShow;
	private final String aSpeaker;
	private final int aSpeechTime;

	public IntroducedShow(String pName, int pTime, Show pShow) {
		aShow = pShow;
		aSpeaker = pName;
		aSpeechTime = pTime;
	}

	public String description() {
		return "[" + aSpeaker + " introduces " + aShow.description() + "]";
	}

	
	public int runningTime() {
		return aSpeechTime + aShow.runningTime();
	}

	public IntroducedShow copy() {
		return new IntroducedShow(aSpeaker, aSpeechTime, aShow.copy());
	}

	public int hashCode() {
		return Objects.hash(aShow, aSpeaker, aSpeechTime);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntroducedShow other = (IntroducedShow) obj;
		return Objects.equals(aShow, other.aShow) && Objects.equals(aSpeaker, other.aSpeaker) &&
				aSpeechTime == other.aSpeechTime;
	}
}