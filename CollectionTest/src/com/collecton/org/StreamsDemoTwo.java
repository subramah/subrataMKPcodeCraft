package com.collecton.org;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemoTwo {
	public static void main(String[] args) {
		ArrayList<Integer> marks = new ArrayList<Integer>();
		marks.add(45);
		marks.add(56);
		marks.add(90);
		marks.add(89);
		List<Integer> li = marks.stream().map(i -> i * 10).collect(Collectors.toList());
		System.out.println(li);
		System.out.println(marks);
		List<String> locations = Arrays.asList(new String[] { "Pune", "Mumbai", "Chennai", "Banglore", "Noida" });
		Stream<String> stream = locations.stream();
		List<String> result = stream.filter((location) -> location.length() > 5).collect(Collectors.toList());
		result.stream().forEach((city) -> System.out.println(city));
		List<String> cities = Arrays.asList(new String[] { "Pune", "Mumbai", "Chennai", "Banglore", "Noida" });
		System.out.println("Word legnth for locations:");
		cities.stream().map(String::length).forEach(System.out::println);
		System.out.println("My name is Maya");
		List<Integer> intList = Arrays.asList(5, 7, 13, 9, -1);
		Optional<Integer> results = intList.stream().filter((a) -> a > 0).reduce((a, b) -> a > b ? a : b);
		if (results.isPresent()) {
			System.out.println("Result:" + results.get());
		}

		List<Employee> emplist = new ArrayList<>();
		// emplist.add(new Employee("subrata",60000,28,"bangalore"));
		emplist.add(new Employee("subrata", 10000, 28, cities));
		emplist.add(new Employee("ravi", 12000, 30, cities));
		emplist.add(new Employee("rana", 14000, 36, cities));
		emplist.add(new Employee("arun", 15000, 24, cities));
		emplist.add(new Employee("vijay", 15000, 67, cities));
		/*
		 * // add 1000 into every salary (map-->Function )
		 * 
		 * emplist.stream().map(e -> e.getSalary() + 1000).forEach(System.out::println);
		 * 
		 * // display list of emp whose age is > 50 (filter--->predicate)
		 * 
		 * List<Employee> emplistabove50 = emplist.stream().filter(e -> e.getAge() >
		 * 50).toList(); System.out.println(emplistabove50);
		 * 
		 * // display name of emp where starts with "s"(filter--->predicate)
		 * List<Employee> emplistStratwithS = emplist.stream().filter(s ->
		 * s.getName().startsWith("s")).toList();
		 * 
		 * System.out.println(emplistStratwithS);
		 * 
		 * // .filter emp whose salary>10000. these emp salary decrese by 5000 and
		 * filter // emp with name length >8
		 * 
		 * // Filter employees with salary > 10,000 List<Employee> highSalaryEmployees =
		 * emplist.stream().filter(e -> e.getSalary() > 10000) .peek(e ->
		 * e.setSalary(e.getSalary() - 5000)) // .map(e->e.getSalary()-5000)
		 * .collect(Collectors.toList());
		 * 
		 * // Filter employees with name length > 8 List<Employee> filteredEmployees =
		 * highSalaryEmployees.stream().filter(e -> e.getName().length() > 8)
		 * .collect(Collectors.toList());
		 * 
		 * // Print the filtered employees filteredEmployees.forEach(e ->
		 * System.out.println("Name: " + e.getName() + ", Salary: " + e.getSalary()));
		 * 
		 * Supplier<String> otpSupplier = () -> IntStream.range(0, 6) .mapToObj(i ->
		 * String.valueOf((int) (Math.random() * 10))).collect(Collectors.joining());
		 * 
		 * // Get and print the OTP String otp = otpSupplier.get();
		 * 
		 * emplist.forEach(e -> System.out.println("Name: " + e.getName() + ", OTP: " +
		 * otpSupplier.get()));
		 * 
		 * // System.out.println("Generated OTP: " + otp);
		 * 
		 * List<Integer> intlist = Arrays.asList(2, 3, 2, 3, 2, 4, 4, 3, 5, 7, 8, 9, 8);
		 * 
		 * // distinct System.out.println("distinct");
		 * intlist.stream().distinct().forEach(e -> System.out.print(e + ","));
		 * 
		 * // skip System.out.println("skip"); intlist.stream().skip(3).forEach(e ->
		 * System.out.print(e + ","));
		 * 
		 * // limit System.out.println("limit"); intlist.stream().limit(5).forEach(e ->
		 * System.out.print(e + ","));
		 * 
		 * // doubt------ System.out.println(); List<List<String>> cities1 = new
		 * ArrayList<>(); cities1.add(Arrays.asList("mumbai", "chennai"));
		 * cities1.add(Arrays.asList("bangalore", "mumbai"));
		 * cities1.add(Arrays.asList("Miami", "Seattle"));
		 * 
		 * Set<String> flattenedList =
		 * cities1.stream().flatMap(List::stream).collect(Collectors.toSet());
		 * 
		 * System.out.println("Flattened list: " + flattenedList);
		 */		
		
		emplist.stream()
				.sorted(Comparator.comparing(Employee::getName))
				.collect(Collectors.toList())
				.forEach(e->System.out.println(e.getName()));
		
		emplist.stream()
		.sorted(Comparator.comparing(Employee::getSalary)
				.reversed()).collect(Collectors.toList())
		.forEach(e->System.out.println(e.getName()+" "+e.getSalary()));
		
		
		
		System.out.println("============================");
		Optional<Double> minsalary=emplist.stream().map(e->e.getSalary()).min(Double::compare);
		System.out.println("minsalary = "+minsalary.toString());
		
		System.out.println("============================");
		Optional<Double> maxsalary=emplist.stream().map(e->e.getSalary()).max(Double::compare);
		System.out.println("minsalary = "+maxsalary.toString());
		
		System.out.println("============================");
		Optional<Double> reudce = emplist.stream().map(e->e.getSalary()).max(Double::compare);
		System.out.println("minsalary = "+maxsalary);
		
		
		BiFunction<Integer, Integer, Integer> sum=(a,b)->a+b;
		
		System.out.println("bifunc ="+sum.apply(12, 12));
		
		BinaryOperator<Integer> sum1 = (a,b)->a+b;
				BinaryOperator.minBy(Integer::compareTo);
        System.out.println("sum value = "+sum1.apply(5, 11));
		
		UnaryOperator<Integer> squre= num->num*num;
		System.out.println("squere "+squre.apply(3));
		
		
		
		Optional<String> nonEmptyOptional = Optional.of("Hello, World!");
		Optional<String> nullableOptional = Optional.ofNullable(null);
		Optional<String> emptyOptional = Optional.empty();
		
		Optional<String> messageOptional = Optional.of("Hello, Optional!");
		if (messageOptional.isPresent()) {
		    System.out.println(messageOptional.get()); // Prints the message
		}
		
		
		Optional<String> maybeName = Optional.ofNullable(null);
		String name = maybeName.orElse("Unknown");
		
		Optional<String> original = Optional.of("Java");
		Optional<Integer> lengthOptional = original.map(String::length);
		
		
		Optional<String> greeting = Optional.of("Hello");
		greeting.ifPresent(msg -> System.out.println(msg + " from Optional!"));
		
		
		
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(101, "John", "john@gmail.com"));
		customers.add(new Customer(102, "Alice", "alice@yahoo.com"));
		customers.add(new Customer(103, "Bob", "bob@gmail.com"));

		String searchEmail="abc@gmail.com";
		
		Optional<Customer> firstCustomer = customers.stream()
                .filter(c -> c.email.equalsIgnoreCase(searchEmail))
                .findFirst();
            //    .findFirst().orElseGet("not found"); //need to fix

        if (firstCustomer.isPresent()) {
        	Customer c = firstCustomer.get();
            System.out.println("Customer found with email " + searchEmail + ":");
            System.out.println("ID: " + c.name + ", Name: " + c.email);
        } else {
            System.out.println("No Customer found with email: " + searchEmail);
        }
		

	}
}
