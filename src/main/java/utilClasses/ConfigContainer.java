package utilClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigContainer {

    private static final String PATH_TO_CONFIG_PROPERTIES = "src/test/resources/config/conf.properties";
    private static Properties PROPERTIES;

    public ConfigContainer() {
        try {
            FileInputStream fileInputStream = new FileInputStream(PATH_TO_CONFIG_PROPERTIES);
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) throws NullPointerException {
        var value = PROPERTIES.getProperty(key);
        if (value.isEmpty()) {
            throw new NullPointerException("For key:" + key + " don't exist value");
        }
        else {
            return value;
        }
    }
}
