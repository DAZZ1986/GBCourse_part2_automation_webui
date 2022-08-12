package com.geekbrains.lesson6.DZ6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenuBlock extends BasePage {

    public MainMenuBlock(WebDriver driverCtor) {
        super(driverCtor);
    }

    //b[.='Поиск по ингредиентам']
    //div[@class='ingredient-header-search header-menu-item']
    @FindBy (xpath = "//div[@class='ingredient-header-search header-menu-item']")
    private WebElement findIngredientButton;

    public void ingredientsButton() {
        findIngredientButton.click();
    }

}
