package com.cybertek.library.step_difinitions;

import com.cybertek.library.pages.BasePage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.pages.Users_Module_Page;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class All_Step_Definitions {
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    Users_Module_Page users_module_page = new Users_Module_Page();
    Select select;


    @Given("User is on Library login {string} page")

    public void user_is_on_library_login_page(String environment) {

        Driver.getDriver().get(ConfigurationReader.getProperty(environment));

    }


    @Given("User login as a {string}")
    public void user_login_as_a(String role) {


        String userName = "";
        String password = "";
        switch (role) {
            case "student":
                userName = ConfigurationReader.getProperty("student95_user1");
                password = ConfigurationReader.getProperty("student95_password1");
                break;
            case "librarian":
                userName = ConfigurationReader.getProperty("lib22_user");
                password = ConfigurationReader.getProperty("lib22_password");
                break;
        }

        loginPage.inputEmail.sendKeys(userName);
        loginPage.inputPassword.sendKeys(password);
        loginPage.signInButton.click();


    }

    @When("User is on {string} module")
    public void user_is_on_module(String module) {

        switch (module) {
            case "Dashboard":
                basePage.dashboardPageLink.click();
                break;

            case "Users":
                basePage.usersPageLink.click();
                break;

            case "Books":
                basePage.booksPageLink.click();

        }
    }

    @When("User clicks {string} dropdown")
    public void user_clicks_dropdown(String dropDown) {

        switch (dropDown) {

            case "User Group":
                users_module_page.userGroupDropdown.click();

                break;
            case "Status":
                users_module_page.statusDropdown.click();

                break;

            case "Show":
                users_module_page.showDropdown.click();

        }
    }


    @Then("User should see the following dropdown options on {string} dropDown:")
    public void user_should_see_the_following_dropdown_options_on_drop_down(String dropDown,List<String> expectedDropdownOptions ) {


        switch (dropDown) {

            case "User Group":
                select = new Select(users_module_page.userGroupDropdown);

                break;
            case "Status":
                select = new Select(users_module_page.statusDropdown);

                break;

            case "Show":
                select = new Select(users_module_page.showDropdown);

        }



        List<WebElement> actualWebElements = select.getOptions();

        BrowserUtils.waitForVisibility(users_module_page.statusDropdown, 10);
        List<String> actualDropDownOptions = BrowserUtils.getElementsText(actualWebElements);

        System.out.println("expectedDropdownOptions = " + expectedDropdownOptions);
        System.out.println("actualDropDownOptions = " + actualDropDownOptions);
        Assert.assertEquals("DropDown options are different", expectedDropdownOptions, actualDropDownOptions);

        Driver.closeDriver();
    }






    @Then("Default records dropdown value is {string}")
    public void default_records_dropdown_value_is(String expectedRecordsNum) {
        select = new Select(users_module_page.showDropdown);

        String actualRecordsNum = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualRecordsNum, expectedRecordsNum);

        System.out.println("expectedRecordsNum = " + expectedRecordsNum);
        System.out.println("actualRecordsNum = " + actualRecordsNum);

        Driver.closeDriver();

    }



}