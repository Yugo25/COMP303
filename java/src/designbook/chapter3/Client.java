/*******************************************************************************
 * Java code samples on the essentials of Java programming.
 * https://codesample.info
 *
 * Copyright (C) 2022 by Martin Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package designbook.chapter3;


import java.util.ArrayList;
import java.util.List;

/**
 * Simulates code that uses various card sources.
 */
public class Client
{
	/**
	 * A utility method to draw up to pNumber cards from the source. 
	 * Mostly a demonstration of how to access an object through 
	 * an interface.
	 * 
	 * @param pSource The source object. Can be any subtype of CardSource
	 * @param pNumber The number of cards to extract.
	 * @return A list of the cards drawn from the source.
	 */
	public static List<Card> drawCards(CardSource pSource, int pNumber) {
		List<Card> result = new ArrayList<>();
		
		for (int i = 0; i < pNumber && !pSource.isEmpty(); i++) { 
			result.add(pSource.draw()); 
		}
		return result;
	}
}