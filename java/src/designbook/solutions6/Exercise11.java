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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

class CompositeShow5 implements Show {

	private List<Show> aShows = new ArrayList<>();
	
	public int hashCode() {
		return Objects.hash(aShows);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeShow5 other = (CompositeShow5) obj;
		return Objects.equals(aShows, other.aShows);
	}

	public CompositeShow5 copy() {
		List<Show> copies = new ArrayList<>();

		for (Show show : aShows) {
			copies.add(show.copy());
		}
		return new CompositeShow5(copies.toArray(new Show[copies.size()]));
	}

	public CompositeShow5(Show... pShows) {
		if (pShows.length < 2 || pShows.length > 5) {
			throw new IllegalArgumentException("Arguments should be between two and five shows inclusively");
		}
		aShows.addAll(Arrays.asList(pShows));
	}

	public String description() {
		StringJoiner description = new StringJoiner("; ", "[", "]");
		for (Show show : aShows) {
			description.add(show.description());
		}
		return description.toString();
	}

	public int runningTime() {
		int time = 0;
		for (Show show : aShows) {
			time += show.runningTime();
		}
		return time;
	}
}