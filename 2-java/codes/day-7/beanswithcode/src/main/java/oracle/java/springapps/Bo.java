package oracle.java.springapps;

import org.springframework.beans.factory.annotation.Autowired;

public class Bo implements BoContract {

    @Autowired
    private DaoContract dao;

    // public Bo(DaoContract dao) {
    //     this.dao = dao;
    // }

    @Override
    public String fetchData() {
        return dao.getData();
    }

}
