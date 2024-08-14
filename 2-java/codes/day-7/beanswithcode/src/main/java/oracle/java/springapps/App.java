package oracle.java.springapps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        BoContract bo = context.getBean(Bo.class);
        System.out.println(bo.fetchData());

        String value = context.getBean(String.class);
        System.out.println(value);
    }
}
