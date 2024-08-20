package oracle.java.springapps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryBo implements BoContract<Category> {

    @Autowired
    private DaoContract<Category> dao;

    @Override
    public Category fetchData() {
        return dao.getData();
    }

}
