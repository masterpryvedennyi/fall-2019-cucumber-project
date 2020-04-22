package com.cybertek.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UsersPage extends PageBase{

    @FindBy(name = "tbl_users_length")
    public WebElement showRecords;

    @FindBy(css = "a.btn-lg")
    public WebElement addUser;

    @FindBy(name = "full_name")
    public WebElement fullName;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(name = "email")
    public WebElement email;

    @FindBy(id = "address")
    public WebElement address;

    public Select getShowRecords(){
        return new Select(showRecords);
    }
}
