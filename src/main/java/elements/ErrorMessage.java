package elements;

import org.openqa.selenium.WebDriver;
import pageObject.BasedPageObject;

public class ErrorMessage extends BasedPageObject {
    Label label;
    public ErrorMessage(WebDriver driver) {
        super(driver);
    }
    public String getText(String xpath){
        label = new Label(driver, xpath);
        return label.getText();
    }
}
