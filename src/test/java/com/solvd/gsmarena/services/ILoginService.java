package com.solvd.gsmarena.services;

import com.solvd.gsmarena.HomePage;
import org.openqa.selenium.WebDriver;

public interface ILoginService {

    default HomePage successfulLogin(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        homePage.setLoginEmailField("agustinsalvador1@gmail.com");
        homePage.setLoginPasswordFieldField("123456");
        homePage.clickLoginSubmitButton();
        return homePage;
    }

    default HomePage invalidCredentialsLogin(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        homePage.setLoginEmailField("agustinsalvador1@gmail.com");
        homePage.setLoginPasswordFieldField("9999999");
        homePage.clickLoginSubmitButton();
        return homePage;
    }

    default HomePage emptyEmailLogin(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        homePage.setLoginPasswordFieldField("9999999");
        homePage.clickLoginSubmitButton();
        return homePage;
    }

    default HomePage emptyPasswordLogin(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        homePage.setLoginEmailField("agustinsalvador1@gmail.com");
        homePage.clickLoginSubmitButton();
        return homePage;
    }


}
