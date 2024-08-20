package oracle.java.outstandingapp.entities;

public class Profesor extends Person {

	private int booksPublished;

	public Profesor() {
	}

	public Profesor(String name, int booksPublished) {
		super(name);
		this.booksPublished = booksPublished;
	}

	public int getBooksPublished() {
		return booksPublished;
	}

	public void setBooksPublished(int booksPublished) {
		this.booksPublished = booksPublished;
	}

	@Override
	public boolean isOutStanding() {
		return booksPublished >= 5 ? true : false;
	}
}
