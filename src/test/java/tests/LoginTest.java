package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = DriverFactory.getDriver();

    }

    @Test
    public void loginTest(){

        LoginPage login = new LoginPage(driver);

        login.login("standard_user","secret_sauce");

    }

    @AfterMethod
    public void close(){

        driver.quit();

    }

}