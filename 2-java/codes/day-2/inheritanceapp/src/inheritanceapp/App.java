package inheritanceapp;

public class App {

	public static void main(String[] args) {
		Trainer joydipTrainer = new Trainer("joydip", 1, "Java");
		Trainee anilTrainee = new Trainee("anil", 2, "CTA");
		display(joydipTrainer);
		display(anilTrainee);
	}
	static void display(Person person) {
		System.out.println(person.print());
		//print Trainer or Trainee Information
//		if(person instanceof Trainer) {
//			Trainer t = (Trainer)person;
//			System.out.println(t.print());
//		}
//		if(person instanceof Trainee) {
//			Trainee t = (Trainee)person;
//			System.out.println(t.print());
//		}		
	}
//	static void display(Trainer trainer) {
//
//	}
//
//	static void display(Trainee trainee) {
//
//	}
	
}
