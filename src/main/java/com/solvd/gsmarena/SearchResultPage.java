package com.solvd.gsmarena;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends AbstractPage {
    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void switchToSignUpWindow(String tabTitle) {
        var windows = driver.getWindowHandles();

        for (String window : windows) {
            driver.switchTo().window(window);

            if (tabTitle.equals(driver.getTitle())) {
                break;
            }
        }
    }
}
