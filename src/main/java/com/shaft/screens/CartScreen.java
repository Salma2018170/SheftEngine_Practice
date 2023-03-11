package com.shaft.screens;

import com.shaft.gui.element.TouchActions;
import io.appium.java_client.android.AndroidDriver;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;

public class CartScreen {
    AndroidDriver driver;
    private final By checkOutButton= By.xpath("(//android.widget.TextView[@text='CHECKOUT'])");
    public CartScreen(AndroidDriver driver){
        this.driver=driver;
    }
    public LoginScreen checkOut(){
        new TouchActions().tap(checkOutButton).performElementAction();
       return new LoginScreen(driver);
    }
}
