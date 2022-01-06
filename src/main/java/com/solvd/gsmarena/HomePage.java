package com.solvd.gsmarena;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {


    @FindBy(xpath = "//a[@class='login-icon']")
    private ExtendedWebElement getLoginButton;

    @FindBy(xpath = "//a[@class='signup-icon no-margin-right']")
    private ExtendedWebElement getSignUpButton;

    @FindBy(xpath = "//input[@id='topsearch-text']")
    private ExtendedWebElement getSearch;

    @FindBy(xpath = "//div[@class='article-hgroup']")
    private ExtendedWebElement searchResultTitle;

    @FindBy(xpath = "//span[@id='login-popup2']//input[@name='sEmail']")
    private ExtendedWebElement loginEmailField;

    @FindBy(xpath = "//span[@id='login-popup2']//input[@name='sPassword']")
    private ExtendedWebElement loginPasswordField;

    @FindBy(xpath = "//span[@id='login-popup2']//input[@id='nick-submit']")
    private ExtendedWebElement loginSubmitButton;

    @FindBy(xpath = "//a[@class='signup-icon no-margin-right']//span[text()='Log out']")
    private ExtendedWebElement logoutButton;

    public HomePage(WebDriver driver) {
        super(driver);
        open();
    }

    public void switchToWindow(String tabTitle) {
        var windows = driver.getWindowHandles();

        for (String window : windows) {
            driver.switchTo().window(window);

            if (tabTitle.equals(driver.getTitle())) {
                break;
            }
        }
    }

    public SignUpPage clickSignUpButton() {
        getSignUpButton.click();
        return new SignUpPage(driver);
    }

    public void clickLoginButton() {
        getLoginButton.click();
    }

    public void setLoginEmailField(String email) {
        loginEmailField.type(email);
    }

    public void setLoginPasswordFieldField(String password) {
        loginPasswordField.type(password);
    }

    public void clickLoginSubmitButton() {
        loginSubmitButton.click();
    }

    public Boolean getLogoutButton() {
        return logoutButton.isElementPresent();
    }

    public void search(String search) {
        getSearch.type(search);
        getSearch.sendKeys(Keys.ENTER);
    }

    public String getSearchResultTitle() {
        return searchResultTitle.getText();
    }
}

