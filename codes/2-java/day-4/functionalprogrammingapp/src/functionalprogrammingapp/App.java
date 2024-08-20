package functionalprogrammingapp;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class App {

	public static void main(String[] args) {
		/*
		 * Parent p = new Parent(); Parent.Nested nested = p.new Nested();
		 * System.out.println(nested.getMessage());
		 * 
		 * // ParentContract pi = new ParentImplementation(); //
		 * System.out.println(pi.add(12, 13));
		 * 
		 * ParentContract pi = new ParentContract() {
		 * 
		 * @Override public int add(int x, int y) { return x + y; }
		 * 
		 * @Override public int subtract(int x, int y) { return x - y; } };
		 * System.out.println(pi.add(12, 13));
		 */

		Class<Logic> logicClsInfo = Logic.class;
		Method[] allMethods = logicClsInfo.getMethods();
		for (Method method : allMethods) {
			System.out.println(method.getName());
			System.out.println(method.getReturnType());
			Parameter[] allParams = method.getParameters();
			if (allParams.length > 0) {
				System.out.println("parameters of method: " + method.getName());
				for (Parameter parameter : allParams) {
					System.out.println(parameter.getName());
					System.out.println(parameter.getType().getSimpleName());
				}
			}
			// method.invoke(logicClsInfo.newInstance(), args);
			System.out.println("\n");
		}

		Logic<Integer> logic = new Logic<Integer>() {
			@Override
			public boolean apply(Integer number) {
				return number % 2 == 0;
			}
		};

		Logic<Integer> oddLogic = new Logic<Integer>() {

			@Override
			public boolean apply(Integer number) {
				return number % 2 != 0;
			}
		};

		Logic<Integer> greaterLogic = new Logic<Integer>() {
			@Override
			public boolean apply(Integer number) {
				return number >= 5;
			}
		};

		// Logic lessThan = (number) -> number < 5;
		Logic<Integer> lessThan = (Integer number) -> {
			return number < 5;
		};

		List<Integer> input = List.of(1, 4, 2, 3);
		sortValues(input, (a, b) -> a - b);
		for (Integer value : input) {
			System.out.println(value);
		}
		
		Stream<Integer>
		/*
		 * List<Integer> result = filter(input, logic); for (Integer intValue : result)
		 * { System.out.println(intValue); }
		 * 
		 * List<String> names = List.of("anil", "sunil", "joy"); Logic<String>
		 * filterNames = (name) -> name.contains("n"); List<String> filteredNames =
		 * filter(names, filterNames); for (String name : filteredNames) {
		 * System.out.println(name); }
		 * 
		 * Predicate<Integer> p = null;
		 */
	}

	static <E extends Object> List<E> filter(List<E> input, Logic<E> logic) {
		List<E> output = new ArrayList<E>();
		for (E value : input) {
			if (logic.apply(value))
				output.add(value);
		}
		return output;
	}

	static <E> void sortValues(List<E> input, CompareLogic<E> comp) {
		for (int i = 0; i < input.size(); i++) {
			for (int j = i + 1; j < input.size(); j++) {
				if (comp.compare(input.get(i), input.get(j)) > 0) {
					E temp = input.get(i);
					input.set(i, input.get(j));
					input.set(j, temp);
				}
			}
		}
	}
}
