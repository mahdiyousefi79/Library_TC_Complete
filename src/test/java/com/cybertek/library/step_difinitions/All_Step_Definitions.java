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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class All_Step_Definitions  {
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    Users_Module_Page users_module_page = new Users_Module_Page();
    Select select;




    private String getCurrentPage(){
        String url = Driver.getDriver().getCurrentUrl();
        return url.substring(url.lastIndexOf("/") + 1);
    }







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
                userName = ConfigurationReader.getProperty("student95_user");
                password = ConfigurationReader.getProperty("student95_password");
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


    @Then("User is on {string} page")
    public void user_is_on_page(String expectedPage) {
        BrowserUtils.wait(5);
        String actualPage = getCurrentPage();
        System.out.println("actualPage = " + actualPage);
        Assert.assertEquals(expectedPage, actualPage);
        //Driver.closeDriver();                  // Because it should be login two times with different roles we should close driver unless it would be get error
    }



    @When("User loges out from app")
    public void user_loges_out_from_app() {



        // this DropDown is simple Html one not selected one
        basePage.dropdownLogout.click();
        BrowserUtils.wait(2);
        basePage.linkLogout.click();


    }




    @Then("User is on Login page")
    public void user_is_on_login_page() {
        String expectedPage = "login.html";
        String actualPage = getCurrentPage();

        System.out.println("actualPage = " + actualPage);
        Assert.assertEquals(expectedPage, actualPage);
    }


    @Given("User login with credentials {string} and {string}:")
    public void user_login_with_credentials_and(String username, String password) {
        loginPage.inputEmail.sendKeys(username);
        loginPage.inputPassword.sendKeys(password);
        BrowserUtils.wait(2);
        loginPage.signInButton.click();
    }




    @Then("User should see following modules:")
    public void user_should_see_following_modules(List<String> expectedModules) {

    List<WebElement> actualModulesAsWebElements  = basePage.navLinksContainer.findElements(By.xpath("//span[@class='title']"));

    List<String> actualModulesAsString = BrowserUtils.getWebElementsText(actualModulesAsWebElements);

        System.out.println("actualModulesAsString = " + actualModulesAsString);

        Assert.assertEquals(actualModulesAsString,expectedModules);


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
        List<String> actualDropDownOptions = BrowserUtils.getWebElementsText(actualWebElements);

        System.out.println("expectedDropdownOptions = " + expectedDropdownOptions);
        System.out.println("actualDropDownOptions = " + actualDropDownOptions);
        Assert.assertEquals("DropDown options are different", expectedDropdownOptions, actualDropDownOptions);


    }






    @Then("Default records dropdown value is {string}")
    public void default_records_dropdown_value_is(String expectedRecordsNum) {
        select = new Select(users_module_page.showDropdown);

        String actualRecordsNum = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualRecordsNum, expectedRecordsNum);

        System.out.println("expectedRecordsNum = " + expectedRecordsNum);
        System.out.println("actualRecordsNum = " + actualRecordsNum);



    }



}