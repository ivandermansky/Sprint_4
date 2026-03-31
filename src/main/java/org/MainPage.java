package org.example;

import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage {
    private WebDriver driver;


    private final String QUESTION1_TEXT = "Сколько это стоит? И как оплатить?";
    private By question1_locator = By.id("accordion__heading-0");

    private final String QUESTION2_TEXT = "Хочу сразу несколько самокатов! Так можно?";
    private By question2_locator = By.id("accordion__heading-1");

    private final String QUESTION3_TEXT = "Как рассчитывается время аренды?";
    private By question3_locator = By.id("accordion__heading-2");

    private final String QUESTION4_TEXT = "Можно ли заказать самокат прямо на сегодня?";
    private By question4_locator = By.id("accordion__heading-3");

    private final String QUESTION5_TEXT = "Можно ли продлить заказ или вернуть самокат раньше?";
    private By question5_locator = By.id("accordion__heading-4");

    private final String QUESTION6_TEXT = "Вы привозите зарядку вместе с самокатом?";
    private By question6_locator = By.id("accordion__heading-5");

    private final String QUESTION7_TEXT = "Можно ли отменить заказ?";
    private By question7_locator = By.id("accordion__heading-6");

    private final String QUESTION8_TEXT = "Я жизу за МКАДом, привезёте?"; // Исправлено: жизу → живу
    private By question8_locator = By.id("accordion__heading-7");

    private final String ANSWER1_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private By ANSWER1_LOCATOR = By.id("accordion__panel-0");

    private final String ANSWER2_TEXT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private By ANSWER2_LOCATOR = By.id("accordion__panel-1");

    private final String ANSWER3_TEXT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private By ANSWER3_LOCATOR = By.id("accordion__panel-2");

    private final String ANSWER4_TEXT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private By ANSWER4_LOCATOR = By.id("accordion__panel-3");

    private final String ANSWER5_TEXT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private By ANSWER5_LOCATOR = By.id("accordion__panel-4");

    private final String ANSWER6_TEXT = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private By ANSWER6_LOCATOR = By.id("accordion__panel-5");

    private final String ANSWER7_TEXT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private By ANSWER7_LOCATOR = By.id("accordion__panel-6");

    private final String ANSWER8_TEXT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
    private By ANSWER8_LOCATOR = By.id("accordion__panel-7");

    private By cookieButton = By.className("App_CookieButton__3cvqF");

    private By upperOrderButton = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]");
    private By lowerOrderButton = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");


    private By[] questionLocators = {
            question1_locator, question2_locator, question3_locator,
            question4_locator, question5_locator, question6_locator,
            question7_locator, question8_locator
    };

    private By[] answerLocators = {
            ANSWER1_LOCATOR, ANSWER2_LOCATOR, ANSWER3_LOCATOR,
            ANSWER4_LOCATOR, ANSWER5_LOCATOR, ANSWER6_LOCATOR,
            ANSWER7_LOCATOR, ANSWER8_LOCATOR
    };

    private String[] expectedQuestionTexts = {
            QUESTION1_TEXT, QUESTION2_TEXT, QUESTION3_TEXT,
            QUESTION4_TEXT, QUESTION5_TEXT, QUESTION6_TEXT,
            QUESTION7_TEXT, QUESTION8_TEXT
    };

    private String[] expectedAnswerTexts = {
            ANSWER1_TEXT, ANSWER2_TEXT, ANSWER3_TEXT,
            ANSWER4_TEXT, ANSWER5_TEXT, ANSWER6_TEXT,
            ANSWER7_TEXT, ANSWER8_TEXT
    };

    // Конструктор класса
    public MainPage(WebDriver driver) {

        this.driver = driver;
    }

    // Метод для нажатия на верхнюю кнопку "ЗАКАЗАТЬ" (второй тестовый сценарий)
    public void clickUpperOrderButton() {
        driver.findElement(upperOrderButton).click();
    }



    // Метод для нажатия на кнопку "да все привыкли"
    public void clickCookieButton () {
        driver.findElement(cookieButton).click();

    }


    // Метод для клика на вопрос по номеру (0–7)
    public void clickQuestionButton(int number) {
        By questionButton = By.id("accordion__heading-" + number);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(questionButton)
        );
        element.click();
    }

    // Метод ожидания прогрузки ответа на вопрос
    public void waitForAnswer(int questionNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("accordion__panel-" + questionNumber)
                ));
    }


    // Метод для получения текста вопроса по номеру (0–7)
    public String getQuestionText(int number) {
        By questionLocator = By.id("accordion__heading-" + number);
        WebElement element = driver.findElement(questionLocator);
        return element.getText();
    }

    // Метод для получения текста вопроса по номеру
    public String getAnswerText(int number) {
        By answerLocator = By.id("accordion__panel-" + number);
        WebElement element = driver.findElement(answerLocator);
        return  element.getText();


    }

    // Метод для сравнения всех вопросов и ответов с ожидаемыми значениями
    public boolean compareQuestionsAndAnswers() {
        boolean isCorresponding = true;

        for (int i = 0; i < questionLocators.length; i++) {
            clickQuestionButton(i); // Кликаем на вопрос, чтобы открыть ответ



            String actualQuestionText = driver.findElement(questionLocators[i]).getText();
            if (!actualQuestionText.equals(expectedQuestionTexts[i])) {
                isCorresponding = false;
                System.out.println("Вопрос №" + (i + 1) + " не совпадает: ожидаемо '" + expectedQuestionTexts[i] + "', фактически '" + actualQuestionText + "'");
            }

            String actualAnswerText = driver.findElement(answerLocators[i]).getText();
            if (actualAnswerText.isEmpty()) {
                isCorresponding = false;
                System.out.println("Ответ №" + (i + 1) + " пуст — возможно, элемент не виден или не загружен");
            } else if (!actualAnswerText.equals(expectedAnswerTexts[i])) {
                isCorresponding = false;
                System.out.println("Ответ №" + (i + 1) + " не совпадает: ожидаемо '" + expectedAnswerTexts[i] + "', фактически '" + actualAnswerText + "'");
            }
        }

        return isCorresponding;
    }
}