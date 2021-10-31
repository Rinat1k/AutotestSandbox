package org.passwordGenerator;

import helpers.ConfigContainer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Task1 {
    static WebDriver driver;
    @Test
    void executeTask1()
    {
        //1. Установка конфигураций автотеста
        ConfigContainer configContainer = new ConfigContainer();
        System.setProperty("webdriver.chrome.driver", configContainer.getProperty("pathToChromiumDriver"));
        driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 15);

        //2. Открытие страницы
        driver.get(configContainer.getProperty("passwordGeneratorURL"));

        //3. Генерация паролей и проверка не неравенство null
        webDriverWait.until(
                ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(),\"Генерировать пароль\")]"))))
                .click();
        String firstGeneratedPassword = driver.findElement(By.xpath("//input[@id=\"final_pass\"]")).getAttribute("value");
        Assertions.assertNotEquals(firstGeneratedPassword, null);

        webDriverWait.until(
                ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(),\"Генерировать пароль\")]"))))
                .click();
        String secondGeneratedPassword = driver.findElement(By.xpath("//input[@id=\"final_pass\"]")).getAttribute("value");
        driver.findElement(By.xpath("//div[contains(text(),\"Генерировать пароль\")]")).click();
        Assertions.assertNotEquals(secondGeneratedPassword, null);

        //4. Проверка на несовпадение сгенерированных паролей
        Assertions.assertNotSame(firstGeneratedPassword, secondGeneratedPassword,
                "Сгенерированные пароли совпадают");

        //5. Выключение символов в сгенерированном пароле
        webDriverWait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("//input[@id=\"Symbols\"]"))))
                .click();

        int lengthPasswordValue = 10;

        //6. Установка значения длины символов в пароле и проверка на соответствие длины
        Select dropdownLengthPassword = new Select(driver.findElement(By.xpath("//select[@id=\"pgLength\"]")));
        dropdownLengthPassword.selectByValue(Integer.toString(lengthPasswordValue));

        driver.findElement(By.xpath("//div[contains(text(),\"Генерировать пароль\")]")).click();
        String thirdGeneratedPassword = driver.findElement(By.xpath("//input[@id=\"final_pass\"]")).getAttribute("value");
        Assertions.assertEquals(lengthPasswordValue, thirdGeneratedPassword.length(),
                "Длина не совпадает с введённой");

    }

    @AfterAll
    static void afterAll() {
        driver.quit();
    }

}
