package inheritanceapp;

public class Trainer extends Person {
	private String subject;

	public Trainer() {
		System.out.println("default ctor of Trainer");
	}

	public Trainer(String name, int id, String subject) {
		super(name, id);
		System.out.println("parameterized ctor of Trainer");
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}	
	
	@Override
	public String print() {
		return super.print()+" "+this.subject;
	}
}
