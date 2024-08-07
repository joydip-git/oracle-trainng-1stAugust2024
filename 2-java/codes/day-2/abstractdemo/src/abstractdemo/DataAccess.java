package abstractdemo;

public abstract class DataAccess {
	String path;

	public DataAccess() {
	}

	public DataAccess(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	public abstract String getData();
}
