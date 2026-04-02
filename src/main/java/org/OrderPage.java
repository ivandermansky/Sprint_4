package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class OrderPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Локаторы элементов на главной странице, чтобы перейти на страницу заказа
    private By cookieButton = By.className("App_CookieButton__3cvqF");
    private By lowerOrderButton = By.xpath("//button[contains(@class, 'Button_Button') and contains(text(), 'Заказать')]");

    // Локаторы элементов для страницы заказа
    private By nameField = By.xpath("//input[contains(@class, 'Input_Input') and @placeholder='* Имя']");
    private By surnameField = By.xpath("//input[contains(@class, 'Input_Input') and @placeholder='* Фамилия']");
    private By addressField = By.xpath("//input[contains(@class, 'Input_Input') and @placeholder='* Адрес: куда привезти заказ']");
    private By metroStation = By.xpath("//input[contains(@class, 'select-search__input') and @placeholder='* Станция метро']");
    private By phoneNumberField = By.xpath("//input[contains(@class, 'Input_Input') and @placeholder='* Телефон: на него позвонит курьер']");
    private By buttonNext = By.xpath("//button[contains(@class, 'Button_Button') and contains(text(), 'Далее')]");
    private By dateOfDelivery = By.xpath("//input[contains(@class, 'Input_Input') and @placeholder='* Когда привезти самокат']");
    private By aprilFourth = By.xpath("//div[contains(@aria-label, 'суббота, 4-е апреля 2026 г.') and . = '4']");
    private By rentalPeriod = By.xpath("//div[contains(@class, 'Dropdown-placeholder') and contains(text(), '* Срок аренды')]");
    private By oneDayRental = By.xpath("//div[contains(@class, 'Dropdown-option') and contains(text(), 'сутки')]");
    private By blackPearl = By.xpath("//label[contains(@class, 'Checkbox_Label') and contains(text(), 'чёрный жемчуг')]");
    private By greyDespair = By.id("grey");
    private By commentForCourierField = By.cssSelector("input.Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='Комментарий для курьера']");

    //private By orderButton = By.xpath("//button[@class='Button_Button_ra12g Button_Middle_1CSJM' and text()='Заказать']");
    //private By orderButton = By.cssSelector(".Order_Buttons_1xGrp > button.Button_Button_ra12g.Button_Middle_1CSJM:not(.Button_Inverted_3IF)");
    //private By orderButton = By.cssSelector(".Order_Buttons_1xGrp > button.Button_Middle_1CSJM");
    //private By orderButton = By.xpath("//button[contains(@class, 'Button_Button_ra12g Button_Middle_1CSJM') and contains(text(), 'Заказать')]");
    // Локаторы выше для кнопки orderButton не работают. Я всё перепробовал
    private By orderButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");

    private By confirmationQuestion = By.xpath("//*[contains(text(), 'Хотите оформить заказ?']");
    private By yesButton = By.xpath("//button[contains(@class, 'Button_Button') and contains(text(), 'Да')]");
    private By orderIsConfirmedText = By.xpath("//*[contains(text(), 'Заказ оформлен']");
    private By checkStatusButton = By.xpath("//button[contains(@class, 'Button_Button') and contains(text(), 'Посмотреть статус')]");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void clickCookieButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(cookieButton));
        element.click();
    }

    public void scrollAndClickLowerOrderButton() {
        // Найти кнопку
        WebElement button = driver.findElement(lowerOrderButton);

        // Прокрутка страницы до кнопки
        ((JavascriptExecutor) driver).executeScript(
                ("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});"), button);

        WebElement clickableLowerOrderButton = wait.until(ExpectedConditions.elementToBeClickable(lowerOrderButton));
        clickableLowerOrderButton.click();
    }

    public void sendName(String name) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(nameField));
        element.clear();
        element.click();
        element.sendKeys(name);
    }

    public void sendSurname(String surname) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(surnameField));
        element.clear();
        element.click();
        element.sendKeys(surname);
    }

    public void sendAddress(String address) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addressField));
        element.clear();
        element.click();
        element.sendKeys(address);
    }

    public void clickAndSelectMetroStationList(String metro) {
        // Клик по полю ввода станции метро
        WebElement metroElement = wait.until(ExpectedConditions.elementToBeClickable(metroStation));
        metroElement.click();

        // Очистка поля и ввод названия станции
        metroElement.clear();
        metroElement.sendKeys(metro);

        // Имитация нажатия клавиш: стрелка "вниз" для прокрутки списка и Enter для подтверждения выбора
        metroElement.sendKeys(Keys.ARROW_DOWN);
        metroElement.sendKeys(Keys.ENTER);
    }

    public void sendPhoneNumber(String phoneNumber) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(phoneNumberField));
        element.clear();
        element.sendKeys(phoneNumber);
    }

    public void clickButtonNext() {
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(buttonNext));
        nextButton.click();
    }

    public void clickDateOfDeliveryButton() {
        WebElement dateOfDeliveryButton = wait.until(ExpectedConditions.elementToBeClickable(dateOfDelivery));
        dateOfDeliveryButton.click();
    }

    public void clickFourthOfAprilButton(){
        WebElement FourOfAprilButton = wait.until(ExpectedConditions.elementToBeClickable(aprilFourth));
        FourOfAprilButton.click();
    }

    public void clickRentalDateButton(){
        WebElement RentalDateButton = wait.until(ExpectedConditions.elementToBeClickable(rentalPeriod));
        RentalDateButton.click();
    }

    public void clickOneDayRentalButton(){
        WebElement OneDayRentalButton = wait.until(ExpectedConditions.elementToBeClickable(oneDayRental));
        OneDayRentalButton.click();
    }

    public void clickBlackPearlButton(){
        WebElement BlackPearlButton = wait.until(ExpectedConditions.elementToBeClickable(blackPearl));
        BlackPearlButton.click();
    }

    public void clickGreyDespairButton(){
        WebElement GreyDespairButton = wait.until(ExpectedConditions.elementToBeClickable(greyDespair));
        GreyDespairButton.click();
    }

    public void clickCommentForCourierField(){
        WebElement CommentForCourierButton = wait.until(ExpectedConditions.elementToBeClickable(commentForCourierField));
        CommentForCourierButton.click();
    }

    public void leaveCommentForCourier(String comment){
        WebElement CommentForCourier = wait.until(ExpectedConditions.elementToBeClickable(commentForCourierField));
        CommentForCourier.clear();
        CommentForCourier.sendKeys(comment);
    }

    public void clickOrderButton() {
        WebElement OrderButton = wait.until(ExpectedConditions.elementToBeClickable(orderButton));
        OrderButton.click();
    }

    public void confirmationQuestionCheck(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(
                confirmationQuestion));
    }

    public void clickYesButton(){
        WebElement YesButton = wait.until(ExpectedConditions.elementToBeClickable(yesButton));
        YesButton.click();
    }

    public void clickCheckStatusButton(){
        WebElement CheckStatusButton = wait.until(ExpectedConditions.elementToBeClickable(checkStatusButton));
        CheckStatusButton.click();
    }

    public void assertOrderIsConfirmed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(
                orderIsConfirmedText)
        );
        String text = element.getText();
        assertEquals("Текст должен начинаться с 'Заказ оформлен'",
                true,
                text.startsWith("Заказ оформлен"));
    }

    // Объединение методов
    public void checkOrderPageAllSteps(String name, String surname, String address, String metro, String phoneNumber, String comment){
        clickCookieButton();
        scrollAndClickLowerOrderButton();
        sendName(name);
        sendSurname(surname);
        sendAddress(address);
        clickAndSelectMetroStationList(metro);
        sendPhoneNumber(phoneNumber);
        clickButtonNext();
        clickDateOfDeliveryButton();
        clickFourthOfAprilButton();
        clickRentalDateButton();
        clickOneDayRentalButton();
        clickBlackPearlButton();
        clickGreyDespairButton();
        clickCommentForCourierField();
        leaveCommentForCourier(comment);
        clickOrderButton();
        confirmationQuestionCheck();
        clickYesButton();
        clickCheckStatusButton();
        assertOrderIsConfirmed();
    }
}
