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

/**
 * Represents a performance that can take place in a theater. All
 * implementations of this interface should be immutable.
 */
public interface Show {

	/**
	 * @return A description of the show.
	 */
	String description();

	/**
	 * @return The running time of the show, in minutes.
	 */
	int runningTime();

	/**
	 * @return An different but equal object.
	 */
	Show copy();
}