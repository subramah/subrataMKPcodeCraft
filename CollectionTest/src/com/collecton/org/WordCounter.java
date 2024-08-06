package com.collecton.org;

import java.util.HashMap;

public class WordCounter {

	public static void main(String[] args) {

		String input = "My name is mahato mahato";
		// Split the input string into words
		String[] words = input.split("\\s+");
		int count = 1;
		// Create a HashMap to store word frequencies
		HashMap<String, Integer> wordCountMap = new HashMap<>();

		// Update word counts
		for (String word : words) {

			if (wordCountMap.containsKey(word)) {

				wordCountMap.put(word, count+1);
			} else {
				wordCountMap.put(word, 1);
			}

		}

		// Print word frequencies
		for (String word : wordCountMap.keySet()) {
			System.out.println(word + ": " + wordCountMap.get(word));
		}
	}

}
