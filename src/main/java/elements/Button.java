package elements;

import org.openqa.selenium.WebDriver;

public class Button extends BasedElement {

    public Button(WebDriver driver, String xpath) {
        super(driver, xpath);
    }

    public Button click() {
        this.element.click();
        return this;
    }
}
