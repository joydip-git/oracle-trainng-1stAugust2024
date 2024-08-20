package oracle.java.springapps;

public class Dao implements DaoContract {

    @Override
    public String getData() {
        return "data";
    }

}
