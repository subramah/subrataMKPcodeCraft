package com.collecton.org;

import java.util.Comparator;

class EmployeeComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee emp1, Employee emp2) {
		// Compare by salary
		// int salaryComparison = Double.compare(emp1.getSalary(), emp2.getSalary());
		if (emp1.getSalary() < emp2.getSalary()) {
			return -1;
		} else if (emp1.getSalary() > emp2.getSalary()) {
			return 1;
		} else {
			return 0;
		}
	}
}
