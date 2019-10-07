package pageObject;

import elements.Button;
import elements.InsertField;
import locators.SearchLocators;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasedPageObject {

    private Button filterSettingsButton;
    private Button searchButton;
    private InsertField searchField;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public FilterPage clickFilterSettingsButton() {
        filterSettingsButton = new Button(this.driver, SearchLocators.FILTER_SETTINGS_BUTTON_LOC);
        filterSettingsButton.click();
        return new FilterPage(this.driver);
    }

    public MainPage clickSearchButton() {
        searchButton = new Button(this.driver, SearchLocators.SEARCH_BUTTON_LOC);
        searchButton.click();
        return new MainPage(this.driver);
    }

    public MainPage setTextForSearch(String text) {
        searchField = new InsertField(this.driver, SearchLocators.SEARCH_FIELD_LOC);
        searchField.setTextForField(text);
        return new MainPage(this.driver);
    }


}
