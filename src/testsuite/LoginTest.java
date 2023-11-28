package testsuite;
/**
 * Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValid Credentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed on page
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSucessfullyWithValidCredentials() {
        //Enter “standard_user” username
        sendTextToElement(By.id("user-name"), "standard_user");

        //Enter “secret_sauce” password
        sendTextToElement(By.id("password"), "secret_sauce");

        //Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));

        //Verify the text “PRODUCTS”
        verifyText("Invalid Text", "Products", getTextElement(By.xpath("//span[text()='Products']")));

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter “standard_user” username
        sendTextToElement(By.id("user-name"), "standard_user");

        // Enter “secret_sauce” password
        sendTextToElement(By.id("password"), "secret_sauce");

        //Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));

        //Verify that six products are displayed on page
        List<WebElement> actualElements = driver.findElements(By.className("inventory_item"));
        int actualNumbers = actualElements.size();
        Assert.assertEquals("Doesn't match",6,actualNumbers);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
