package pages;

import base.driverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class cart_Page {

    public cart_Page() {
        PageFactory.initElements(driverContext.Driver, this);
    }


    private @FindBy(xpath = "//li[@class='a-spacing-mini sc-item-product-title-cont']/descendant::span[@class='a-truncate-cut']")
    List<WebElement> ItemName_cart_Lbl;
    private @FindBy(xpath = "//span[@id='sc-subtotal-amount-activecart']/descendant::span[contains(@class,'sc-price')]")
    WebElement SubTotalCart_Lbl;
    private @FindBy(xpath = "//div[@class='sc-item-price-block']/descendant::span[contains(@class,'sc-product-price')]")
    List<WebElement> ItemPriceCart_Lbl;
    Double TotalItemPrice=0.0;

    public void verifyItemPrice() {
        for(int i=0;i<ItemName_cart_Lbl.size();i++) {
            for (String ele : results_Page.ItemPriceData.keySet()) {
                if (ele.contains(ItemName_cart_Lbl.get(i).getText().replace("…",""))) {
                    Assert.assertTrue(results_Page.ItemPriceData.get(ele).equals(Double.parseDouble(ItemPriceCart_Lbl.get(i).getText().replace(",",""))), "Values are not equal");

                }
            }
        }



    }

    public void verifySubTotalAmount() {
        for(Double total:results_Page.ItemPriceData.values())
            TotalItemPrice+=total;
        Assert.assertEquals(TotalItemPrice, Double.parseDouble(SubTotalCart_Lbl.getText().replace(",","")), "Cost are not equal");
        results_Page.ItemPriceData.clear();
    }
}
