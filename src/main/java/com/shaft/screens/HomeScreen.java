package com.shaft.screens;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import com.shaft.gui.element.TouchActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeScreen {
    // private SHAFT.GUI.WebDriver shaftDriver;
    //
    By searchForCategory = By.xpath("(//android.widget.TextView[@text='Beauty picks'])");
    By startElement = By.xpath("(//android.widget.TextView[@text='Sponsored'])");
    private final AndroidDriver driver;

    public HomeScreen(AndroidDriver driver) {
        this.driver = driver;
        //  shaftDriver=new SHAFT.GUI.WebDriver();
    }
    public void searchText(String targetText){
         driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(false))" +
                        ".scrollIntoView(new UiSelector().textContains(\""+targetText+"\"))"));
    }

    public ViewItemDetailsScreen searchForItemsSection() {
          driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains(\"Farino\"))"));
       WebElement webElement= driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList()" +
                        ".scrollIntoView(new UiSelector().textContains(\"Mienta Uno\"))"));
       webElement.click();
        return new ViewItemDetailsScreen(driver);
    }
//    public ViewItemDetailsScreen searchForSpecificItem(){
//       driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList()" +
//                        ".scrollIntoView(new UiSelector().textContains(\"Ubisoft\"))"));
//        return new ViewItemDetailsScreen(driver);
//    }
}
