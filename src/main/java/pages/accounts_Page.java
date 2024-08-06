package pages;

import base.driverContext;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.commonMethods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class accounts_Page {

    public accounts_Page() {
        PageFactory.initElements(driverContext.Driver, this);
    }

    commonMethods commonmethods = new commonMethods();

    private @FindBy(xpath = "//li[@data-target-selection-name='sfdc:StandardButton.Account.New']//div[@title='New'][normalize-space()='New']")
    WebElement NewButton;

    private @FindBy(xpath = "//span[@class='slds-form-element__label'][normalize-space()='Potential Club']")
    WebElement PotentialClubrecordType_element;
    private @FindBy(xpath = "//span[normalize-space()='Next']")
    WebElement NextButton;
    private @FindBy(xpath = "//button[@name='SaveEdit']")
    WebElement SaveButton;
    private @FindBy(xpath = "//input[@name='Name']")
    WebElement AccountNameField;
    private @FindBy(xpath = "//input[contains(@placeholder,'Search Accounts')]")
    WebElement BrokerField;



    private @FindBy(xpath = "(//input[contains(@placeholder,'Search User')])[1]")
    WebElement ExpansionmanagerField;
    private @FindBy(xpath = "(//input[contains(@placeholder,'Search User')])[2]")
    WebElement FieldExpansionmanagerField;
    private @FindBy(xpath = "//textarea[@name='street']")
    WebElement StreetField;
    private @FindBy(xpath = "//input[@name='city']")
    WebElement CityField;

    private @FindBy(xpath = "//input[@name='postalCode']")
    WebElement postalCodeField;
    private @FindBy(xpath = "//input[@name='country']")
    WebElement countryField;
    private @FindBy(xpath = "//input[@name='Building_number__c']")
    WebElement Building_numberField;
    private @FindBy(xpath = "//input[@name='city']")
    WebElement InputField;
    private @FindBy(xpath = "//span[contains(@class, 'toastMessage')]")
    WebElement AccountSave_ToastMessage;
    private @FindBy(xpath = "//*[@title='Add Club in GM']/descendant::button")
    WebElement AddClubInGM_Btn;
    private @FindBy(xpath = "//input[@value='Confirm']/following-sibling::label/span[@class='slds-radio_faux']")
    WebElement confirm_RadioBtn;
    private @FindBy(xpath = "//lightning-button[@class='slds-button flow-button__NEXT']")
    WebElement Next_Btn;
    private @FindBy(xpath = "//input[@name='Club_Commercial_Name__c']")
    WebElement ClubCommercialName_Field;
    private @FindBy(xpath = "//input[@name='Club_Area_Code']")
    WebElement ClubAreaCode_Field;
    private @FindBy(xpath = "//lightning-button[@class='slds-button flow-button__FINISH']")
    WebElement FinishButton;
    private @FindBy(xpath = "//iframe[@title='accessibility title']")
    WebElement accountDetailsFrame;
    private @FindBy(xpath = "//button[@title='Close Basic-Fit Lyon Test Automation | Account']")
    WebElement accountClose_Btn;










    Double TotalItemPrice=0.0;

    public static String getAccountName() {
        return accountName;
    }

    public static void setAccountName(String accountName1) {
        accountName = accountName1;
    }

    public static String accountName = "";
    List<Map<String, String>> accountDeatilsData;
    String recordType="";
    public void createNewAccount(DataTable accountDeatils)
    {   driverContext.Driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        accountDeatilsData= accountDeatils.asMaps(String.class, String.class);
        commonmethods.waitUntilWebElementToBeClickable(NewButton);
        NewButton.click();
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementToBeClickable(NextButton);
        commonmethods.scrollIntoTheViewAndClick(PotentialClubrecordType_element);
        NextButton.click();
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementIsVisible(SaveButton);
        commonmethods.staticWait(8000);
        commonmethods.waitUntilWebElementIsVisible(AccountNameField);
        AccountNameField.sendKeys(accountDeatilsData.get(0).get("AccountName"));
        BrokerField.sendKeys(accountDeatilsData.get(0).get("Broker"));
        BrokerField.click();
        commonmethods.staticWait(5000);
        commonmethods.waitUntilWebElementIsVisible(driverContext.Driver.findElement(By.xpath("//*[@title='SSCV Actigenay']")));
        driverContext.Driver.findElement(By.xpath("//*[@title='SSCV Actigenay']")).click();
        ExpansionmanagerField.sendKeys(accountDeatilsData.get(0).get("ExpansionManager"));
        ExpansionmanagerField.click();
        commonmethods.staticWait(7000);
        driverContext.Driver.findElement(By.xpath("//*[@title='"+accountDeatilsData.get(0).get("ExpansionManager")+"']")).click();
        commonmethods.staticWait(4000);
        commonmethods.waitUntilWebElementIsVisible(ExpansionmanagerField);
        ExpansionmanagerField.sendKeys(accountDeatilsData.get(0).get("FieldExpansionManager"));
        ExpansionmanagerField.click();
        commonmethods.staticWait(4000);
        commonmethods.waitUntilWebElementIsVisible(driverContext.Driver.findElement(By.xpath("//*[@title='"+accountDeatilsData.get(0).get("FieldExpansionManager")+"']")));
        driverContext.Driver.findElement(By.xpath("//*[@title='"+accountDeatilsData.get(0).get("FieldExpansionManager")+"']")).click();
        commonmethods.scrollIntoTheViewAndClick(StreetField);
        StreetField.sendKeys(accountDeatilsData.get(0).get("Street"));
        CityField.sendKeys(accountDeatilsData.get(0).get("City")+String.valueOf(commonmethods.generateRandomNumber(100)));
        postalCodeField.sendKeys(accountDeatilsData.get(0).get("PostalCode"));
        countryField.sendKeys(accountDeatilsData.get(0).get("Country"));
        Building_numberField.sendKeys(String.valueOf(commonmethods.generateRandomNumber(10000)));
        SaveButton.click();
        commonmethods.staticWait(4000);

    }

    public void veriyAccountcreation()
    {
        driverContext.Driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        commonmethods.waitForLoad();
        commonmethods.waitUntilWebElementIsVisible(AccountSave_ToastMessage);
        Assert.assertTrue(AccountSave_ToastMessage.getText().contains("was created"));
        commonmethods.staticWait(5000);
        Assert.assertTrue(driverContext.Driver.findElements(By.xpath("  //*[contains(text(),'Basic-Fit "+accountDeatilsData.get(0).get("City")+"')]")).size()>0);
        commonmethods.staticWait(8000);
        commonmethods.waitUntilWebElementIsVisible(driverContext.Driver.findElement(By.xpath("//div[contains(@class,'entityNameTitle')]/following-sibling::slot/lightning-formatted-text")));
        setAccountName(driverContext.Driver.findElement(By.xpath("//div[contains(@class,'entityNameTitle')]/following-sibling::slot/lightning-formatted-text")).getText());
        System.out.println();
    }

    public void verifyRecordTypeOfAccountCreated(String recordType)
    {
        commonmethods.staticWait(4000);
        commonmethods.scrollIntoTheViewAndClick(driverContext.Driver.findElement(By.xpath("//span[text()='Account Record Type']/ancestor::dt/following-sibling::dd/descendant::span[text()='"+recordType+"']")));
        Assert.assertTrue(driverContext.Driver.findElement(By.xpath("//span[text()='Account Record Type']/ancestor::dt/following-sibling::dd/descendant::span[text()='"+recordType+"']")).isDisplayed());
    }

    public void addClubInGM()
    {
        commonmethods.waitForLoad();
        commonmethods.staticWait(3000);
        commonmethods.waitUntilWebElementToBeClickable(AddClubInGM_Btn);
        commonmethods.clickByJS(AddClubInGM_Btn);
        commonmethods.staticWait(4000);
        commonmethods.waitUntilWebElementIsVisible(accountDetailsFrame);
        driverContext.Driver.switchTo().frame(accountDetailsFrame);
        commonmethods.waitUntilWebElementToBeClickable(confirm_RadioBtn);
        confirm_RadioBtn.click();
        Next_Btn.click();
        commonmethods.waitUntilWebElementToBeClickable(ClubCommercialName_Field);
        ClubCommercialName_Field.sendKeys(accounts_Page.getAccountName());
        ClubAreaCode_Field.sendKeys("Basic-Fit (BFFR.01.01)");
        Next_Btn.click();
        commonmethods.waitUntilWebElementToBeClickable(FinishButton);
        FinishButton.click();


    }
}
