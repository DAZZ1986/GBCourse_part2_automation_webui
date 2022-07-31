package com.geekbrains.lesson2_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumStars {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.examclouds.com/ru/java/java-core-russian/lesson20");

        WebDriverManager.firefoxdriver().setup();
        WebDriver fireFoxDriver = new FirefoxDriver();
        fireFoxDriver.get("https://ya.ru");




        Thread.sleep(5000);
        chromeDriver.quit();  //закрывает весь браузер
        //driver.close(); //закрывает вкладку браузера
        fireFoxDriver.quit();

    }
}
