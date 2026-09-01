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

public class Types {
	
	public static void main(String[] args) {
		int day = 25;
		Integer month = Integer.valueOf(3); // March
		Integer year = 2024;
		
		String[] months = {"January", "February", "March", "April", "May"}; // ...
		
		IO.println(day + " " + months[month-1] + " " + year);
		
		IO.println(String.join(" ", Integer.toString(day), 
				months[month-1], Integer.toString(year)));
		
		// Copying the value of a primitive type copies the primitive value
		int dayCopy = day;
		day++;
		System.out.println("dayCopy=" + dayCopy);
		
		// Copying the value of a reference type creates an alias to the same object
		String[] monthsAlias = months;
		months[0] = "JANUARY";
		IO.println("monthsAlias[0]=" + monthsAlias[0]);
	}
}