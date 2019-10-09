package pageObject;

import org.openqa.selenium.WebDriver;

public abstract class BasedPageObject {
    protected WebDriver driver;

    public BasedPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public LogInPage goToLoginPage() {
        driver.get("https://accounts.google.com/servicelogin");
        return new LogInPage(driver);
    }

    public MainPage goToMainPage() {
        driver.get("https://mail.google.com");
        return new MainPage(driver);
    }
}
