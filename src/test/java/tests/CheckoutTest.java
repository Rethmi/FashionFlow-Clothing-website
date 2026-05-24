package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.DriverFactory;

public class CheckoutTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = DriverFactory.getDriver();

    }

    @Test
    public void checkoutProcess(){

        LoginPage login = new LoginPage(driver);
        login.login("standard_user","secret_sauce");

        InventoryPage inventory = new InventoryPage(driver);
        inventory.addProductToCart();
        inventory.openCart();

        CartPage cart = new CartPage(driver);
        cart.clickCheckout();

        CheckoutPage checkout = new CheckoutPage(driver);

        checkout.enterDetails("Janith","QA","80000");
        checkout.clickContinue();
        checkout.clickFinish();

    }

    @AfterMethod
    public void close(){

        driver.quit();

    }

}