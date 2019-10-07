package elements;

import org.openqa.selenium.WebDriver;

public class InsertField extends BasedElement {
    public InsertField(WebDriver driver, String xpath) {
        super(driver, xpath);
    }

    public InsertField setTextForField(String text) {
        this.element.sendKeys(text);
        return this;
    }

    public String getText() {
        return this.element.getText();
    }
    public InsertField click(){
        this.element.click();
        return this;
    }
}
