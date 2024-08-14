package oracle.java.springapps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // ApplicationContext context = new
        // ClassPathXmlApplicationContext("beans-config.xml");
        // BoContract bo = (BoContract) context.getBean("boBean");

        ApplicationContext context = new ClassPathXmlApplicationContext("beanconfig.xml");
        // BoContract bo = context.getBean(ProductBo.class);
        BoContract<Product> productBo = context.getBean(ProductBo.class);
        System.out.println(productBo.fetchData());

        BoContract<Category> categoryBo = context.getBean(CategoryBo.class);
        System.out.println(categoryBo.fetchData());
    }
}
