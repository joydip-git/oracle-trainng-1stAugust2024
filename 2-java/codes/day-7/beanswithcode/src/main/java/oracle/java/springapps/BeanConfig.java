package oracle.java.springapps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    // @Autowired
    // public BoContract bo(DaoContract daoObj) {
    public BoContract bo() {
        // return new Bo(daoObj);
        return new Bo();
    }

    @Bean
    public DaoContract dao() {
        return new Dao();
    }

    @Bean
    public String string() {
        return "hello ";
    }
}
