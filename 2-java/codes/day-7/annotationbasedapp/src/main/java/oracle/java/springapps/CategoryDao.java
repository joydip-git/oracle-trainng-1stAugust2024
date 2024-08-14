package oracle.java.springapps;

import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao implements DaoContract<Category> {

    @Override
    public Category getData() {
        return new Category();
    }

}
