package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.cart_Page;
import pages.results_Page;

public class addItem {
    HomePage hp=new HomePage();
    results_Page result=new results_Page();
    cart_Page cart=new cart_Page();

    @And("selects the {string} item and add the item to the cart")
    public void selectsTheFirstItemAndAddTheItemToTheCart(String ItemNumber) {
        result.addItemToart(ItemNumber);
    }

    @Given("user is on the Amazon home Page")
    public void userIsOnTheAmazonHomePage() {
        hp.verifyHomePageTitle();
    }

    @When("the user searches for the {string} item")
    public void theUserSearchesForTheMonitorItem(String ItemName) {
        hp.SearchForItem(ItemName);
    }

    @Then("the user verifies that the item price is identical to the product page")
    public void theUserVerifiesThatTheItemPriceIsIdenticalToTheProductPage() {
        cart.verifyItemPrice();
    }

    @And("also the the sub total is identical to the item price in the product page")
    public void alsoTheTheSubTotalIsIdenticalToTheItemPriceInTheProductPage() {
        cart.verifySubTotalAmount();
    }


    @Then("the user navigates to the Cart Page")
    public void theUserNavigatesToTheCartPage() {
        result.navigateTocart();
    }
}
