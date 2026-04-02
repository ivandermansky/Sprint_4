package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Переменные для текста вопросов-ответов сделаны статичными
    // Все переменные переименованы

    private static final String QUESTION_PRICE_TEXT = "Сколько это стоит? И как оплатить?";
    private static final String QUESTION_QUANTITY_TEXT = "Хочу сразу несколько самокатов! Так можно?";
    private static final String QUESTION_RENTALTIME_TEXT = "Как рассчитывается время аренды?";
    private static final String QUESTION_TODAYRENTAL_TEXT = "Можно ли заказать самокат прямо на сегодня?";
    private static final String QUESTION_EARLIERLATER_TEXT = "Можно ли продлить заказ или вернуть самокат раньше?";
    private static final String QUESTION_CHARGER_TEXT = "Вы привозите зарядку вместе с самокатом?";
    private static final String QUESTION_CANCEL_TEXT = "Можно ли отменить заказ?";
    private static final String QUESTION_MKAD_TEXT = "Я жизу за МКАДом, привезёте?";

    private static final String ANSWER_PRICE_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private static final String ANSWER_QUANTITY_TEXT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private static final String ANSWER_RENTALTIME_TEXT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private static final String ANSWER_TODAYRENTAL_TEXT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private static final String ANSWER_EARLIERAFTER_TEXT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private static final String ANSWER_CHARGER_TEXT = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private static final String ANSWER_CANCEL_TEXT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private static final String ANSWER_MKAD_TEXT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    // Локаторы элементов
    private By cookieButton = By.className("App_CookieButton__3cvqF");
    private By upperOrderButton = By.xpath(".//button[@class='Button_Button__ra12g' and (text() = 'Заказать')]");
    private By orderFormText = By.xpath("//*[contains(text(), 'Для кого самокат')]"); // Локатор для текста "Для кого самокат"

    private static String[] expectedQuestionTexts = {
            QUESTION_PRICE_TEXT, QUESTION_QUANTITY_TEXT, QUESTION_RENTALTIME_TEXT,
            QUESTION_TODAYRENTAL_TEXT, QUESTION_EARLIERLATER_TEXT, QUESTION_CHARGER_TEXT,
            QUESTION_CANCEL_TEXT, QUESTION_MKAD_TEXT
    };

    private static String[] expectedAnswerTexts = {
            ANSWER_PRICE_TEXT, ANSWER_QUANTITY_TEXT, ANSWER_RENTALTIME_TEXT,
            ANSWER_TODAYRENTAL_TEXT, ANSWER_EARLIERAFTER_TEXT, ANSWER_CHARGER_TEXT,
            ANSWER_CANCEL_TEXT, ANSWER_MKAD_TEXT
    };

    // Конструктор класса
    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    // Метод для нажатия на верхнюю кнопку "ЗАКАЗАТЬ"
    public void clickUpperOrderButton() {
        driver.findElement(upperOrderButton).click();
    }

    // Метод для проверки появления текста "Для кого самокат" после нажатия кнопки
    public boolean isOrderFormVisible() {
        WebElement element = driver.findElement(orderFormText);
        return element.isDisplayed();
    }

    // Метод для нажатия на кнопку "да все привыкли"
    public void clickCookieButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(cookieButton));
        element.click();
    }

    // Метод для клика на вопрос по номеру (0–7)
    public void clickQuestionButton(int number) {
        By questionButton = By.id("accordion__heading-" + number);
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(questionButton)
        );
        element.click();
    }

    // Метод ожидания прогрузки ответа на вопрос
    public void waitForAnswer(int questionNumber) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("accordion__panel-" + questionNumber)
        ));
    }

    // Метод для получения текста вопроса по номеру (0–7)
    public String getQuestionText(int number) {
        By questionLocator = By.id("accordion__heading-" + number);
        WebElement element = driver.findElement(questionLocator);
        return element.getText();
    }

    // Метод для получения текста ответа по номеру (0–7)
    public String getAnswerText(int number) {
        By answerLocator = By.id("accordion__panel-" + number);
        WebElement element = driver.findElement(answerLocator);
        return element.getText();
    }

    // Статический метод для предоставления тестовых данных параметризованному тесту
    // Возвращает коллекцию массивов: [вопрос, ответ, номер]
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][] {
                {expectedQuestionTexts[0], expectedAnswerTexts[0], 0},
                {expectedQuestionTexts[1], expectedAnswerTexts[1], 1},
                {expectedQuestionTexts[2], expectedAnswerTexts[2], 2},
                {expectedQuestionTexts[3], expectedAnswerTexts[3], 3},
                {expectedQuestionTexts[4], expectedAnswerTexts[4], 4},
                {expectedQuestionTexts[5], expectedAnswerTexts[5], 5},
                {expectedQuestionTexts[6], expectedAnswerTexts[6], 6},
                {expectedQuestionTexts[7], expectedAnswerTexts[7], 7}
        });
    }

    // Метод для проверки одного вопроса и ответа по номеру
    boolean checkSingleQuestionAndAnswer(int number, String expectedQuestion, String expectedAnswer) {
        // Кликнуть на вопрос, чтобы открыть ответ
        clickQuestionButton(number);
        // Ждать прогрузки ответа
        waitForAnswer(number);

        // Получить текст вопроса и ответа
        String actualQuestionText = getQuestionText(number);
        String actualAnswerText = getAnswerText(number);

        // Проверить соответствие
        boolean isQuestionMatch = actualQuestionText.equals(expectedQuestion);
        boolean isAnswerMatch = actualAnswerText.equals(expectedAnswer);

        if (!isQuestionMatch) {
            System.out.println("Вопрос №" + (number + 1) + " не совпадает: ожидаемо '" + expectedQuestion + "', фактически '" + actualQuestionText + "'");
        }

        if (!isAnswerMatch) {
            System.out.println("Ответ №" + (number + 1) + " не совпадает: ожидаемо '" + expectedAnswer + "', фактически '" + actualAnswerText + "'");
        }

        // Вернуть true, только если и вопрос, и ответ совпадают
        return isQuestionMatch && isAnswerMatch;
        
    }
}
