package org.example.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

// Класс автотеста
@RunWith(Parameterized.class)
public class QuestionsAndAnswersTest extends org.example.tests.BaseTest {
    private org.example.MainPage mainPage;

    // Поля для параметризованных данных
    private final String expectedQuestion;
    private final String expectedAnswer;
    private final int questionNumber; // номер вопроса для клика

    // Конструктор для получения параметров
    public QuestionsAndAnswersTest(String expectedQuestion, String expectedAnswer, int questionNumber) {
        this.expectedQuestion = expectedQuestion;
        this.expectedAnswer = expectedAnswer;
        this.questionNumber = questionNumber;
    }

    @Override
    @Before
    public void setUp() {
        super.setUp(); // Вызов setUp из BaseTest для инициализации драйвера и перехода на сайт
        mainPage = new org.example.MainPage(driver);
        // Нажатие на кнопку "да все привыкли"
        mainPage.clickCookieButton();
    }

    // Параметры для теста. Данные берутся из MainPage
    @Parameterized.Parameters
    public static Collection<Object[]> getQaA() {
        return org.example.MainPage.getTestData();
    }

    @Test
    public void testSingleQuestionAndAnswer() {
        // Кликнуть на вопрос, чтобы открыть ответ
        mainPage.clickQuestionButton(questionNumber);
        // Ждать прогрузки ответа
        mainPage.waitForAnswer(questionNumber);

        // Получить текст вопроса и ответа
        String actualQuestionText = mainPage.getQuestionText(questionNumber);
        String actualAnswerText = mainPage.getAnswerText(questionNumber);

        // Вывести пару "вопрос-ответ" в виде сообщения для наглядности
        System.out.println("Вопрос №" + (questionNumber + 1) + ": " + actualQuestionText);
        System.out.println("Ответ №" + (questionNumber + 1) + ": " + actualAnswerText);
        System.out.println("---");

        // Сравнить с ожидаемыми значениями
        assertEquals("Вопрос не совпадает", expectedQuestion, actualQuestionText);
        assertEquals("Ответ не совпадает", expectedAnswer, actualAnswerText);
    }
}


