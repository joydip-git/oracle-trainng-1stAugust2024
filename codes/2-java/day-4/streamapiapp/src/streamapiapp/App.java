package streamapiapp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {
		List<Integer> input = List.of(1, 4, 2, 3, 8, 0, 5, 9, 6, 7);
		/*
		 * Stream<Integer> inputStream = input.stream();
		 * 
		 * Predicate<Integer> isEven = (num) -> num % 2 == 0; Stream<Integer>
		 * filteredStream = inputStream.filter(isEven);
		 * 
		 * Comparator<Integer> isGreater = (a, b) -> a - b; Stream<Integer> sortedStream
		 * = filteredStream.sorted(isGreater);
		 * 
		 * Consumer<Integer> printValue = (num) -> System.out.println(num);
		 * sortedStream.forEach(printValue);
		 */
		input.stream()
		.filter(num -> num % 2 == 0)
		.sorted((a, b) -> a - b)
		.forEach(num -> System.out.println(num));
	}

}
