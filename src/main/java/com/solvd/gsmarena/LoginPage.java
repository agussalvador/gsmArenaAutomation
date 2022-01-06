package com.solvd.gsmarena;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//h3[text()='Login successful.']")
    private ExtendedWebElement loginSuccessfulMessage;

    @FindBy(xpath = "//h3[text()='Login failed.']")
    private ExtendedWebElement loginFailedMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        open();
    }

    public void switchToLoginWindow(String tabTitle) {
        var windows = driver.getWindowHandles();

        for (String window : windows) {
            driver.switchTo().window(window);

            if (tabTitle.equals(driver.getTitle())) {
                break;
            }
        }
    }

    public String getLoginSuccessfulMessage() {
        return loginSuccessfulMessage.getText();
    }

    public String getLoginFailedMessage() {
        return loginFailedMessage.getText();
    }
}
