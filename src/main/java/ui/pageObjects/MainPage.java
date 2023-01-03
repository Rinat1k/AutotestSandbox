package ui.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends AbstractPage {

    // region [Submit block]
    private final static String ELEMENTS_BUTTON_XPATH =
            "//span[@class='group-header']/div[contains(text(), 'Elements')] | //h5[text()='Elements']";
    private final static String TEXT_BOX_BUTTON_XPATH =
            "//span[text()='Text Box']";
    private final static String FULL_NAME_INPUT_CSS = "#userName";
    private final static String EMAIL_INPUT_CSS = "#userEmail";
    private final static String CURRENT_ADDRESS_INPUT_CSS = "#currentAddress";
    private final static String PERMANENT_ADDRESS_INPUT_CSS = "#permanentAddress";
    private final static String SUBMIT_BUTTON_CSS = "#submit";
    //endregion
    //region [Output block]
    private final static String OUTPUT_NAME_XPATH = "//div[@id='output']//*[@id='name']";
    private final static String OUTPUT_EMAIL_XPATH = "//div[@id='output']//*[@id='email']";
    private final static String OUTPUT_CURRENT_ADDRESS_XPATH = "//div[@id='output']//*[@id='currentAddress']";
    private final static String OUTPUT_PERMANENT_ADDRESS_XPATH = "//div[@id='output']//*[@id='permanentAddress']";
    //endregion

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage clickOnElementsButton() {
        getWebDriverWaitContainer().getWait()
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ELEMENTS_BUTTON_XPATH)))
                .click();
        return this;
    }

    public MainPage clickOnTextBox() {
        getWebDriverWaitContainer().getWait()
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TEXT_BOX_BUTTON_XPATH)))
                .click();
        return this;
    }

    public MainPage clickOnSubmitButton() {
        getWebDriverWaitContainer().getWait()
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SUBMIT_BUTTON_CSS)))
                .click();
        return this;
    }

    public MainPage fillFullNameInput(String value) {
        getWebDriverWaitContainer().getWait()
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(FULL_NAME_INPUT_CSS)))
                .sendKeys(value);
        return this;
    }

    public MainPage fillEmailInput(String value) {
        getWebDriverWaitContainer().getWait()
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(EMAIL_INPUT_CSS)))
                .sendKeys(value);
        return this;
    }

    public MainPage fillCurrentAddressInput(String value) {
        getWebDriverWaitContainer().getWait()
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CURRENT_ADDRESS_INPUT_CSS)))
                .sendKeys(value);
        return this;
    }

    public MainPage fillPermanentAddressInput(String value) {
        getWebDriverWaitContainer().getWait()
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PERMANENT_ADDRESS_INPUT_CSS)))
                .sendKeys(value);
        return this;
    }

    public String getTextFromOutputName() {
        return getWebDriverWaitContainer().getWait()
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OUTPUT_NAME_XPATH)))
                .getText();
    }

    public String getTextFromOutputEmail() {
        return getWebDriverWaitContainer().getWait()
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OUTPUT_EMAIL_XPATH)))
                .getText();
    }

    public String getTextFromOutputCurrentAddress() {
        return getWebDriverWaitContainer().getWait()
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OUTPUT_CURRENT_ADDRESS_XPATH)))
                .getText();
    }

    public String getTextFromOutputPermanentAddress() {
        return getWebDriverWaitContainer().getWait()
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OUTPUT_PERMANENT_ADDRESS_XPATH)))
                .getText();
    }
}
