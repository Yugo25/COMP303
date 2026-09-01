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

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.*; // Not recommended

import static java.lang.String.format;
import static java.lang.System.*; // Not recommended

/**
 * This sample prints the current date and all the files in the current
 * directory with their size in bytes to illustrate how types in 
 * different packages can be imported to avoid having to use their 
 * fully-qualified name.
 */
class Importing {
	public static void main(String[] args) throws IOException {
		System.out.println(new java.util.Date());
		for( String fileName : new File(".").list() ) {
			out.println(format("%s (%d bytes)", fileName, Files.size(Path.of(fileName))));
		}
	}
}