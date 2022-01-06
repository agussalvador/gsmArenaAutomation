package com.solvd.gsmarena.tests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.gsmarena.HomePage;
import com.solvd.gsmarena.services.ILoginService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginTests implements IAbstractTest, ILoginService {

    @Test
    public void ValidateSuccessfulLogin() {
        HomePage homePage = successfulLogin(getDriver());
        assertTrue(homePage.getLogoutButton(), "FATAL! not same");
    }

    @Test
    public void ValidateInvalidEmailPwdCombination() {
        HomePage homePage = invalidCredentialsLogin(getDriver());
        assertFalse(homePage.getLogoutButton(), "FATAL! not same");
    }

    @Test
    public void ValidateEmptyEmail() {
        HomePage homePage = emptyEmailLogin(getDriver());
        assertFalse(homePage.getLogoutButton(), "FATAL! not same");
    }

    @Test
    public void ValidateEmptyPassword() {
        HomePage homePage = emptyPasswordLogin(getDriver());
        assertFalse(homePage.getLogoutButton(), "FATAL! not same");
    }
}
