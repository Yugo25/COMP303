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
package designbook.solutions4;

public class Exercise05 {
	
	// Minimal scaffolding to demonstrate the solution in action
	public static void main(String[] args) {
		performShuffle(Shufflable.NULL_SHUFFLABLE);
	}

	public static void performShuffle(Shufflable pSomeArgument) {
	    if (pSomeArgument != null) {
	       pSomeArgument.shuffle();
	    }
	} 
}

/**
 * An object that can be shuffled.
 */
interface Shufflable {

	public static final Shufflable NULL_SHUFFLABLE = new Shufflable() {
		public void shuffle() { /* Do nothing */ }
	};

	/**
	 * Randomly reorder the objects that are the components of this object.
	 */
	void shuffle();
}