package abstractdemo;

public class DbDataAccess extends DataAccess {

	public DbDataAccess() {		
	}

	public DbDataAccess(String path) {
		super(path);
	}

	@Override
	public String getData() {
		return "db data";
	}

}
