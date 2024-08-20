package oracle.java.resourcecleanup;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // ResourceConsumer consumer = null;
        // try {
        // consumer = new ResourceConsumer();
        // consumer.readData();
        // consumer.close();
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        // try with resource
        try (
                ResourceConsumer consumer1 = new ResourceConsumer("C1");
                ResourceConsumer consumer2 = new ResourceConsumer("C2")) {
            consumer1.readData();
            consumer2.readData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
