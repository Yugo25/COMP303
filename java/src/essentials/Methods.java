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

class Point {
	private int x;
	private int y;
	
	Point(int pX, int pY) {
		x = pX;
		y = pY;
	}
	
	/* An instance method to move the current point. */
	void move1(int deltaX, int deltaY) {
		this.x += deltaX;
		this.y += deltaY;
	}
	
	/* A static method to move the point argument. */
	static void move2(Point point, int deltaX, int deltaY) {
		point.x += deltaX;
		point.y += deltaY;
	}
	
	/* An instance method that returns a new point at a different position
	 * from the current point. */
	Point copyAndMove(int deltaX, int deltaY) {
		return new Point(this.x + deltaX, this.y + deltaY);
	}
}

/* This class serves as the client code calling various methods. */
public class Methods {
	public static void main(String[] args) {
		IO.println("Absolute value of -5 is " + Math.abs(-5));
		String hello = "Hello";
		System.out.println("Length of \"Hello\" is " + hello.length());
		
		Point point = new Point (3,4);
		
		// Moving point with a static method.
		Point.move2(point, 2, 2);
		
		// Moving point with an equivalent instance method
		point.move1(2, 2);
		
		// Creating a new, moved point
		Point other = point.copyAndMove(2, 2);
	}
}