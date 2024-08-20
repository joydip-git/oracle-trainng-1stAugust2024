package wordcountapp;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.HashSet;
//import java.util.regex.

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter a sentence");
		String sentence = scanner.nextLine();
		Map<String, Integer> wordCollection = countWordFrequency(sentence);
		for (Entry<String, Integer> entry : wordCollection.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		scanner.close();
	}

	private static Map<String, Integer> countWordFrequency(String sentence) {
		String[] words = splitSentence(sentence);
		Map<String, Integer> wordCount = new TreeMap<String, Integer>();
		for (String string : words) {
			wordCount.put(string.toLowerCase(), wordCount.getOrDefault(string.toLowerCase(), 0) + 1);
		}
		return wordCount;
	}

	private static String[] splitSentence(String sentence) {
		String[] words = sentence.split("\\W+", 0);
		return words;
	}
}
