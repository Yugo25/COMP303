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
package designbook.chapter8;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * A card source composed of other card sources.
 */
public class CompositeCardSource implements CardSource, Iterable<CardSource> {
	
	private final List<CardSource> aElements;
	
	@Override
	public Iterator<CardSource> iterator() {
		return aElements.iterator();
	}
	
	public CompositeCardSource(CardSource... pSources) {
		aElements = Arrays.asList(pSources);
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
	public void accept(CardSourceVisitor pVisitor) {
		pVisitor.visitCompositeCardSource(this);
	}
}