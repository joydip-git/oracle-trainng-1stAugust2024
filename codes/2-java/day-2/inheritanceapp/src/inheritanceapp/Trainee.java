package inheritanceapp;

public class Trainee extends Person {
	private String projetName;

	public Trainee() {		
	}

	public Trainee(String name, int id, String projectName) {
		super(name, id);
		this.projetName = projectName;
	}

	public String getProjetName() {
		return projetName;
	}

	public void setProjetName(String projetName) {
		this.projetName = projetName;
	}
	
	@Override
	public String print() {
		return super.print()+" "+this.projetName;
	}
}
