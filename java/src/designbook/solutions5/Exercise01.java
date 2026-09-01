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
import org.junit.jupiter.api.Test;

public class Exercise01 {

	@Test
	void testMin_FirstGreater() {
		assertEquals(0, Math.min(2, 0));
	}

	@Test
	void testMin_SecondGreater() {
		assertEquals(0, Math.min(0, 2));
	}

	@Test
	void testMin_SamePositive() {
		assertEquals(2, Math.min(2, 2));
	}

	@Test
	void testMin_SameNegative() {
		assertEquals(-2, Math.min(-2, -2));
	}
}