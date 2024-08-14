package oracle.java.springapps;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDao implements DaoContract<Product> {

    @Override
    public Product getData() {
        return new Product();
    }

}
