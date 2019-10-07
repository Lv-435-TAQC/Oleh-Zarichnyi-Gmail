package pageObject;

import elements.Button;
import elements.InsertArea;
import elements.InsertField;
import elements.Label;
import locators.SendMessageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendMessagePage extends BasedPageObject {
    private InsertField recipientEmailField;
    private InsertField themeOfEmailField;
    private InsertArea textOfEmailArea;
    private Button sendMessageButton;
    private Label themeLabel;

    public SendMessagePage(WebDriver driver) {
        super(driver);
    }

    public SendMessagePage setRecipientEmail(String recipient) {
        WebDriverWait wait = new WebDriverWait(driver, 150);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SendMessageLocators.RECIPIENT_EMAIL_FIELD_LOC)));
        recipientEmailField = new InsertField(this.driver, SendMessageLocators.RECIPIENT_EMAIL_FIELD_LOC);
        recipientEmailField.setTextForField(recipient);
        return this;
    }

    public SendMessagePage setThemeOfEmail(String theme) {
        themeOfEmailField = new InsertField(this.driver, SendMessageLocators.THEME_NEW_LETTER_FIELD_LOC);
        themeOfEmailField.setTextForField(theme);
        return this;
    }

    public SendMessagePage setLetterMessage(String letter) {
        textOfEmailArea = new InsertArea(this.driver, SendMessageLocators.TEXT_AREA_NEW_LETTER_FIELD_LOC);
        textOfEmailArea.setTextForArea(letter);
        return this;
    }

    public MainPage clickSendButton() {
        WebDriverWait wait = new WebDriverWait(driver, 150);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SendMessageLocators.SEND_MESSAGE_BUTTON_LOC)));
        sendMessageButton = new Button(this.driver, SendMessageLocators.SEND_MESSAGE_BUTTON_LOC);
        waitForSave();
        sendMessageButton.click();
        return new MainPage(this.driver);
    }

    public SendMessagePage waitForSave() {
        themeOfEmailField.click();
        textOfEmailArea.click();
        WebDriverWait wait = new WebDriverWait(driver, 150);
        wait.until(ExpectedConditions.textToBe(By.xpath(SendMessageLocators.THEME_LABEL_LOC),"Чернетку збережено"));
        return this;
    }
}
