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
package designbook.chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A CardSource implementation that represents an aggregation
 * of zero or more card sources.
 */
public class CompositeCardSource implements CardSource {
	private List<CardSource> aElements;
	
	/**
	 * Creates a composite card source comprising all the elements
	 * in pCardSources
	 * 
	 * @param pCardSources A sequence of cards sources to aggregate.
	 */
	public CompositeCardSource(CardSource... pCardSources) {
		aElements = Arrays.asList(pCardSources);
	}
	
	@Override
	public Card draw() { 
		assert !isEmpty();
		for (CardSource source : aElements) {
			if (!source.isEmpty()) {
				return source.draw();
			}
		}
		assert false;
		return null;
	}

	@Override
	public boolean isEmpty() {
		for (CardSource source : aElements) {
			if (!source.isEmpty()) { 
				return false; 
			}
		}
		return true;
	}
	
	@Override
	public CardSource copy() {
		CompositeCardSource copy = new CompositeCardSource();
		copy.aElements = new ArrayList<>();
		for (CardSource source : aElements) {
			copy.aElements.add(source.copy());
		}
		return copy;
	}
}