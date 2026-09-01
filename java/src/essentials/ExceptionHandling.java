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
package essentials;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExceptionHandling {
	
	public static void main(String[] args) {
		try {
			throwsChecked();
		}
		catch (NullPointerException nullPointerException) {
			nullPointerException.printStackTrace();
		}
		catch (IOException ioException) {
			System.out.println("Caught an IOException with message: " 
					+ ioException.getMessage());
		}
		finally {
			System.out.println("This code always executes");
		}
		throwsUnchecked();

		/* This call will not execute */		 
		throwsExplicit(null);
	}

	/* This method throws an unchecked (runtime) exception of type
	 * NumberFormatException. */
	public static void throwsUnchecked() {
		Integer.parseInt("Not a number");
	}

	/* This method throws a checked exception. */
	public static void throwsChecked() throws IOException {
		Files.getLastModifiedTime(Path.of("NONEXISTENT FILE"));
	}

	/* This method explicitly throws an IllegalStateException */
	public static void throwsExplicit(String message) {
		if( message == null ) {
			throw new IllegalArgumentException("Message cannot be null");
		}
		IO.println(message);
	}
}