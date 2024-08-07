package abstractdemo;

public class FileDataAccess extends DataAccess {

	public FileDataAccess() {
	}

	public FileDataAccess(String path) {
		super(path);
	}

	@Override
	public String getData() {
		return "file data";
	}
}
