package com.geekbrains.lesson6.DZ6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPageMmprod extends BasePage{

    @FindBy(xpath = "//div[@class='header-content']//ul[@class='login-nav']//li[.='Вход']")
    private WebElement signInButton;

    public MainPageMmprod(WebDriver driverCtor) {
        super(driverCtor);
    }

    public void clickSignInButton() {
        signInButton.click();
    }














}
