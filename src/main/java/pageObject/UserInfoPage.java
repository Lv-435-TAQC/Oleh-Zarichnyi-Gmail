package pageObject;

import elements.Button;
import locators.MenuLocators;
import locators.UserInfoLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserInfoPage extends BasedPageObject {
    private Button logOutButton;

    public UserInfoPage(WebDriver driver) {
        super(driver);
    }

    public UserInfoPage clickLogOutButton() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(UserInfoLocators.LOG_OUT_BUTTON_LOC)));
        logOutButton = new Button(this.driver, UserInfoLocators.LOG_OUT_BUTTON_LOC);
        logOutButton.click();
        return this;
    }

}
