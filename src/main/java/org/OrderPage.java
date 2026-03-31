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
    private By lowerOrderButton = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");
    private By cookieButton = By.className("App_CookieButton__3cvqF");

    // Локаторы элементов для страницы заказа

    private By name_field = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    private By surname_field = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    private By address_field = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    private By metro_station = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div/input");
    private By phone_number_field = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    private By button_next = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");
    private By date_of_delivery = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div/input");
    private By april4 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[6]/div[6]");
    private By rental_period = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[1]");
    private By one_day_rental = By.xpath ("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]");

    private By black_pearl = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/label[1]");
    private By grey_despair_lol = By.xpath("//*[@id=\"grey\"]");
    private By comment_for_courier_field = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");
    private By order_button = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");
    private By yes_button = By.xpath("//button[contains(text(), 'Да')]");
    private By check_status_button = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(name_field));
        element.clear();
        element.click();
        element.sendKeys(name);
    }

    public void sendSurname(String surname) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(surname_field));
        element.clear();
        element.click();
        element.sendKeys(surname);
    }

    public void sendAddress(String address) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(address_field));
        element.click();
        element.clear();
        element.sendKeys(address);
    }

    public void clickAndSelectMetroStationList(String metro) {
        // Клик по полю ввода станции метро
        WebElement metroElement = wait.until(ExpectedConditions.elementToBeClickable(metro_station));
        metroElement.click();

        // Очистка поля и ввод названия станции
        metroElement.clear();
        metroElement.sendKeys(metro);



        // Имитация нажатия клавиш: стрелка "вниз" для прокрутки списка и Enter для подтверждения выбора
        metroElement.sendKeys(Keys.ARROW_DOWN);
        metroElement.sendKeys(Keys.ENTER);
    }
    public void sendPhoneNumber(String phoneNumber) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(phone_number_field));
        element.clear();
        element.sendKeys(phoneNumber);
    }

    public void clickButtonNext() {
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(button_next));
        nextButton.click();    }

    public void clickDateOfDeliveryButton() {
        WebElement dateOfDeliveryButton = wait.until(ExpectedConditions.elementToBeClickable(date_of_delivery));
        dateOfDeliveryButton.click();

    }


    public void clickFourOfAprilButton(){
        WebElement FourOfAprilButton = wait.until(ExpectedConditions.elementToBeClickable(april4));
        FourOfAprilButton.click();
    }



    public void clickRentalDateButton(){
        WebElement RentalDateButton = wait.until(ExpectedConditions.elementToBeClickable(rental_period));
        RentalDateButton.click();
    }

    public void clickOneDayRentalButton(){
        WebElement OneDayRentalButton = wait.until(ExpectedConditions.elementToBeClickable(one_day_rental));
        OneDayRentalButton.click();
    }

    public void clickBlackPearlButton(){
        WebElement BlackPearlButton = wait.until(ExpectedConditions.elementToBeClickable(black_pearl));
        BlackPearlButton.click();
    }
    public void clickGreyDespairButton(){
        WebElement GreyDespairButton = wait.until(ExpectedConditions.elementToBeClickable(grey_despair_lol));
        GreyDespairButton.click();
    }



    public void clickCommentForCourierField(){
        WebElement CommentForCourierButton = wait.until(ExpectedConditions.elementToBeClickable(comment_for_courier_field));
        CommentForCourierButton.click();

    }

    public void leaveCommentForCourier(String comment){
        WebElement CommentForCourier = wait.until(ExpectedConditions.elementToBeClickable(comment_for_courier_field));
        CommentForCourier.clear();
        CommentForCourier.sendKeys(comment);
    }

    public void clickOrderButton() {
        WebElement OrderButton = wait.until(ExpectedConditions.elementToBeClickable(order_button));

        OrderButton.click();
    }


    public void clickYesButton(){
        WebElement YesButton = wait.until(ExpectedConditions.elementToBeClickable(yes_button));
        YesButton.click();
    }


    public void clickCheckStatusButton(){
        WebElement CheckStatusButton = wait.until(ExpectedConditions.elementToBeClickable(check_status_button));
        CheckStatusButton.click();
    }


    public void assertOrderIsConfirmed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[contains(text(), 'Заказ оформлен')]")
        ));
        String text = element.getText();
        assertEquals("Текст должен начинаться с 'Заказ оформлен'",
                true,
                text.startsWith("Заказ оформлен"));
    }

}