package com.solvd.gsmarena.services;

import com.solvd.gsmarena.HomePage;
import org.openqa.selenium.WebDriver;

public interface ISearchService {

    default HomePage search(WebDriver driver, String search) {
        HomePage homePage = new HomePage(driver);
        homePage.search(search);
        return homePage;
    }
}
