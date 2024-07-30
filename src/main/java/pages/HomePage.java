package pages;

import base.driverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.commonMethods;
import utilities.constant;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(driverContext.Driver, this);
    }
    private @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement Search_Item_Fld;
    private @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    WebElement Search_Button;

    commonMethods commonmethods=new commonMethods();

    public void verifyHomePageTitle()
    {
        commonmethods.verifyPageTitle(constant.HOME_PAGE_TITLE);
    }

    public void SearchForItem(String itemName) {
        commonmethods.sendKeysToWebElement(Search_Item_Fld,itemName);
        Search_Button.click();

    }
}
