package oracle.java.calculatorapp.userinterface;

//import java.io.InputStream;
import java.util.Scanner;

import oracle.java.calculatorapp.utility.CalculatorUtility;
import oracle.java.calculatorapp.businesslogic.Calculator;

public class App {

	public static void main(String[] args) {
		char toContinue = 'n';
		//InputStream inputStream = System.in;
		Scanner scanner = new Scanner(System.in);
		Calculator calculator = new Calculator();
		do {

			//1. print menu
			CalculatorUtility.printMenu();
			
			//2. get choice
			int choice = CalculatorUtility.getChoice(scanner);
			
			//3. get the values
			int first = CalculatorUtility.getValue(scanner);
			int second = CalculatorUtility.getValue(scanner);
			
			//4. perform calculation
			Integer result = CalculatorUtility.calculate(choice, calculator, first, second);
			if(result!=null)
				System.out.println(result);
			else 
				System.out.println("could not calculate");
			
			toContinue = CalculatorUtility.askTocontinue(scanner);
			
		} while (toContinue != 'n');
	}	
}
