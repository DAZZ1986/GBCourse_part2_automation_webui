package com.geekbrains.lesson2_3.DZ;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MmprodTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
        opt.addArguments("--start-fullscreen");

        //https://mmprod.ru mmprod.ru@yandex.ru 43214321
        WebDriver chromeDriver = new ChromeDriver(opt);
        chromeDriver.get("https://mmprod.ru");
        WebElement authBtn = chromeDriver.findElement(By.xpath("//div[@class='header-content']//ul[@class='login-nav']//li[@class='user-item']/a[text()='Вход']"));
        authBtn.click();
        WebElement login = chromeDriver.findElement(By.id("loginform-email"));
        login.sendKeys("mmprod.ru@yandex.ru");
        WebElement pass = chromeDriver.findElement(By.id("loginform-password"));
        pass.sendKeys("43214321");
        WebElement logBtn = chromeDriver.findElement(By.xpath("//button[@name='login-button']"));
        logBtn.click();
        Thread.sleep(2000);
        WebElement cabinetBtn = chromeDriver.findElement(By.xpath("//ul[@class='login-nav']//a[@href='/user/cabinet/view']"));
        cabinetBtn.click();





        Thread.sleep(5000);
        chromeDriver.quit();

    }
}
