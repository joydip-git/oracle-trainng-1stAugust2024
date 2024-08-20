package oracle.java.calculatorapp.utility;

import java.util.Scanner;

import oracle.java.calculatorapp.businesslogic.Calculator;

public class CalculatorUtility {

	public static void printMenu() {
		System.out.println("\t---Calculator Menu---");
		System.out.println("1. Add \n2. Subtract \n3. Multiply \n4. Divide");
	}

	public static int getChoice(Scanner scanner) {
		System.out.print("\nEnter Choice: ");
		return scanner.nextInt();
	}

	public static int getValue(Scanner scanner) {
		System.out.print("\nEnter Value: ");
		return scanner.nextInt();
	}

	public static Integer calculate(int choice, Calculator calculator, int first, int second) {
		Integer result = null;
		switch (choice) {
		case 1:
			result = calculator.add(first, second);
			break;

		case 2:
			result = calculator.subtract(first, second);
			break;

		case 3:
			result = calculator.multiply(first, second);
			break;

		case 4:
			result = calculator.divide(first, second);
			break;

		default:
			break;
		}
		return result;
	}
	
	public static char askTocontinue(Scanner scanner) {
		System.out.print("\nWould you like to continue[y/Y/n/N]: ");
		char decision = scanner.next().charAt(0);
		if(Character.isUpperCase(decision))
			decision = Character.toLowerCase(decision);
		
		return decision;
	}
}
