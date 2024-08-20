package oracle.java.payrollapp.userinterface;

import java.util.Scanner;

import oracle.java.payrollapp.entities.Developer;
import oracle.java.payrollapp.entities.Employee;
import oracle.java.payrollapp.entities.Hr;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 1. ask user for number of emloyees
		int count = getRecordCount(scanner);

		// 2. create a storage
		Employee[] employees = new Employee[count];

		// 3. create an instance and store in the array
		save(employees, scanner);

		// 4. iterate the array and calculate and print the salary
		printSalary(employees);
	}

	private static void printSalary(Employee[] employees) {
		for (Employee employee : employees) {
			//employee.calculateSalary();
			System.out.println(employee.getName() + " got salary of " + employee.getTotalPayment());
		}
	}

	static int getRecordCount(Scanner scanner) {
		System.out.print("how many records: ");
		return scanner.nextInt();
	}

	static void printMenu() {
		System.out.println("\n1. Developer\n2. Hr");
	}

	static int getChoice(Scanner scanner) {
		System.out.print("\nenter choice[1/2]: ");
		return scanner.nextInt();
	}

	static Employee createEmployee(int choice, Scanner scanner) {
		System.out.println("\nName: ");
		String name = scanner.next();

		System.out.println("\nId: ");
		int id = scanner.nextInt();

		System.out.println("\nBasic: ");
		double basic = scanner.nextDouble();

		System.out.println("\nDa: ");
		double da = scanner.nextDouble();

		System.out.println("\nHra: ");
		double hra = scanner.nextDouble();

		Employee employee = null;

		switch (choice) {
		case 1:
			System.out.println("\nIncentive: ");
			double incentive = scanner.nextDouble();
			employee = new Developer(name, id, basic, da, hra, incentive);
			break;

		case 2:
			System.out.println("\nGratuity: ");
			double gratuity = scanner.nextDouble();
			employee = new Hr(name, id, basic, da, hra, gratuity);
			break;

		default:
			break;
		}

		if (employee != null)
			employee.calculateSalary();

		return employee;
	}

	static void save(Employee[] employees, Scanner scanner) {
		for (int i = 0; i < employees.length; i++) {
			printMenu();
			int choice = getChoice(scanner);
			Employee employee = createEmployee(choice, scanner);
			employees[i] = employee;
		}
	}
}
