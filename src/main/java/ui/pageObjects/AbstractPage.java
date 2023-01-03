package ui.pageObjects;

import org.openqa.selenium.WebDriver;
import utilClasses.WebDriverWaitContainer;

public class AbstractPage {
    private final WebDriver driver;
    private final WebDriverWaitContainer webDriverWaitContainer;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWaitContainer = new WebDriverWaitContainer(this.driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWaitContainer getWebDriverWaitContainer() {
        return webDriverWaitContainer;
    }

}
