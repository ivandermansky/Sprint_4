package org.example.tests;

import org.example.MainPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class UpperOrderButtonTest extends org.example.tests.BaseTest {
    private MainPage mainPage;

    @Override
    @Before
    public void setUp() {
        super.setUp(); // Вызов setUp из BaseTest для инициализации драйвера и перехода на сайт
        mainPage = new MainPage(driver); // Создать объект главной страницы после инициализации драйвера
    }

    @Test
    public void errorOrderTest() {
        // Нажатие на верхнюю кнопку "ЗАКАЗАТЬ"
        mainPage.clickUpperOrderButton();

        // Проверка: после нажатия кнопки должна появиться форма заказа
        Assert.assertTrue(
                "Форма заказа не появилась после нажатия верхней кнопки 'ЗАКАЗАТЬ'",
                mainPage.isOrderFormVisible()
        );
    }
}


