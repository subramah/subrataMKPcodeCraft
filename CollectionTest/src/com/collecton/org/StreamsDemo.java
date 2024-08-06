package com.collecton.org;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creating a list of integers
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// Example of filter method
		System.out.println("Filtered numbers greater than 5:");
		List<Integer> filteredNumbers = numbers.stream().filter(num -> num > 5).collect(Collectors.toList());
		System.out.println(filteredNumbers);

		// Example of map method
		System.out.println("\nNumbers multiplied by 2:");
		List<Integer> mappedNumbers = numbers.stream().map(num -> num * 2).collect(Collectors.toList());
		System.out.println(mappedNumbers);

		// Example of reduce method
		Optional<Integer> sum = numbers.stream().reduce((a, b) -> a + b);
		System.out.println("\nSum of numbers: " + sum.orElse(0));

		// Example of forEach method
		System.out.println("\nPrinting each number:");
		numbers.stream().forEach(System.out::println);

		// Example of limit method
		System.out.println("\nFirst 3 numbers:");
		numbers.stream().limit(3).forEach(System.out::println);

		// Example of skip method
		System.out.println("\nSkipping first 5 numbers:");
		numbers.stream().skip(5).forEach(System.out::println);

		// Example of sorted method
		System.out.println("\nSorted numbers:");
		numbers.stream().sorted().forEach(System.out::println);

		// Example of distinct method
		System.out.println("\nDistinct numbers:");
		List<Integer> distinctNumbers = Stream.of(1, 2, 2, 3, 3, 4, 5, 5).distinct().collect(Collectors.toList());
		System.out.println(distinctNumbers);
		// Example of flatMap method
		System.out.println("\nFlattened list of lists:");
		List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));
		List<Integer> flattenedList = listOfLists.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
		System.out.println(flattenedList);

		// Example of reduce method
		Optional<Integer> sum1 = numbers.stream().peek(System.out::println) // Peek for debugging
				.reduce((a, b) -> a + b);
		System.out.println("\nSum of numbers: " + sum1.orElse(0));
	}
}
