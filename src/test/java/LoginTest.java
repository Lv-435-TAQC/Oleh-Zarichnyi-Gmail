import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.LogInPage;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private WebDriver driver;
    private LogInPage loginPage;


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LogInPage(driver);
    }

    @BeforeMethod
    public void beforeTest() {
        loginPage.goToLoginPage();
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void validLogInTest() throws InterruptedException {
        loginPage.setLogInField("oleh.zarichnyi")
                .clickNextButton()
                .setPasswordField("lhgfeilhgfei")
                .clickNextButton()
                .goToMainPage();
        String expected = driver.getCurrentUrl();
        driver.close();
        beforeClass();
        Assert.assertEquals("https://mail.google.com/mail/u/0/#inbox", expected);
    }

    @Test
    public void zeroUserNameTest() {
        loginPage
                .clickNextButton();
        Assert.assertEquals("Введите адрес электронной почты или номер телефона."
                , loginPage.getLoginErrorMessage());
    }

    @Test
    public void notValidUserNameTest() {
        loginPage
                .setLogInField("asfgsdwqe")
                .clickNextButton();
        Assert.assertEquals("Не удалось найти аккаунт Google"
                , loginPage.getLoginErrorMessage());

    }

    @Test
    public void zeroPasswordTest() throws InterruptedException {
        loginPage
                .setLogInField("oleh.zarichnyi")
                .clickNextButton();
        Thread.sleep(1000);
        loginPage
                .clickNextButton();
        Assert.assertEquals("Введите пароль", loginPage.getPassErrorMessage());
    }

    @Test
    public void notValidPasswordTest() {
        loginPage
                .setLogInField("oleh.zarichnyi")
                .clickNextButton()
                .setPasswordField("lhasfasf")
                .clickNextButton();
        Assert.assertEquals("Неверный пароль. Повторите попытку или нажмите на ссылку \"Забыли пароль?\", чтобы сбросить его."
                , loginPage.getPassErrorMessage());
    }
}
