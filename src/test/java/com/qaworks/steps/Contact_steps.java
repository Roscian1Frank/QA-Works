package com.qaworks.steps;


import com.qaworks.Web.pages.Contact_page;
import com.qaworks.helpers.Constants;
import com.qaworks.helpers.Log;
import com.qaworks.helpers.WebCommonAction;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static com.qaworks.steps.WebTestBase.driver;

public class Contact_steps extends WebCommonAction {
    public Contact_steps() {
        PageFactory.initElements(driver, Contact_page.class);
    }

    private static final String site = System.getProperty("site");

    @Given("^I am on the QAWorks Site$")
    public void iAmOnTheQAWorksSite() throws Throwable {
        driver.get(site);
        driver.manage().window().maximize();
        Log.info("I am on home page");
    }

    @Then("^I should be able to contact QAWorks with the following information$")
    public void iShouldBeAbleToContactQAWorksWithTheFollowingInformation(Map<String, String> responseFields) throws Throwable {
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            switch (field.getKey()) {
                case "name":
                    Contact_page.name_input_box.sendKeys(field.getValue());
                    Log.info("Name entered in name field");
                    break;
                case "email":
                    Contact_page.email_input_box.sendKeys(field.getValue());
                    Log.info("Email entered in Email field");
                    break;
                case "message":
                    Contact_page.message_input_box.sendKeys(field.getValue());
                    Log.info("Message entered in message field");
                    break;
                default:
                    Assert.assertTrue("Expected value not found instead found: " + field.getKey(), false);
            }
        }
        Contact_page.send_button.click();
        Log.info("Send message button clicked");

    }

    @And("^I am not receiving any confirmation message$")
    public void iAmNotReceivingAnyConfirmationMessage() throws Throwable {
        Assert.assertFalse("Unexpected alert is visible on the page", waitForAlertAndAcceptAlert(driver, 5));
        Log.info("Expected Alert is not visible");
    }

    @And("^I got server error$")
    public void iGotServerError() throws Throwable {
        Assert.assertFalse("We need to resolve 500 server error,When email is in format", Constants.SERVER_ERROR.equalsIgnoreCase(Contact_page.serverError.getText()));
        Log.info("500 server error");
    }

    @And("^I confirm message is sent$")
    public void iConfirmMessageIsSent() throws Throwable {
        Assert.assertTrue("Not able to message", Contact_page.name_input_box.getText().isEmpty());
        Assert.assertTrue("Not able to message", Contact_page.email_input_box.getText().isEmpty());
        Assert.assertTrue("Not able to message", Contact_page.message_input_box.getText().isEmpty());
        Log.info("Message send successfully");
    }

    @And("^I check correct error message is displayed$")
    public void iCheckCorrectErrorMessageIsDisplayed() throws Throwable {
        ArrayList<String> webArray = new ArrayList<>();
        webArray.addAll(Contact_page.errorMessage.stream().map(WebElement::getText).collect(Collectors.toList()));
        Assert.assertTrue("Correct error message is not displayed", webArray.containsAll(Arrays.asList(Constants.listOfErrors)));
        Log.info("Error message confirmed");
    }
}
