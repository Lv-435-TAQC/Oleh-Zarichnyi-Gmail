package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.LoginPage;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;


public class Run {
    private String url = "https://mail.google.com";

    public void start() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LoginPage logIn = new LoginPage(driver);
//        logIn
//                .goToLoginPage()
//                .logIn("oleh.zarichnyi", "lhgfeilhgfei")
//                .sendNewLetter("oleh.zarichnyi@gmail.com"
//                        , "Test Message"
//                        , LocalDateTime.now().toString());
        logIn
                .goToLoginPage()
                .logIn("oleh.zarichnyi", "lhgfeilhgfei")
                .filterLetters("oleh.zarichnyi@gmail.com"
                        , "oleh.zarichnyi@gmail.com"
                        , "Test Message");
    }

}
