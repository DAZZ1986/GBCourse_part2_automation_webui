package com.geekbrains.lesson6.DZ6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait webDriverWait;    //объект нужен для установки ожиданий
    Actions actions;                //объект нужен для наведения мыши на что либо

    public BasePage(WebDriver driverCtor) {
        this.driver = driverCtor;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this); //
    }
}
