package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Users_Module_Page {

    public Users_Module_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id="user_groups")
    public WebElement userGroupDropdown;


    @FindBy(id="user_status")
    public WebElement statusDropdown;


    @FindBy(name="tbl_users_length")
    public WebElement showDropdown;

}
