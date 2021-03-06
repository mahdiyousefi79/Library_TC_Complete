package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath="//span[.='Users']")     // or linkText = "Users"
    public WebElement usersPageLink;

    @FindBy(linkText = "Dashboard")               // or //span[@class='title']
    public WebElement dashboardPageLink;

    @FindBy(linkText = "Books")
    public WebElement booksPageLink;


    @FindBy(id = "navbarDropdown")
    public WebElement dropdownLogout;

    @FindBy(linkText = "Log Out")
    public WebElement linkLogout;


    @FindBy(id = "menu_item")
    public WebElement navLinksContainer;
}
