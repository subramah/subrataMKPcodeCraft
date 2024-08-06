package com.collecton.org;

import java.util.ArrayList;
import java.util.List;

public class SortEmployeeList {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("John", 50000));
		employees.add(new Employee("Jane", 60000));
		employees.add(new Employee("Jack", 40000));

		// Sort by name in ascending order
		employees.sort(new EmployeeComparator());

		// Print the sorted list
		for (Employee emp : employees) {
			System.out.println(emp);
		}
	}
}
	