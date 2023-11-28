package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;

public class Utility extends BaseTest {
    /**
     * This method will click on element
     */
    public void clickOnElement(By by){   // Locator return type is By and by is variable
        driver.findElement(by).click();
    }
    /**
     * This method will send keys to element
     */
    public void sendTextToElement(By by,String text){
        driver.findElement(by).sendKeys(text);
    }
    /**
     * This method is for getting the text
     */
    public String getTextElement(By by){
        return driver.findElement(by).getText();
    }
    /**
     * This method is to verify the text
     */
    public void verifyText(String displayMessage, String expectedText,String actualText){
        Assert.assertEquals(displayMessage,expectedText,actualText);
    }
}
