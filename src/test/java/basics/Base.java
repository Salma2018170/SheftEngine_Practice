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
    @BeforeTest
    public void setUp()  {
        System.setProperty("targetOperatingSystem", "Android");
        System.setProperty("executionAddress", "0.0.0.0:4723");
        System.setProperty("openAllureReportAfterExecution","true");
        driver = (AndroidDriver) DriverFactory.getDriver();
    }

    @AfterTest
    public void teardown() {

        DriverFactory.closeAllDrivers();
    }
}
