package com.shaft.screens;

import com.shaft.gui.element.TouchActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ViewItemDetailsScreen {
    AndroidDriver driver;
    //Element
    private final By cartButton=By.xpath("//android.widget.TextView[@text='ADD TO CART']");
    private final By viewCartButton=By.xpath("//android.widget.TextView[@text='VIEW CART']");
    public ViewItemDetailsScreen(AndroidDriver driver){
        this.driver=driver;
    }
    public void readItemDetails(){
        //view items details
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains(\"VIEW MORE\"))")).click();
//        new TouchActions().swipeElementIntoView("VIEW MORE");
//        driver.findElement(AppiumBy.androidUIAutomator
//                ("new UiScrollable(new UiSelector().scrollable(true))" +
//                        ".scrollIntoView(new UiSelector().textContains(\"More from Fresh\"))"));
    }
    public CartScreen addItemToCart( )
    {
        new TouchActions().tap(cartButton).performElementAction();
        new TouchActions().tap(viewCartButton).performElementAction();
//
        return new CartScreen(driver);
    }
}
