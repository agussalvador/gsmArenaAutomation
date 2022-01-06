package com.solvd.gsmarena;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends AbstractPage {

    @FindBy(xpath = "//a[@class='login-icon']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//h1[text()='Sign Up']")
    private ExtendedWebElement welcomeMessage;

    @FindBy(xpath = "//div[@id='user-submit']//input[@name='sNickname']")
    private ExtendedWebElement nicknameField;

    @FindBy(xpath = "//div[@id='user-submit']//input[@name='sEmail']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//div[@id='user-submit']//input[@name='sPassword']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//label[@for='iagree1']")
    private ExtendedWebElement storeDataCheckbox;

    @FindBy(xpath = "//label[@for='iagree2']")
    private ExtendedWebElement ageCheckbox;

    @FindBy(xpath = "//div[@id='ucsubmit-f']//input[@id='nick-submit']")
    private ExtendedWebElement submitSignUpButton;

    @FindBy(xpath = "//input[@disabled='disabled']")
    private ExtendedWebElement disableSubmitButton;

    @FindBy(xpath = "//h3[text()='Your account was created. ']")
    private ExtendedWebElement signUpMessageSuccessful;

    @FindBy(xpath = "//p[contains(text(),'Reason: You need to provide valid email.')]")
    private ExtendedWebElement invalidEmailMessage;

    @FindBy(xpath = "//p[text()='Reason: Your nickname should have between 2 and 20 symbols.']")
    private ExtendedWebElement invalidNicknameMessage;

    @FindBy(xpath = "//span[@id='login-popup2']//input[@name='sEmail']")
    private ExtendedWebElement loginEmailField;

    @FindBy(xpath = "//span[@id='login-popup2']//input[@name='sPassword']")
    private ExtendedWebElement loginPasswordField;

    @FindBy(xpath = "//span[@id='login-popup2']//input[@id='nick-submit']")
    private ExtendedWebElement loginSubmitButton;


    public SignUpPage(WebDriver driver) {
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

    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }

    public void setNicknameField(String nickname) {
        nicknameField.type(nickname);
    }

    public void setEmailField(String email) {
        emailField.type(email);
    }

    public void setPasswordField(String password) {
        passwordField.type(password);
    }

    public void clickStoreDateCheckbox() {
        storeDataCheckbox.click();
    }

    public void clickAgeCheckbox() {
        ageCheckbox.click();
    }

    public void clickSubmitButton() {
        submitSignUpButton.click();
    }

    public String getDisabledSubmitButton() {
        return disableSubmitButton.getAttribute("disabled");
    }

    public String getSignUpSuccessfulMessage() {
        return signUpMessageSuccessful.getText();
    }

    public String getInvalidEmailMessage() {
        return invalidEmailMessage.getText();
    }

    public String getInvalidNicknameMessage() {
        return invalidNicknameMessage.getText();
    }
}
