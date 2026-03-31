package org.example.tests;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Класс автотеста

public class QuestionsAndAnswersTest {
    private WebDriver driver;

    @Test
    public void testQuestionsAndAnswers() {
        // Инициализация драйвера Chrome
        driver = new ChromeDriver();
        // Переход на тестируемый сайт
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // Создание объекта главной страницы с передачей драйвера
        org.example.MainPage objMainPage = new org.example.MainPage(driver);

        // Нажатие на кнопку "да все привыкли"
        objMainPage.clickCookieButton();

        // Прокликивание всех вопросов и вывод пар "вопрос-ответ" в консоль
        System.out.println("ВОПРОС-ОТВЕТ:");
        for (int i = 0; i < 8; i++) {
            // Кликаем на вопрос, чтобы открыть ответ
            objMainPage.clickQuestionButton(i);
            // Ждём прогрузки ответа
            objMainPage.waitForAnswer(i);

            // Получаем текст вопроса и ответа
            String actualQuestionText = objMainPage.getQuestionText(i);
            String actualAnswerText = objMainPage.getAnswerText(i);

            // Выводим пару "вопрос-ответ" в виде сообщения для наглядности
            System.out.println("Вопрос №" + (i + 1) + ": " + actualQuestionText);
            System.out.println("Ответ №" + (i + 1) + ": " + actualAnswerText);
            System.out.println("---");
        }

        // Сравнение всех вопросов и ответов, сохранение результата (true/false)
        boolean result = objMainPage.compareQuestionsAndAnswers();
        String message;

        // Определение итогового сообщения на основе результата сравнения
        if (result) {
            message = "Все совпадает";
        } else {
            message = "Есть несоответствия";
        }

        // Вывод итогового результата проверки в консоль
        System.out.println("Результаты проверки: " + message);
    }

    @After
    public void tearDown() {
        // Метод для завершения работы с драйвером
        if (driver != null) {
            driver.quit();
        }
    }
}