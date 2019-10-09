package pageObject;

import locators.SendMessageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasedPageObject {
    private MenuPage menuPage;
    private SearchPage searchPage;
    private LettersPage lettersPage;
    private UserInfoPage userInfoPage;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage sendNewLetter(String recipient, String theme, String message) {
        menuPage = new MenuPage(this.driver);
        menuPage
                .clickCreateLetterButton()
                .setRecipientEmail(recipient)
                .setThemeOfEmail(theme)
                .setLetterMessage(message)
                .clickSendButton();
        WebDriverWait wait = new WebDriverWait(driver, 150);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SendMessageLocators.SENDING_CHECK_LOC)));
        wait.until(ExpectedConditions.textToBe(By.xpath(SendMessageLocators.SENDING_CHECK_LOC), "Лист надіслано."));
        this.goToMainPage();
        return this;
    }

    public MainPage filterLetters(String sender, String recipient, String theme) {
        searchPage = new SearchPage(this.driver);
        searchPage
                .clickFilterSettingsButton()
                .setSenderEmailFilterField(sender)
                .setRecipientEmailFilterField(recipient)
                .setThemeOfEmailFilterField(theme)
                .pressSearchByFilterButton();
        return this;
    }
    public MainPage logOut(){
        searchPage = new SearchPage(this.driver);
        userInfoPage = new UserInfoPage(this.driver);
        searchPage
                .clickUserInfoButton();
        userInfoPage
                .clickLogOutButton();

        return this;
    }
}
