package inheritanceapp;

public class Person {
	private String name;
	private int id;

	public Person() {
		System.out.println("default ctor of Person");
	}

	public Person(String name, int id) {
		System.out.println("parameterized ctor of Person");
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String print() {
		return this.name + " " + this.id;
	}
}
