package newfeatures;

import java.util.function.*;

public class App {

	public static void main(String[] args) {
		/*
		 * Sample sample = new SampleImplementation();
		 * System.out.println(sample.extra());
		 * System.out.println(sample.getMessage("anil")); Sample.staticExtra();
		 * 
		 * Sample anonymousSample = new Sample() {
		 * 
		 * @Override public String getMessage(String name) { return "welcome " + name; }
		 * 
		 * @Override public String extra() { return "this is overriden extra"; } };
		 * System.out.println(anonymousSample.extra());
		 * 
		 * Sample sampleLambda = (value) -> { return "hello " + value; }; Sample
		 * sampleLambdaAgain = (value) -> "hello " + value;
		 * 
		 * // Consumer<Integer> numberConsumer = new Consumer<Integer>() { // @Override
		 * // public void accept(Integer t) { // // } // };
		 */

//		Consumer<Integer> numberConsumer = (value) -> System.out.println(++value);
//		numberConsumer = numberConsumer.andThen((value) -> System.out.println(value * 2))
//				.andThen(value -> System.out.println(value));
//		numberConsumer.accept(12);

		BiConsumer<Integer, Integer> biConsumer = new BiConsumer<Integer, Integer>() {

			@Override
			public void accept(Integer t, Integer u) {
				// TODO Auto-generated method stub

			}
		};

		Function<Integer, Integer> increaseFunction = num -> ++num;
//		Function<Integer, Integer> composedFunction = 
//				increaseFunction
//				.andThen(num -> num * 2)
//				.andThen(num -> num-2);
		Function<Integer, Integer> composedFunction = increaseFunction.compose(num -> ((Integer) num) * 2)
				.compose(num -> num - 2);
		Integer value = composedFunction.apply(12);
		System.out.println(value);

		BiPredicate<Integer, Integer> isGreater = (x, y) -> x > y;
	}

}
