package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigContainer {

    private static final String PATH_TO_CONFIG_PROPERTIES = "src/test/resources/config/conf.properties";
    private static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;


    public ConfigContainer() {
        try {
            fileInputStream = new FileInputStream(PATH_TO_CONFIG_PROPERTIES);
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
