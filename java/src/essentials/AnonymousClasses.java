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

public class AnonymousClasses {
	private static final int MIN_LENGTH = 5;
	
	private static final StringSelector SELECT_ALL = new StringSelector() {		
				public boolean accept(String string) {
					return true;
				}
			};
	
	public static void main(String[] args) {
		
		// Simple anonymous class implementing an interface
		StringSelector selectUpperCase = new StringSelector() {
					public boolean accept(String string) {
						return string.equals(string.toUpperCase());
					}
				};
		IO.println(selectUpperCase.getClass());
		IO.println(selectUpperCase.accept("UPPER"));
		
		// Anonymous class with variable capture
		int maxLength = 5;
		StringSelector selectSizeAndNotEquals = new StringSelector() {
					public boolean accept(String string) {
						return !string.equals(args[0]) && 
								string.length() <= maxLength && 
								string.length() >= MIN_LENGTH;
					}
				};
		if (args.length > 0 && args[0] != null ) {
			IO.println(selectSizeAndNotEquals.accept("A string"));
		}
		
		// Anonymous class through inheritance and with field and methods
		Object object = new Object() {
			
			private int numberOfCalls = 0;
			
			private String getMessage() {
				return String.format("%s (called %d times)", 
						super.toString(), ++numberOfCalls);
			}
			
			@Override
			public String toString() {
				return getMessage();
			}
		};
		IO.println(object.toString());
		IO.println(object.toString());
	}
}

interface StringSelector {
	boolean accept(String string);
}