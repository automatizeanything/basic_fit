package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.accounts_Page;

public class accountsPageSteps {

    accounts_Page accountPage=new accounts_Page();

    @And("then creates a new account with following details")
    public void thenCreatesANewAccountWithFollowingDetailsRecordTypeAs(DataTable accountDetails) {
        accountPage.createNewAccount(accountDetails);
    }


    @And("I verify that the account is successfully created")
    public void iVerifyThatTheAccountIsSuccessfullyCreated() {
        accountPage.veriyAccountcreation();
    }

    @And("I verify the account is getting created with Record Type as {string}")
    public void iVerifyTheAccountIsGettingCreatedWithRecordTypeAs(String recordType) {
        accountPage.verifyRecordTypeOfAccountCreated(recordType);
    }

    @And("I add the Club to GM")
    public void iAddTheClubToGM() {
        accountPage.addClubInGM();
    }
}
