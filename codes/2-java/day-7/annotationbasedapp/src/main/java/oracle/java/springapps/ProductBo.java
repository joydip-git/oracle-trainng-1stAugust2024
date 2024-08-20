package oracle.java.springapps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductBo implements BoContract<Product> {

    @Autowired
    private DaoContract<Product> dao;

    // @Autowired
    // public Bo(DaoContract dao) {
    // this.dao = dao;
    // }
    // @Autowired
    // public void setDao(DaoContract dao) {
    // this.dao = dao;
    // }

    @Override
    public Product fetchData() {
        return dao.getData();
    }
}
