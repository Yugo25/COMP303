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

/** Represents an employee in a company. */
class Employee {
	String name;
	String title = "Developer"; // Default value
	Department department;
}

/** Represents a department in a company. */
class Department {
	String name;
	
	Department(String name) {
		this.name = name;
	}

	String getName() {
		return "Department of " + this.name;
	}
}

/**
 * This class represents "client code" and it purpose is only to hold the main
 * method.
 */
class ClassesAndObjects {
	public static void main(String[] args) {
		// Create a new Employee object with the default constructor
		Employee employee = new Employee();

		/*
		 * Accessing fields directly is not a recommended practice. We do it
		 * here only to illustrate the runtime structure of an object.
		 */
		employee.name = "Dilbert";
		
		// Create a new Department object with an explicit constructor.
		Department department = new Department("Great Features");
		
		employee.department = department;
		
		IO.println(employee.name);
		IO.println(employee.title);
		IO.println(employee.department.name);
		IO.println(employee.department.getName());
	}
}