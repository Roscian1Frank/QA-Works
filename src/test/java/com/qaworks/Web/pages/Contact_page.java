package com.qaworks.Web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Contact_page {
    @FindBy(id = "ctl00_MainContent_NameBox")
    public static WebElement name_input_box;

    @FindBy(id = "ctl00_MainContent_EmailBox")
    public static WebElement email_input_box;

    @FindBy(id = "ctl00_MainContent_MessageBox")
    public static WebElement message_input_box;

    @FindBy(id = "ctl00_MainContent_SendButton")
    public static WebElement send_button;

    @FindBy(xpath = "//h1")
    public static WebElement serverError;
}
