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

import java.util.Iterator;
import java.util.List;

/**
 * Represents a generic pair of objects of the same reference type.
 * @param <T> The type of both objects of this pair.
 */
class Pair<T> implements Iterable<T> {
	private final T aFirst;
	private final T aSecond;
	
	public Pair(T pFirst, T pSecond) {
		aFirst = pFirst; 
		aSecond = pSecond;
	}
	
	public T first() { return aFirst; }
	public T second() { return aSecond; }
	
	public Pair<String> asStrings() {
		return new Pair<>(aFirst.toString(), aSecond.toString());
	}

	public Iterator<T> iterator() {
		return List.of(aFirst, aSecond).iterator();
	}
}

public class Generics {
	@SuppressWarnings({ "rawtypes" })
	public static void main(String[] args) {
		// Parameterized Pair
		Pair<Integer> pairOfIntegers = new Pair<>(1, 2);
		int sum = pairOfIntegers.first() + pairOfIntegers.second();
		for (Integer integer : pairOfIntegers) {
			IO.println(integer);
		}
		String firstAsString = pairOfIntegers.asStrings().first();
		
		// Raw Pair
		Pair rawPair = new Pair(1, "Two");
		Integer element1 = (Integer) rawPair.first();
		String element1AsString = (String) rawPair.asStrings().first();
	}
}