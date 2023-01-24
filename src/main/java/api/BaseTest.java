package api;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utilClasses.ConfigContainer;

public abstract class BaseTest {
    public static final String BASE_URI = new ConfigContainer().getProperty("baseURI");
    protected static final Logger LOGGER = LogManager.getLogger(BaseTest.class);

    public BaseTest() {
        PropertyConfigurator.configure("src/test/resources/log4j/log4j.properties");
    }
}
