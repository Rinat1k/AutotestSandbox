package org.homework;

import helpers.ConfigContainer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Task3 {
    static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;
    static JavascriptExecutor jsExecutor;
    static ConfigContainer configContainer;

    //1. Установка конфигураций автотеста
    @BeforeAll
    static void beforeAll() {
        configContainer = new ConfigContainer();
        System.setProperty("webdriver.opera.driver", configContainer.getProperty("pathToOperaDriver"));

        driver = new OperaDriver();
        wait = new WebDriverWait(driver, 20);
        actions = new Actions(driver);
    }

    @Test
    void executeTask3() {
        //2. Открытие страницы
        driver.get(configContainer.getProperty("dnsSiteURL"));

        //3. Наведение на раздел меню "Комьютеры" и выбор "Материнские платы" в разделе "Комплектующие для ПК"
        actions.moveToElement(
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),\"Компьютеры\")]"))
                )
        ).perform();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),\"Материнские платы\")]"))
        ).click();

        //4. Счёт количества записей на странице
        int sizeProductElementsAtPage = getSizeProductElementsAtCatalogPage();
        System.out.println("Количество элементов " + sizeProductElementsAtPage);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"products-list-pagination\"]//button"))
        ).click();

        //5. Проверка увеличения количества записей в 2 раза после нажатия на кнопку "Показать ещё"
        wait.until(
                ExpectedConditions.numberOfElementsToBe(
                        By.xpath("//div[@data-id=\"product\"]"), sizeProductElementsAtPage * 2)
        );

        //6. Генерация случайного числа [1..10]
        int rndmDigit = getRandomDigit(1, 10);

        //7. Скролл в начало страницы и добавление [%rndmDigit] товаров в корзину
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");

        for (int i = 0; i < rndmDigit; i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@data-id=\"product\"]//button[text()=\"Купить\"]")
            )).click();
        }

        //8 Нажатие на кнопку "Корзина"
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"cart-link__icon\"]/.."))
        ).click();

        //9. Сравнить количество записей в корзине с добавленным
        var productSizeAtCart = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=\"cart-items__product\"]"))
        ).size();
        Assertions.assertEquals(rndmDigit, productSizeAtCart, "Количество добавленных товаров не совпадает" +
                "с количеством товаров в корзине");

    }

    private static int getSizeProductElementsAtCatalogPage() {
        return wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@data-id=\"product\"]"))
        ).size();
    }

    private int getRandomDigit(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private void sleep(int time) {
        try {
            Thread.sleep((long)time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    static void afterAll() {
        driver.quit();
    }
}
