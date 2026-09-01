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

import java.util.Iterator;
import java.util.List;

/**
 * Represents a show that consists of the screening of two movies in sequence.
 */
class DoubleBill2 implements Show, Iterable<Movie> {

	private Movie aMovie1;
	private Movie aMovie2;

	/**
	 * @param pMovie1 The first movie.
	 * @param pMovie2 The second movie.
	 */
	public DoubleBill2(Movie pMovie1, Movie pMovie2) {
		aMovie1 = pMovie1;
		aMovie2 = pMovie2;
	}

	public DoubleBill2(DoubleBill2 pDoubleBill) {
		aMovie1 = new Movie(pDoubleBill.aMovie1);
		aMovie2 = new Movie(pDoubleBill.aMovie2);
	}

	public String description() {
		return String.format("%s and %s", aMovie1.description(), aMovie2.description());
	}

	public int runningTime() {
		return aMovie1.runningTime() + aMovie2.runningTime();
	}

	public Iterator<Movie> iterator() {
		return List.of(aMovie1, aMovie2).iterator();
	}

	public DoubleBill2 copy() {
		return null; // Placeholder, solution in Exercise 10
	}
}