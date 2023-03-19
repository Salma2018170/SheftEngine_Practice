package com.shaft.screens;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.TouchActions;
import io.appium.java_client.android.AndroidDriver;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginScreen {
    AndroidDriver driver;
    private SHAFT.GUI.WebDriver shaftDriver;
    private final By emailField = By.xpath("//android.widget.EditText[@resource-id='email']");
    //Element Path
    private final By passwordField = By.xpath("//android.widget.EditText[@resource-id='password']");
    private final By loginButton = By.xpath("//android.widget.TextView[@text='Sign In']");
    LoginScreen(AndroidDriver driver){
        this.driver=driver;
    }
    public void setEmail(String email) {
        new TouchActions().performElementAction().typeAppend(emailField,email);
//        WebElement emailElement = driver.findElement(emailField);
//        emailElement.clear();
//        emailElement.sendKeys(email);

    }

    public void setPassword(String password) {
        new TouchActions().performElementAction().typeAppend(passwordField,password);



    }
    public PaymentScreen clickSigInButton() {
        new TouchActions().tap(loginButton).performElementAction();
        return new PaymentScreen(driver);
    }
}
