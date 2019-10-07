package elements;

import org.openqa.selenium.WebDriver;

public class Label extends BasedElement {
    public Label(WebDriver driver, String xpath) {
        super(driver, xpath);
    }

    public String getText() {
        return this.element.getText();
    }
}
