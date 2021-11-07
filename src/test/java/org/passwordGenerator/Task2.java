package org.passwordGenerator;

import helpers.ConfigContainer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Task2 {
    static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;

    @Test
    void executeTask2() {

        //1. Установка конфигураций автотеста
        ConfigContainer configContainer = new ConfigContainer();
        System.setProperty("webdriver.chrome.driver", configContainer.getProperty("pathToChromiumDriver"));

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        actions = new Actions(driver);

        //2. Открытие страницы
        driver.get(configContainer.getProperty("2017makeMePulseURL"));

        //3. Нажатие на лого в верхней части сайта
        String prevTab = driver.getWindowHandle();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"logo\"]\n"))).click();

        //4. Переход на предыдущую вкладку
        driver.switchTo().window(prevTab);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        //5. Делаем лого невидимым
        jsExecutor.executeScript("document.getElementsByClassName('logo')[0].setAttribute('style', 'display:none')");

        //6. Переход на следующий уровень
        goToNextLevel();

        //7. Перемещение лампы влево и вправо
        WebElement glCanvas = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#gl-canvas"))
        );
        actions.dragAndDropBy(glCanvas,-50,0).dragAndDropBy(glCanvas,150,0)
                .perform();

        //8. Переход на следующий уровень
        goToNextLevel();

        //9. Нажатие на фотоаппарат
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#gl-canvas"))).click();

        //9. Переход на следующий уровень
        goToNextLevel();

        //10. Зажатие ЛКМ на 7 секунд
        clickAndHoldOnElementWithDelay(By.cssSelector("#gl-canvas"),7);

        //11. Переход на следующий уровень
        goToNextLevel();

        //12. Перевод курсора в любое место
        glCanvas = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#gl-canvas"))
        );
        actions.dragAndDropBy(glCanvas,-50,0)
                .perform();

        //13. Переход на следующий уровень
        goToNextLevel();

        //14. Зажатие ЛКМ на 2 секунд
        clickAndHoldOnElementWithDelay(By.cssSelector("#gl-canvas"),2);

        //15. Переход на следующий уровень
        goToNextLevel();

        //16. Закрытие окна
        driver.close();

    }

    void goToNextLevel() {
        WebElement draggerCursor = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".dragger-cursor"))
        );
        actions.dragAndDropBy(draggerCursor,250,0)
                .perform();
    }

    void clickAndHoldOnElementWithDelay(By by, int time) {
        try {
            actions.clickAndHold(wait.until(ExpectedConditions.visibilityOfElementLocated(by)))
                    .build()
                    .perform();
            Thread.sleep(time);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    static void afterAll() {
       driver.quit();
    }
}
