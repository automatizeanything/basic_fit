package utilities;

import base.driverContext;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;

public class commonMethods {

    protected WebDriverWait wait;


    public commonMethods() {
        this.wait = new WebDriverWait(driverContext.Driver, Duration.ofSeconds(Long.parseLong(constant.TIME_OUT)));

    }

    public  void verifyPageTitle(String expectedTitle) {
        String actualTitle = driverContext.Driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match expected title");
    }

    public void waitUntilWebElementIsVisible(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException | TimeoutException e) {

            System.out.println("WebElement is NOT visible, Exception: " + e.getMessage());
        }
    }

    public void sendKeysToWebElement(WebElement element, String textToSend) {
        try {
            this.waitUntilWebElementIsVisible(element);
            element.clear();
            element.sendKeys(textToSend);
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("Unable to send keys to WebElement, Exception: " + e.getMessage());
        }
    }

    public void waitUntilWebElementToBeClickable(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (NoSuchElementException | TimeoutException e) {

            System.out.println("WebElement is NOT visible, Exception: " + e.getMessage());
        }
    }
    public void clickByJS(WebElement element) {
        JavascriptExecutor jsExecutor=((JavascriptExecutor) driverContext.Driver);
        jsExecutor.executeScript("arguments[0].click();", element);
    }
    public void scrollIntoTheViewAndClick(WebElement element) {
        ((JavascriptExecutor) driverContext.Driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitUntilWebElementIsVisible(element);
        clickByJS(element);
    }
}
