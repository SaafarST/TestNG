package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigsWriter {
    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.dir")+"/configs/configuration.properties";
        FileInputStream fis = new FileInputStream(filePath);
        Properties properties = new Properties();
        properties.load(fis);

        properties.setProperty("Phone","+7 915 915 222");
        properties.setProperty("email","testerr@gmail.com");

        FileOutputStream fos = new FileOutputStream(filePath);
        properties.store(fos,"Adding phone number and email");

    }
}
