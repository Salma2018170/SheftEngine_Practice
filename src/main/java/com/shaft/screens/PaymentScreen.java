package com.shaft.screens;

import com.mysql.cj.xdevapi.Schema;
import com.shaft.gui.element.TouchActions;
import com.shaft.validation.Validations;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PaymentScreen {
    AndroidDriver driver;
    private final By confirmLocationButton = By.xpath("(//android.widget.TextView[@text='CONFIRM LOCATION'])");
    private final By verifyMobile = By.xpath("(//android.widget.TextView[@text='Please verify your mobile number'])");
    PaymentScreen(AndroidDriver driver){
        this.driver=driver;
    }
    public void confirmLocation(String additionalAddress,String mobile){
//        new TouchActions().tap(confirmLocationButton)
//                .performElementAction().typeAppend(,additionalAddress)
//                .typeAppend(,mobile);
    }
    public void verifyMobileVisible(){
        Validations.assertThat().element(driver,verifyMobile).exists().perform();
    }

}
