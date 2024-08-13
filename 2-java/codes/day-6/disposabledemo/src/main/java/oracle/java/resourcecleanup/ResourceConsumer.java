package oracle.java.resourcecleanup;

import java.io.FileReader;

public class ResourceConsumer implements AutoCloseable {
    private FileReader reader;

    public void readData() {
        try {
            reader = new FileReader("src//data.txt");
            reader.read(new char[100]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("disposing...");
        reader.close();
    }
}
