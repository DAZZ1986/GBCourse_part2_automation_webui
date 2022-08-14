package com.geekbrains.lesson6.DZ6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class POTestFindRecipeWithSausages {
    WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
        opt.addArguments("--start-fullscreen");

        driver = new ChromeDriver(opt);
        driver.get("https://mmprod.ru/");
    }



    @Test   //поиск рецепта с ингредиентом "Сосиска"
    void findRecipeWithSausages() throws InterruptedException {
        //можно создать объект через new, без переменной - вариант 1.
        //new MainPageMmprod(driver).signInButton.click();   //вызов локатора через переменную уже не вызовем тк сделали его private
        //new MainPageMmprod(driver).clickSignInButton();    //вызов локатора через метод

        //можно создать объект через переменную - вариант 2
        MainPageMmprod mainPage = new MainPageMmprod(driver);   //создали экз. гл.стр. и нажали кнопку "Вход"
        mainPage.clickSignInButton();

        new LoginPage(driver).login("mmprod.ru@yandex.ru", "43214321"); //вводим логин, пароль, жмем войти

        new MainMenuBlock(driver).ingredientsButton(); //зашли в раздел "Поиск по ингредиентам"

        new FindByIngredientsPage(driver).ingredientsCheck(); // выбрали чекбокс на пункте "Сосиски", нажали
        // "Подобрать ингредиенты".

        Thread.sleep(5000);
    }




    @AfterEach
    void killBrowser() {
        driver.quit();
    }
}
