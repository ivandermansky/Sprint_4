package org.example.tests;

import org.example.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpperOrderButtonTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void errorOrderTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");


        // Создание объекта главной страницы с передачей драйвера
        MainPage objMainPage = new MainPage(driver);

        // Нажатие на верхнюю кнопку "ЗАКАЗАТЬ"
        objMainPage.clickUpperOrderButton();

    }

    @After
    public void tearDown(){
        driver.quit();

    }
}