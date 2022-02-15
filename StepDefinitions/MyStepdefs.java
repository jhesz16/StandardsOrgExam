package StepDefinitions;

import Helpers.GlobalHelpers;
import Pages.CallBackForm;
import Pages.Home;
import Pages.HomeLoans;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

import java.io.IOException;

import static Driver.Setup.*;

public class MyStepdefs {
    public GlobalHelpers helpers;
    public Home home;
    public HomeLoans homeLoans;
    public CallBackForm callBackForm;

    @Given("The user go to Nab Website")
    public void theUserGoToNabWebsite() throws IOException {
        getDriver(getBrowser());
        home = new Home();
        homeLoans = new HomeLoans();
        helpers = new GlobalHelpers();
        callBackForm = new CallBackForm();
    }

    @And("User to view all home loans")
    public void userToViewAllHomeLoans() {
        home.navigateTo("homeLoans");
    }

    @And("User Requests a call back")
    public void userRequestsACallBack() {
        homeLoans.clickRequestACallBack();
    }

    @And("User clicks New Home Loans")
    public void userClicksNewHomeLoans() throws InterruptedException {
        homeLoans.clickNewHomeLoans();
    }

    @And("User is Buying a property")
    public void userIsBuyingAProperty() throws InterruptedException{
        homeLoans.clickBuyingANewProperty();
    }

    @And("user click Next for first form")
    public void userClickNextForFirstForm() throws InterruptedException {
        homeLoans.clickNext();
    }


    @And("user click Next for second form")
    public void userClickNextForSecondForm() throws InterruptedException {
        homeLoans.clickNext2();
    }

    @When("User fills up the call back form with valid data")
    public void userFillsUpTheCallBackFormWithValidData() {
        callBackForm.areYouAnExistingCustomer("No");
        callBackForm.fillForm("JC","Martin","ACT","0400000000","testEmail@a.com");

    }

    @Then("User should be able to submit the form")
    public void userShouldBeAbleToSubmitTheForm() {
        callBackForm.clickSubmit();
    }


    @And("Received page should be displayed")
    public void receivedPageShouldBeDisplayed() {
        Assert.assertTrue(callBackForm.validateThankYouHeader());
    }

    @After("@Feature")
    public void testStart() throws Throwable {
        killDriver();
    }
}
