package pages;

import base.driverContext;
import io.cucumber.java.sl.In;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.commonMethods;

import java.util.HashMap;

public class results_Page {

    public results_Page() {
        PageFactory.initElements(driverContext.Driver, this);
    }
    //private @FindBy(xpath = "(//div[contains(@cel_widget_id,'MAIN-SEARCH_RESULTS')]/span/descendant::div[@data-cy='title-recipe']/descendant::span)[1]")

    private @FindBy(xpath = "(//div[contains(@cel_widget_id,'MAIN-SEARCH_RESULTS')]/descendant::div[@data-cy='title-recipe']/descendant::h2/descendant::span)[1]")
    WebElement Item_name_Lbl;
    private @FindBy(xpath = "(//div[contains(@cel_widget_id,'MAIN-SEARCH_RESULTS')]/descendant::span[@class='a-price-whole'])[1]")
    WebElement Item_Price_Lbl;
    private @FindBy(xpath = "(//div[contains(@cel_widget_id,'MAIN-SEARCH_RESULTS')]/descendant::button[text()='Add to cart'])[1]")
    WebElement AddToCart_Btn;
    private @FindBy(xpath = "//div[@id='nav-cart-count-container']")
    WebElement Cart_Btn;
    private @FindBy(xpath = "//a[contains(text(),'Go to Cart')]")
    WebElement GoToCart_Btn;



    commonMethods commonmethods=new commonMethods();

    public static String ItemName="";
    public static Double ItemPrice=0.0;
    public static HashMap<String,Double> ItemPriceData=new HashMap<>();

    public void addItemToart(String ItemNumber) {
        ItemName=driverContext.Driver.findElement(By.xpath("(//div[contains(@cel_widget_id,'MAIN-SEARCH_RESULTS')]/descendant::div[@data-cy='title-recipe']/descendant::h2/descendant::span)["+ItemNumber+"]")).getText();
        ItemPrice = Double.parseDouble(driverContext.Driver.findElement(By.xpath("(//div[contains(@cel_widget_id,'MAIN-SEARCH_RESULTS')]/descendant::span[@class='a-price-whole'])["+ItemNumber+"]")).getText().replace(",",""));
        ItemPriceData.put(ItemName,ItemPrice);

        WebElement AddToCart=driverContext.Driver.findElement(By.xpath("(//div[contains(@cel_widget_id,'MAIN-SEARCH_RESULTS')]/descendant::button[text()='Add to cart'])["+ItemNumber+"]"));
        commonmethods.waitUntilWebElementIsVisible(AddToCart);
        AddToCart.click();
        commonmethods.waitUntilWebElementToBeClickable(AddToCart);
        commonmethods.waitUntilWebElementIsVisible(GoToCart_Btn);
    }

    public void navigateTocart() {

        commonmethods.waitUntilWebElementToBeClickable(Cart_Btn);
        commonmethods.scrollIntoTheViewAndClick(Cart_Btn);
    }
}
