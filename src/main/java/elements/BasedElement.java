package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

abstract public class BasedElement {
    protected WebDriver driver;
    protected WebElement element;
    protected String xpath;

    public BasedElement(WebDriver driver, String xpath) {
        this.driver = driver;
        this.xpath = xpath;
        element = driver.findElement(By.xpath(xpath));
    }

}
