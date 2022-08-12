package com.geekbrains.lesson6.DZ6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FindByIngredientsPage extends BasePage{
    public FindByIngredientsPage(WebDriver driverCtor) {
        super(driverCtor);
    }

    //div[@class='ingredient-select']//label[@for='ingredient-9861']
    //private final String enterBtnLocator = "search-button";
    @FindBy (xpath = "//label[@for='ingredient-9861']")
    private WebElement findCheckboxSausages;
    @FindBy (id = "search-button")
    private WebElement enterButton;

    public void ingredientsCheck() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='ingredient-9861']"))); //суда передаем локатор
        findCheckboxSausages.click();
        //webDriverWait.until(ExpectedConditions.visibilityOf(enterButton));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-button"))); //суда передаем локатор
        enterButton.click();
    }










}
