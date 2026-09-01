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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

class CompositeShow3 implements Show2 {

	private List<Show2> aShows = new ArrayList<>();

	public CompositeShow3(Show2... pShows) {
		if (pShows.length < 2 || pShows.length > 5) {
			throw new IllegalArgumentException("Arguments should be between two and five shows inclusively");
		}
		aShows.addAll(Arrays.asList(pShows));
	}

	public Iterator<Show2> iterator() {
		return Collections.unmodifiableList(aShows).iterator();
	}

	public String description() {
		StringJoiner description = new StringJoiner("; ", "[", "]");
		for (Show2 show : aShows) {
			description.add(show.description());
		}
		return description.toString();
	}

	public int runningTime() {
		int time = 0;
		for (Show2 show : aShows) {
			time += show.runningTime();
		}
		return time;
	}

	public Show2 copy() {
		List<Show2> copies = new ArrayList<>();
		for (Show2 show : aShows) {
			copies.add(show.copy());
		}
		return new CompositeShow3(copies.toArray(new Show2[copies.size()]));
	}

	// Equals and hashCode are skipped for brevity
}

/**
 * Represents a performance that can take place in a theater. All
 * implementations of this interface should be immutable.
 */
interface Show2 extends Iterable<Show2> {

	/**
	 * @return A description of the show.
	 */
	String description();

	/**
	 * @return The running time of the show, in minutes.
	 */
	int runningTime();

	Show2 copy();
}
