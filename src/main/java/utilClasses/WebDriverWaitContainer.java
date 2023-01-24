package utilClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitContainer {

    private final WebDriverWait wait;

    private final int waitTime = 2_000;

    public WebDriverWaitContainer(WebDriver driver) {
        this.wait = new WebDriverWait(driver, this.waitTime);
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
