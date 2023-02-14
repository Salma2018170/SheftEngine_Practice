package basics;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.URL;


public class Base {
    AndroidDriver driver;
    @Test
    public void setUp() throws Exception {
        System.setProperty("targetOperatingSystem", "Android");
        System.setProperty("executionAddress", "0.0.0.0:4723");
        UiAutomator2Options options=new UiAutomator2Options()
                .setPlatformName(System.getProperty("targetOperatingSystem"))
                .setAutomationName(System.getProperty("mobile_automationName"))
                .setDeviceName(System.getProperty("mobile_deviceName"))
                .setAppPackage(System.getProperty("mobile_appPackage"))
                .setAppActivity(System.getProperty("mobile_appActivity"));
        driver = new AndroidDriver(new URL("http://"+System.getProperty("executionAddress")), options);
    }
}
