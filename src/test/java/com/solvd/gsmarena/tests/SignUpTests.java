package com.solvd.gsmarena.tests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.gsmarena.SignUpPage;
import com.solvd.gsmarena.services.ISignUpPageService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SignUpTests implements IAbstractTest, ISignUpPageService {

    @Test
    public void VerifyWelcomeMessage() {
        SignUpPage signUpPage = signUpFill(getDriver());
        assertEquals(signUpPage.getSignUpSuccessfulMessage(), "Your account was created.", "FATAL! not same");
    }

    @Test
    public void VerifyInvalidEmail() {
        SignUpPage signUpPage = invalidEmailSignUp(getDriver());
        assertTrue(signUpPage.getInvalidEmailMessage().contains("Reason: You need to provide valid email."), "FATAL! not same");
    }

    @Test
    public void ValidateEmptyName() {
        SignUpPage signUpPage = emptyNicknameSignUp(getDriver());
        assertEquals(signUpPage.getInvalidNicknameMessage(), "Reason: Your nickname should have between 2 and 20 symbols.", "FATAL! not same");
    }

    @Test
    public void ValidateEmptyEmail() {
        SignUpPage signUpPage = emptyEmailSignUp(getDriver());
        assertEquals(signUpPage.getDisabledSubmitButton(), "true", "FATAL! not same");
    }

    @Test
    public void ValidateRequiredConditions() {
        SignUpPage signUpPage = emptyCheckboxSignUp(getDriver());
        assertEquals(signUpPage.getDisabledSubmitButton(), "true", "FATAL! not same");
    }

}
