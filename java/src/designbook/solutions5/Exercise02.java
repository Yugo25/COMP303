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

public class Exercise02 {
	
	private static final double ZERO = 0.0;
	private static final double QUARTER = Math.PI / 2.0;
	private static final double HALF = Math.PI;
	private static final double THREE_QUARTERS = Math.PI * 1.5;

	@Test
	void testCos_NaN() {
		assertEquals(Double.NaN, Math.cos(Double.NaN));
	}

	@Test
	void testCos_Infinity() {
		assertEquals(Double.NaN, Math.cos(Double.POSITIVE_INFINITY));
	}

	@Test
	void testCos_Zero() {
		assertEquals(1.0, Math.cos(ZERO), Math.ulp(0.0));
	}

	@Test
	void testCos_Quarter() {
		assertEquals(0.0, Math.cos(QUARTER), Math.ulp(0.0));
	}

	@Test
	void testCos_Half() {
		assertEquals(-1.0, Math.cos(HALF), Math.ulp(-1.0));
	}

	@Test
	void testCos_ThreeQuaters() {
		assertEquals(0.0, Math.cos(THREE_QUARTERS), Math.ulp(0.0));
	}
}