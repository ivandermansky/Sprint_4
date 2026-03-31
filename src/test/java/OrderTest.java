package org.example.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver driver;
    private org.example.OrderPage orderPage;


    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String comment;

    // Конструктор для получения тестовых данных
    public OrderTest(String name, String surname, String address, String metroStation, String phoneNumber, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> provideTestData() {
        return Arrays.asList(new Object[][] {
                // Первый набор тестовых данных
                {"Иван", "Иванов", "Ленина 10", "Лубянка", "88888888888", "Пожалуйста, побыстрее"},
                // Второй набор тестовых данных
                {"Анна", "Петрова", "Северная 22", "Чистые Пруды", "77777777777", "Сегодня привезёте?"}
        });
    }

    @Before
    public void setUp() {
        // Инициализация драйвера
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // Создание экземпляра OrderPage
        orderPage = new org.example.OrderPage(driver);
    }

    @Test
    public void checkOrderScenario() {
        // Выполнение шагов с использованием тестовых данных
        orderPage.clickCookieButton();
        orderPage.scrollAndClickLowerOrderButton();
        orderPage.sendName(name);
        orderPage.sendSurname(surname);
        orderPage.sendAddress(address);
        orderPage.clickAndSelectMetroStationList(metroStation);
        orderPage.sendPhoneNumber(phoneNumber);
        orderPage.clickButtonNext();
        orderPage.clickDateOfDeliveryButton();
        orderPage.clickFourOfAprilButton();
        orderPage.clickRentalDateButton();
        orderPage.clickOneDayRentalButton();
        orderPage.clickBlackPearlButton();
        orderPage.clickGreyDespairButton();
        orderPage.leaveCommentForCourier(comment);
        orderPage.clickOrderButton();
        orderPage.clickYesButton();
        orderPage.assertOrderIsConfirmed();
        orderPage.clickCheckStatusButton();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}