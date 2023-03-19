package com.shaft.screens;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.shaft.gui.element.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LocationScreen {
    private final By egyptButton = By.xpath("(//*[@text='Egypt'])");
    private final By permissionButton = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    private final By confirmLocationButton = By.xpath("(//android.widget.TextView[@text='CONFIRM LOCATION'])");
    AndroidDriver driver;
   // private final SHAFT.GUI.WebDriver shaftDriver;

    public LocationScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public HomeScreen confirmYourLocation() {

       new TouchActions().tap(egyptButton).performElementAction();

        new TouchActions(driver)
                .tap(permissionButton)
                .tap(confirmLocationButton).performElementAction();

        return new HomeScreen(driver);
    }
}
