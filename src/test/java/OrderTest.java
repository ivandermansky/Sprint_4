package org.example.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class OrderTest extends org.example.tests.BaseTest {
    private org.example.OrderPage orderPage;

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phoneNumber;
    private final String comment;

    // Конструктор для получения тестовых данных
    public OrderTest(String name, String surname, String address, String metro, String phoneNumber, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Collection<Object[]> provideTestData() {
        return Arrays.asList(new Object[][] {
                // Первый набор тестовых данных
                {"Иван", "Иванов", "Ленина 10", "Лубянка", "88888888888", "Пожалуйста, побыстрее"},
                // Второй набор тестовых данных
                {"Анна", "Петрова", "Северная 22", "Чистые Пруды", "77777777777", "Сегодня привезёте?"}
        });
    }

    @Override
    @Before
    public void setUp() {
        super.setUp(); // вызываем setUp из BaseTest
        orderPage = new org.example.OrderPage(driver);
    }

    @Test
    public void checkOrderScenario() {
        // Вызов метода, объединяющего в себе все шаги заказа
        orderPage.checkOrderPageAllSteps(name, surname, address, metro, phoneNumber, comment);
    }
}
