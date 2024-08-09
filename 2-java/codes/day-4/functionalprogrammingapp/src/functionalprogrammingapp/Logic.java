package functionalprogrammingapp;

//public class Logic {
//	public boolean isEven(int number) {
//		return number % 2 == 0;
//	}
//	public static boolean isOdd(int number) {
//		return number % 2 != 0;
//	}
//}

@FunctionalInterface
public interface Logic<E> {
	boolean apply(E number);
}
