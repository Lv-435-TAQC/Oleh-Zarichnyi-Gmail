package pageObject;

import elements.Button;
import elements.InsertField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.FilterLocators;

public class FilterPage extends BasedPageObject {
    private InsertField senderEmailFilterField;
    private InsertField recipientEmailFilterField;
    private InsertField themeOfEmailFilterField;
    private Button searchByFilterButton;

    public FilterPage(WebDriver driver) {
        super(driver);
    }

    public FilterPage setSenderEmailFilterField(String sender) {
        WebDriverWait wait = new WebDriverWait(driver, 150);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FilterLocators.SENDER_EMAIL_FILTER_FIELD_LOC)));
        senderEmailFilterField = new InsertField(this.driver, FilterLocators.SENDER_EMAIL_FILTER_FIELD_LOC);
        senderEmailFilterField.setTextForField(sender);
        return this;
    }

    public FilterPage setRecipientEmailFilterField(String recipient) {
        recipientEmailFilterField = new InsertField(this.driver, FilterLocators.RECIPIENT_EMAIL_FILTER_FIELD_LOC);
        recipientEmailFilterField.setTextForField(recipient);
        return this;
    }

    public FilterPage setThemeOfEmailFilterField(String theme) {
        themeOfEmailFilterField = new InsertField(this.driver, FilterLocators.THEME_OF_LETTER_FILTER_FIELD_LOC);
        themeOfEmailFilterField.setTextForField(theme);
        return this;
    }

    public MainPage pressSearchByFilterButton() {
        searchByFilterButton = new Button(this.driver, FilterLocators.SEARCH_BY_FILTER_BUTTON_LOC);
        searchByFilterButton.click();
        return new MainPage(this.driver);
    }
}
