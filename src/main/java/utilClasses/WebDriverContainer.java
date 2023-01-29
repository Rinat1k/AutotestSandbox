package utilClasses;

import enums.BrowserName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class WebDriverContainer {

    private final static String SELENIUM_SERVER_URL = "http://localhost:4444/wd/hub";

    public static WebDriver getCustomizedDriver(BrowserName browserName) throws IllegalArgumentException {
        switch (browserName) {
            case CHROME -> {
                return getChromeDriverSetting();
            }
            case OPERA -> {
                throw new IllegalArgumentException("For opera browser setting don't defined");
            }
            case EDGE -> {
                throw new IllegalArgumentException("For edge browser setting don't defined");
            }
            case MOZILLA -> {
                throw new IllegalArgumentException("For mozilla browser setting don't defined");
            }
            default -> throw new IllegalArgumentException("For this browser setting don't exist");
        }
    }

    private static WebDriver getChromeDriverSetting() {
//        System.setProperty("webdriver.chrome.driver", new ConfigContainer().getProperty("chromeDriver"));
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-popup-blocking");
        return new RemoteWebDriver(getSeleniumServerURL(), chromeOptions);
    }


    public static URL getSeleniumServerURL() {
        URL url = null;
        try {
          url = new URL(SELENIUM_SERVER_URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Objects.requireNonNull(url);
        return url;
    }
}
