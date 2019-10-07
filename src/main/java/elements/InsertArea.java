package elements;

import org.openqa.selenium.WebDriver;

public class InsertArea extends BasedElement {
    public InsertArea(WebDriver driver, String xpath) {
        super(driver, xpath);
    }

    public InsertArea setTextForArea(String text) {
        this.element.sendKeys(text);
        return this;
    }
    public InsertArea click(){
        this.element.click();
        return this;
    }
}
