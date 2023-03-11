package com.shaft.testcase;

import basics.Base;
import com.shaft.screens.*;
import jdk.jfr.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.JsonReader;

import java.io.IOException;
import java.text.ParseException;


public class LogInTestCase extends Base {

    ViewItemDetailsScreen viewItemDetailsScreen;
    HomeScreen homeScreen;
    CartScreen cartScreen;
    LoginScreen loginScreen;
    PaymentScreen paymentScreen;

    @Description("confirm location and search for items")
    @Test
    public void TC1() {
        locationScreen = new LocationScreen(driver);

        homeScreen = locationScreen.confirmYourLocation();
        viewItemDetailsScreen = homeScreen.searchForItemsSection();
        //homeScreen.searchForSpecificItem();
    }

    @Description("Add item to cart")
    @Test(dependsOnMethods = "TC1")
    public void TC2() {
        viewItemDetailsScreen.readItemDetails();
        cartScreen = viewItemDetailsScreen.addItemToCart();
    }

    @DataProvider(name = "login data")
    public Object[][] passData() throws IOException, ParseException, org.json.simple.parser.ParseException {
        return JsonReader.getJSONData(System.getProperty("user.dir") + "/data/LoginData.json", "Users", 2);
    }

    @Description("Checkout and login ")
    @Test(dataProvider = "login data", dependsOnMethods = {"TC1", "TC2"})
    public void TC3(String email, String password) {
        loginScreen = cartScreen.checkOut();
        loginScreen.setEmail(email);
        loginScreen.setPassword(password);
        paymentScreen = loginScreen.clickSigInButton();
    }
    @Description("verify mobile number")
    @Test(dependsOnMethods = {"TC1", "TC2","TC3"})
    public void TC4() {
     paymentScreen.verifyMobileVisible();
    }

}
