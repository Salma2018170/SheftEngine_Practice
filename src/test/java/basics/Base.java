package basics;

import com.shaft.driver.DriverFactory;
import com.shaft.driver.SHAFT;
import com.shaft.screens.LocationScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;


public class Base {
   protected AndroidDriver driver;
   protected LocationScreen locationScreen;
    //@BeforeTest
    public void setUp() throws Exception {
        System.setProperty("targetOperatingSystem", "Android");
        System.setProperty("executionAddress", "0.0.0.0:4723");
        //System.setProperty("mobile_appPackage","com.noon.buyerapp");
        //System.setProperty("mobile_appActivity","com.noon.buyerapp.MainActivity");
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName(System.getProperty("targetOperatingSystem"))
                .setAutomationName(System.getProperty("mobile_automationName"))
                .setDeviceName(System.getProperty("mobile_deviceName"))
                .setAppPackage(System.getProperty("mobile_appPackage"))
                .setAppActivity(System.getProperty("mobile_appActivity"));
        driver = new AndroidDriver(new URL("http://" + System.getProperty("executionAddress")), options);
       // driver = (AndroidDriver) DriverFactory.getDriver();
        locationScreen = new LocationScreen(driver);
    }
    @BeforeTest
    public void setUpTry()  {

        System.setProperty("targetOperatingSystem", "Android");
        System.setProperty("mobile_deviceName", "4DSWVK4LCQORAI8H");
        System.setProperty("mobile_appPackage","com.noon.buyerapp");
        System.setProperty("mobile_appActivity","com.noon.buyerapp.MainActivity");
        System.setProperty("executionAddress", "0.0.0.0:4723");
        driver = (AndroidDriver) DriverFactory.getDriver();
    }


    @AfterTest
    public void teardown() {
        DriverFactory.closeAllDrivers();
    }
}
