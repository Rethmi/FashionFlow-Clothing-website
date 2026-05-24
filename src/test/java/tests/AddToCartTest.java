package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.InventoryPage;
import pages.LoginPage;
import utils.DriverFactory;

public class AddToCartTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = DriverFactory.getDriver();

    }

    @Test
    public void addProductToCart(){

        LoginPage login = new LoginPage(driver);
        login.login("standard_user","secret_sauce");

        InventoryPage inventory = new InventoryPage(driver);

        inventory.addProductToCart();
        inventory.openCart();

    }

    @AfterMethod
    public void close(){

        driver.quit();

    }

}