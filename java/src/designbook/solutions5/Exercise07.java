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

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.EmptyStackException;
import java.util.Stack;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class Exercise07 {

	private final Stack<String> aStack = new Stack<>();

	@Test
	void testPush_Empty() {
		String foo = "foo";
		assertSame(foo, aStack.push(foo));
		assertSame(foo, aStack.peek());
	}

	@Test
	void testPush_NonEmpty() {
		aStack.push("A");
		String foo = "foo";
		assertSame(foo, aStack.push(foo));
		assertSame(foo, aStack.peek());
	}

	@Test
	void testPush_Null() { // Stack (i.e., Vector) allows null references as elements
		assertNull(aStack.push(null));
		assertNull(aStack.peek());
	}

	@Test
	void testPop_NonEmpty() {
		String foo = "foo";
		aStack.push(foo);
		assertSame(foo, aStack.pop());
		assertTrue(aStack.isEmpty());
	}

	@Test
	void testPop_Empty() {
		assertThrows(EmptyStackException.class, new Executable() {
			public void execute() throws Throwable {
				aStack.pop();
			}
		});
	}
}