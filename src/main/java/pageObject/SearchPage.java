package pageObject;

import elements.Button;
import elements.InsertField;
import locators.SearchLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasedPageObject {

    private Button filterSettingsButton;
    private Button searchButton;
    private Button userInfoButton;
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

    public MainPage clickUserInfoButton() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SearchLocators.USER_INFO_BUTTON_LOC)));
        userInfoButton = new Button(this.driver, SearchLocators.USER_INFO_BUTTON_LOC);
        userInfoButton.click();
        return new MainPage(this.driver);
    }


}
