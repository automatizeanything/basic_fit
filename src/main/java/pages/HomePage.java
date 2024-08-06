package pages;

import base.driverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.commonMethods;
import utilities.constant;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(driverContext.Driver, this);
    }
    private @FindBy(xpath = "//button[@aria-label='Search']/parent::div")
    WebElement Search_Item_Fld;
    private @FindBy(xpath = "//a[@href='/secur/logout.jsp']")
    WebElement logout_Label;
    private @FindBy(xpath = "//input[contains(@placeholder,'Search')]/ancestor::lightning-input")
    WebElement extendedSearch_Field;

    private @FindBy(xpath = "//button[contains(@title,'Close Basic-Fit ')]")
    List<WebElement> close_Btns;






    commonMethods commonmethods=new commonMethods();
    accounts_Page ap=new accounts_Page();
    public void verifyHomePageTitle()
    {
        commonmethods.verifyPageTitle(constant.HOME_PAGE_TITLE);
    }

    public void SearchForItem() {
        driverContext.Driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        commonmethods.waitForLoad();
        commonmethods.staticWait(8000);
        for(WebElement ele: close_Btns)
        {
            commonmethods.clickByJS(ele);
            commonmethods.staticWait(2000);
        }
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementIsVisible(Search_Item_Fld);
        Search_Item_Fld.click();
        commonmethods.staticWait(7000);
       // Search_Item_Fld.click();
        //To be deleted below line
       // accounts_Page.setAccountName("Basic-Fit Paris Test Automation");
        commonmethods.waitUntilWebElementIsVisible(extendedSearch_Field);
        commonmethods.staticWait(2000);
        extendedSearch_Field.sendKeys(accounts_Page.getAccountName());
        commonmethods.staticWait(5000);
        if(driverContext.Driver.findElements(By.xpath("(//span[@title='"+accounts_Page.getAccountName()+"'])[1]")).size()<1)
        {
            Search_Item_Fld.click();
            extendedSearch_Field.sendKeys(accounts_Page.getAccountName());
            commonmethods.staticWait(5000);
            driverContext.Driver.findElement(By.xpath("(//span[@title='"+accounts_Page.getAccountName()+"'])[1]")).click();
        }
        else
            driverContext.Driver.findElement(By.xpath("(//span[@title='"+accounts_Page.getAccountName()+"'])[1]")).click();
        System.out.println();

    }



    public void performLogout() {
        commonmethods.waitUntilWebElementToBeClickable(logout_Label);
        logout_Label.click();
        System.out.println();

    }
}
