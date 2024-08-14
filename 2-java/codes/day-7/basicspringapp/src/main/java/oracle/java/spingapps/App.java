package oracle.java.spingapps;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            Person anilPerson = (Person) context.getBean("anilBean");
            // System.out.println(anilPerson.getFirstName() + " " + anilPerson.getLastName()
            // + ", " + anilPerson.getId());

            Person sunilPerson = (Person) context.getBean("sunilBean", Person.class);
            // System.out
            // .println(sunilPerson.getFirstName() + " " + sunilPerson.getLastName() + ", "
            // + sunilPerson.getId());

            List<Person> people = new ArrayList<>();
            people.add(anilPerson);
            people.add(sunilPerson);

            people.stream().forEach(p -> System.out.println(p.getFirstName()));

            BoContract bo = (BoContract) context.getBean("boBean");
            System.out.println(bo.fetchData());
        } catch (BeansException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
