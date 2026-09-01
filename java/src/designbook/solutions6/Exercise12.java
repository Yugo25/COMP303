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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.jupiter.api.Test;

public class Exercise12 {
	
	private static final Concert CONCERT = new Concert("Concert 1", "Artist X", 100);
	private static final Movie MOVIE1 = new Movie("Movie 1", 2017, 120);
	private static final Movie MOVIE2 = new Movie("Movie 2", 2018, 130);
	private static final CompositeShow COMPOSITE = new CompositeShow(CONCERT, new CompositeShow(MOVIE1, MOVIE2));
	private static final IntroducedShow DECORATOR = new IntroducedShow(
			"Speaker 1", 10, new CompositeShow(CONCERT, new CompositeShow(MOVIE1, 
					new IntroducedShow("Speaker 2", 5, MOVIE2))));

	/*
	 * Note that these tests will fail on the sample code because they 
	 * refer to incomplete implementations. They should pass on your complete
	 * implementation of the various Show subtypes.
	 */
	
	@Test
	void testCopy_NotSame() {
	   IntroducedShow copy = DECORATOR.copy();
	   assertNotSame(DECORATOR, copy);
	}
	
	@Test
	void testCopy_Equal() {
	   IntroducedShow copy = DECORATOR.copy();
	   assertEquals(DECORATOR, copy);
	}
}