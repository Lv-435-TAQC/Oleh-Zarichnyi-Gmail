package pageObject;

import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.MenuLocators;

public class MenuPage extends BasedPageObject {
    private Button createLetterButton;
    private Button incomingLettersButton;
    private Button sendLettersButton;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public SendMessagePage clickCreateLetterButton() {
        WebDriverWait wait = new WebDriverWait(driver, 150);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MenuLocators.CREATE_NEW_LETTER_BUTTON_LOC)));
        createLetterButton = new Button(this.driver, MenuLocators.CREATE_NEW_LETTER_BUTTON_LOC);
        createLetterButton.click();
        return new SendMessagePage(this.driver);
    }

    public MainPage clickIncomingLettersButton() {
        WebDriverWait wait = new WebDriverWait(driver, 150);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MenuLocators.INCOMING_LETTER_BUTTON_LOC)));
        incomingLettersButton = new Button(this.driver, MenuLocators.INCOMING_LETTER_BUTTON_LOC);
        incomingLettersButton.click();
        return new MainPage(this.driver);
    }
    public MainPage clickSendLettersButton() {
        WebDriverWait wait = new WebDriverWait(driver, 150);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MenuLocators.SEND_LETTERS_BUTTON_LOC)));
        sendLettersButton = new Button(this.driver, MenuLocators.SEND_LETTERS_BUTTON_LOC);
        sendLettersButton.click();

        return new MainPage(this.driver);
    }
}
