package com.solvd.gsmarena.services;

import com.solvd.gsmarena.HomePage;
import com.solvd.gsmarena.SignUpPage;
import org.openqa.selenium.WebDriver;

public interface ISignUpPageService {

    default SignUpPage gotoSignUpPage(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = homePage.clickSignUpButton();
        homePage.switchToWindow("Create account");
        return new SignUpPage(driver);
    }

    default SignUpPage signUpFill(WebDriver driver) {
        SignUpPage signUpPage = gotoSignUpPage(driver);
        signUpPage.setNicknameField("Name1923j9jehguh");
        signUpPage.setEmailField("Emai1234l@email.com");
        signUpPage.setPasswordField("pwd123");
        signUpPage.clickStoreDateCheckbox();
        signUpPage.clickAgeCheckbox();
        signUpPage.clickSubmitButton();
        return signUpPage;
    }

    default SignUpPage invalidEmailSignUp(WebDriver driver) {
        SignUpPage signUpPage = gotoSignUpPage(driver);
        signUpPage.setNicknameField("Name1923j9je23duhguh");
        signUpPage.setEmailField("Emai1234l@email");
        signUpPage.setPasswordField("pwd1239");
        signUpPage.clickStoreDateCheckbox();
        signUpPage.clickAgeCheckbox();
        signUpPage.clickSubmitButton();
        return signUpPage;
    }

    default SignUpPage emptyNicknameSignUp(WebDriver driver) {
        SignUpPage signUpPage = gotoSignUpPage(driver);
        signUpPage.setEmailField("Emai1knjn234l@email.com");
        signUpPage.setPasswordField("pwd123");
        signUpPage.clickStoreDateCheckbox();
        signUpPage.clickAgeCheckbox();
        signUpPage.clickSubmitButton();
        return signUpPage;
    }

    default SignUpPage emptyEmailSignUp(WebDriver driver) {
        SignUpPage signUpPage = gotoSignUpPage(driver);
        signUpPage.setNicknameField("Name1asd923j9je23duhguh");
        signUpPage.setPasswordField("pwd123");
        signUpPage.clickStoreDateCheckbox();
        signUpPage.clickAgeCheckbox();
        return signUpPage;
    }

    default SignUpPage emptyCheckboxSignUp(WebDriver driver) {
        SignUpPage signUpPage = gotoSignUpPage(driver);
        signUpPage.setNicknameField("Name1923j9jehguh");
        signUpPage.setEmailField("Emai1234l@email.com");
        signUpPage.setPasswordField("pwd123");
        return signUpPage;
    }
}
