package pageObject;

import elements.Button;
import elements.ErrorMessage;
import elements.InsertField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.LoginLocators;


public class LogInPage extends BasedPageObject {
    private InsertField loginField;
    private InsertField passwordField;
    private Button nextButt;
    private ErrorMessage loginError;
    private ErrorMessage passError;

    public LogInPage(WebDriver driver) {
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

    public LogInPage setLogInField(String loginName) {
        loginField = new InsertField(this.driver, LoginLocators.LOGIN_FIELD_LOC);
        loginField.setTextForField(loginName);
        return this;
    }

    public LogInPage clickNextButton() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginLocators.LOGIN_NEXT_BUTTON_LOC)));
        nextButt = new Button(this.driver, LoginLocators.LOGIN_NEXT_BUTTON_LOC);
        nextButt.click();
        return this;
    }

    public LogInPage setPasswordField(String password) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginLocators.PASS_FIELD_LOC)));
        passwordField = new InsertField(this.driver, LoginLocators.PASS_FIELD_LOC);
        passwordField.setTextForField(password);
        return this;
    }
    public String getLoginErrorMessage(){
        loginError = new ErrorMessage(this.driver);
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginLocators.LOGIN_ERROR_LABEL_LOC)));
        return loginError.getText(LoginLocators.LOGIN_ERROR_LABEL_LOC);
    }
    public String getPassErrorMessage(){
        passError = new ErrorMessage(this.driver);
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginLocators.PASSWORD_ERROR_LABEL_LOC)));
        return passError.getText(LoginLocators.PASSWORD_ERROR_LABEL_LOC);
    }
}
