package oracle.java.spingapps;

public class Bo implements BoContract {
    private DaoContract dao;

    public Bo(DaoContract dao) {
        this.dao = dao;
    }

    @Override
    public String fetchData() {
        return dao.getData();
    }
}
