package oracle.java.outstandingapp.userinterface;

import oracle.java.outstandingapp.entities.Person;
import oracle.java.outstandingapp.entities.Profesor;
import oracle.java.outstandingapp.entities.Student;

public class App {

	public static void main(String[] args) {
		Person[] people = new Person[4];
		people[0] = new Profesor("anil", 7);
		people[1] = new Student("sunil", 78);
		people[2] = new Profesor("vikash", 3);
		people[3] = new Student("suresh", 87);

		for (Person person : people) {
			if (person != null) {
				if (person.isOutStanding()) {
					System.out.println(person.getName() +" is outstanding "+person.getClass().getSimpleName());
				}
			}
		}
	}
}
