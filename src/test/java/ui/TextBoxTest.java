package ui;

import enums.BrowserName;
import org.junit.jupiter.api.*;
import ui.pageObjects.MainPage;
import utilClasses.ConfigContainer;
import utilClasses.WebDriverContainer;

public class TextBoxTest {

    private MainPage mainPage;

    @BeforeEach
    public void beforeEach() {
        mainPage = new MainPage(WebDriverContainer.getCustomizedDriver(BrowserName.CHROME));
        mainPage.getDriver().get(new ConfigContainer().getProperty("BASE_URI_FOR_UI_TESTS"));
    }

    @Test
    public void positiveTest() {
        String[] fixture = {"Autotest Autotestov Autotestovich", "autotest@hotmail.com",
                "Mexico-city, Martinez street", "New-York city, Bevenue street"};
        mainPage.clickOnElementsButton()
                .clickOnTextBox()
                .fillFullNameInput(fixture[0])
                .fillEmailInput(fixture[1])
                .fillCurrentAddressInput(fixture[2])
                .fillPermanentAddressInput(fixture[3])
                .clickOnSubmitButton();

        Assertions.assertTrue(mainPage.getTextFromOutputName().contains(fixture[0]));
        Assertions.assertTrue(mainPage.getTextFromOutputEmail().contains(fixture[1]));
        Assertions.assertTrue(mainPage.getTextFromOutputCurrentAddress().contains(fixture[2]));
        Assertions.assertTrue(mainPage.getTextFromOutputPermanentAddress().contains(fixture[3]));
    }

    @AfterEach
    public void afterEach() {
        mainPage.getDriver().quit();
    }

}
