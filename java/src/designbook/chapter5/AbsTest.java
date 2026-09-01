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
package designbook.chapter5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AbsTest {
	
	@Test
	void testAbs_Positive() { 
		assertEquals(5, Math.abs(5)); 
	}
	
	@Test
	void testAbs_Negative() { 
		assertEquals(5, Math.abs(-5)); 
	}
	
	@Test
	void testAbs_Max() { 
		// This test will fail.
		assertEquals(Integer.MAX_VALUE, Math.abs(Integer.MIN_VALUE));
	}
}