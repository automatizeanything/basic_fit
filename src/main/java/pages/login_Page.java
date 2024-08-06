package pages;

import base.driverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.commonMethods;
import utilities.utilityFecthProperty;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class login_Page {

    public login_Page() {
        PageFactory.initElements(driverContext.Driver, this);
    }

    commonMethods commonmethods = new commonMethods();

    private @FindBy(css = "input[id='username']")
    WebElement userNameField;
    private @FindBy(css = "input[id='password']")
    WebElement password_Field;
    private @FindBy(css = "input[id='Login']")
    WebElement LoginButton_Field;
    private @FindBy(xpath = "//a[@href='/lightning/o/Account/home']")
    WebElement Accounts_Link;

    public void performLogin(String username) throws IOException {

            commonmethods.staticWait(10000);
            userNameField.sendKeys(username);
            password_Field.sendKeys(utilityFecthProperty.fetchPropertyValue(username));
            LoginButton_Field.click();
            driverContext.Driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            commonmethods.waitForLoad();
    }

    public void navigateToAccountsPage()
    {
        commonmethods.staticWait(20000);
        /*JavascriptExecutor js = (JavascriptExecutor) driverContext.Driver;
        js.executeScript("arguments[0].click();", Accounts_Link);*/
        System.out.println();
    }


}
