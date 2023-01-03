package utilClasses;

import enums.BrowserName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverContainer {

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

    private static ChromeDriver getChromeDriverSetting() {
        System.setProperty("webdriver.chrome.driver", new ConfigContainer().getProperty("chromeDriver"));
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-popup-blocking");
        return new ChromeDriver(chromeOptions);
    }

}
