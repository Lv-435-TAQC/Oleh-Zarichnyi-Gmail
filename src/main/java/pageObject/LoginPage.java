package pageObject;

import elements.Button;
import elements.InsertField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.LoginLocators;


public class LoginPage extends BasedPageObject {
    private InsertField loginField;
    private InsertField passwordField;
    private Button nextButt;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MainPage logIn(String loginName, String password) {
        this
                .setLogInField(loginName)
                .clickNextButton()
                .setPasswordField(password)
                .clickNextButton()
                .goToMainPage();
        return new MainPage(this.driver);
    }

    public LoginPage setLogInField(String loginName) {
        loginField = new InsertField(this.driver, LoginLocators.LOGIN_FIELD_LOC);
        loginField.setTextForField(loginName);
        return this;
    }

    public LoginPage clickNextButton() {
        nextButt = new Button(this.driver, LoginLocators.LOGIN_NEXT_BUTTON_LOC);
        nextButt.click();
        return this;
    }

    public LoginPage setPasswordField(String password) {
        WebDriverWait wait = new WebDriverWait(driver, 150);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginLocators.PASS_FIELD_LOC)));
        passwordField = new InsertField(this.driver, LoginLocators.PASS_FIELD_LOC);
        passwordField.setTextForField(password);
        return this;
    }
}
