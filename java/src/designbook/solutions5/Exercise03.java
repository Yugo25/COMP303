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
package designbook.solutions5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class Exercise03 {

	private static final String EMPTY = "";
	private static final String NON_EMPTY = "abc";

	@Test
	void testConcat_EmptyEmpty() {
		assertSame(EMPTY, EMPTY.concat(""));
	}

	@Test
	void testConcat_NonEmptyEmpty() {
		assertSame(NON_EMPTY, NON_EMPTY.concat(""));
	}

	@Test
	void testConcat_EmptyNonEmpty() {
		assertEquals(NON_EMPTY, EMPTY.concat(NON_EMPTY));
	}

	@Test
	void testConcat_NonEmptyNonEmpty() {
		assertEquals("abcabc", NON_EMPTY.concat(NON_EMPTY));
	}

	@Test // This test documents that calling concat with a null argument throws an NPE
	void testConcat_Null() {
		assertThrows(NullPointerException.class, new Executable() {
			public void execute() throws Throwable {
				NON_EMPTY.concat(null);
			}
		});
	}
}