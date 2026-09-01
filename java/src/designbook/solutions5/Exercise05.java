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

public class Exercise05 {

	public static void main(String[] args) {
		if (args.length != 2)
			error("Invalid number of arguments");
		try {
			Class<?> numberClass = Class.forName("java.lang." + args[0]);
			Number number = (Number) numberClass.getDeclaredMethod("valueOf", String.class).invoke(null, args[1]);
			IO.println(number + " is a number of type " + number.getClass().getName());
		}
		catch (ReflectiveOperationException exception) {
			error("Invalid number type");
		}
		catch (NumberFormatException exception) {
			error("Invalid number format");
		}
	}

	private static void error(String pMessage) {
		IO.println(pMessage);
		System.exit(1);
	}
}