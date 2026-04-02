package org.example.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


 //Базовый класс для всех тестов — содержит общую логику запуска браузера и закрытия браузера

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
        // Инициализация драйвера
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

