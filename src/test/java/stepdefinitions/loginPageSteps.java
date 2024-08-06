package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.login_Page;

import java.io.IOException;

public class loginPageSteps {

    login_Page lp=new login_Page();

    @Given("I am in the login page of fit bit application")
    public void iAmInTheLoginPageOfFitBitApplication() {
    }

    @When("I login into fit application as {string}")
    public void iLoginIntoFitApplicationAs(String userName) throws IOException {
        lp.performLogin(userName);
    }

    @Then("I can navigate to Accounts page")
    public void iCanNavigateToAccountsPage() {
        lp.navigateToAccountsPage();
    }


}
