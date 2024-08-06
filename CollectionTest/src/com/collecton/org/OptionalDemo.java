package com.collecton.org;

import java.util.Optional;

public class OptionalDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creating an Optional with a non-null value
		Optional<String> optionalValue = Optional.of("Hello");

		// Checking if the value is present
		if (optionalValue.isPresent()) {
			System.out.println("Value is present: " + optionalValue.get());
		} else {
			System.out.println("Value is absent");
		}

		// Getting the value if present or providing a default value
		String value = optionalValue.orElse("Default");
		System.out.println("Value: " + value);

		// Creating an Optional with a null value
		Optional<String> emptyOptional = Optional.ofNullable(null);

		// Checking if the value is present
		if (emptyOptional.isPresent()) {
			System.out.println("Value is present: " + emptyOptional.get());
		} else {
			System.out.println("Value is absent");
		}

		// Getting the value if present or providing a default value
		String emptyValue = emptyOptional.orElse("Default");
		System.out.println("Value: " + emptyValue);
	}
}
