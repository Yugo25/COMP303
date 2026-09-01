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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Exercise06 {

	/**
	 * Checks that we can call any public parameterless method of class String on an
	 * empty string without raising an exception.
	 */
	public static void main(String[] args) {
		for (Method method : String.class.getDeclaredMethods()) {
			if (method.getParameterCount() == 0 && 
					Modifier.isPublic(method.getModifiers())) {
				try {
					method.invoke("");
				}
				catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					IO.println("No, we cannot: " + e.getMessage());
					System.exit(0);
				}
			}
		}
		IO.println("Yes, we can!");
	}
}