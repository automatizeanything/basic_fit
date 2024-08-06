package stepdefinitions;

import io.cucumber.java.en.And;
import pages.HomePage;

public class homePageSteps {

    HomePage hp=new HomePage();
    @And("I perform logout")
    public void iPerformLogout() {
        hp.performLogout();
    }

    @And("I search for the created account")
    public void iSearchForTheCreatedAccount() {
        hp.SearchForItem();
    }
}
