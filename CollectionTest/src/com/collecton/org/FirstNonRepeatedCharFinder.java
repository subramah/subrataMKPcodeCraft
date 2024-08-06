package com.collecton.org;

import java.util.HashMap;

public class FirstNonRepeatedCharFinder {
	public static char findFirstNonRepeatedChar(String input) {
		// Create a HashMap to store character frequencies
		HashMap<Character, Integer> charCount = new HashMap<>();

		// Iterate through the string and update character counts
		for (char c : input.toCharArray()) {
			charCount.put(c, charCount.getOrDefault(c, 0) + 1);
		}

		// Find the first non-repeated character
		for (char c : input.toCharArray()) {
			if (charCount.get(c) == 1) {
				return c;
			}
		}

		// If no non-repeated character found, return '\0'
		return '\0';
	}

	public static void main(String[] args) {
		String input = "abacddbe"; // Replace with your input string
		char result = findFirstNonRepeatedChar(input);
		if (result != '\0') {
			System.out.println("The first non-repeated character in '" + input + "' is '" + result + "'.");
		} else {
			System.out.println("No non-repeated character found in '" + input + "'.");
		}
	}
}
